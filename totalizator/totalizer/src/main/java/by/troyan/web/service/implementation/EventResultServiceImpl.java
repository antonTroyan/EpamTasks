package by.troyan.web.service.implementation;

import by.troyan.web.dao.*;
import by.troyan.web.dao.exception.DAOException;
import by.troyan.web.dao.factory.DAOFactory;
import by.troyan.web.entity.EventResult;
import by.troyan.web.entity.Rate;
import by.troyan.web.exception.EventResultException;
import by.troyan.web.service.EventResultService;
import by.troyan.web.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * EventResultService implementation. Describe method works with EventResults.
 */

public class EventResultServiceImpl implements EventResultService {
    private final static Logger LOG = LogManager.getLogger(EventResultServiceImpl.class);
    private static final EventResultServiceImpl instance = new EventResultServiceImpl();

    EventResultDAO eventResultDAO;
    EventDAO eventDAO;
    RateDAO rateDAO;
    UserDAO userDAO;

    public static EventResultService getInstance(){
        return instance;
    }

    private EventResultServiceImpl(){
        eventResultDAO = DAOFactory.getFactory().getEventResultDAO();
        eventDAO = DAOFactory.getFactory().getEventDAO();
        rateDAO = DAOFactory.getFactory().getRateDAO();
        userDAO = DAOFactory.getFactory().getUserDAO();
    }

    private int checkInt(String stringValue, EventResultException eventResultException, String errorMessage){
        int intValue;
        try{
            intValue = Integer.parseInt(stringValue);
            return intValue;
        } catch (NumberFormatException exc){
            eventResultException.addErrorMessage(errorMessage);
            return 0;
        }
    }


    @Override
    public EventResult addRandomResultToEvent(String eventId) throws ServiceException, EventResultException {
        EventResult eventResult = new EventResult();
        EventResultException eventResultException = new EventResultException(eventResult);
        eventResult.setEventId(checkInt(eventId, eventResultException, "err.event-id-is-invalid"));
        eventResult.setWinnerScore(randomDetermineWinnerAndLooserScore()[0]);
        eventResult.setLoserScore(randomDetermineWinnerAndLooserScore()[1]);

        if(eventResultException.getErrorMessageList().size() > 0){
            throw eventResultException;
        }
        try{
            eventResultDAO.addEventResult(eventResult);
            eventDAO.finishEvent(eventResult.getEventId());
            distributePrize(eventResult);
        } catch (DAOException exc){
            LOG.error(exc);
            throw new ServiceException(exc);
        }

        System.out.println(eventResult);

        return eventResult;
    }

    private int[] randomDetermineWinnerAndLooserScore (){
        Random randomScore = new Random();
        final int membersAmount = 2;
        final int statisticMaxScore = 10;
        int[] result = new int[membersAmount];

        result[0] = randomScore.nextInt(statisticMaxScore);
        result[1] = randomScore.nextInt(statisticMaxScore);

        return result;
    }

    private void distributePrize(EventResult eventResult){
        (new Thread(() -> {
            try {
                BigDecimal fullMoneyAmount = rateDAO.getFullMoneyAmountForEvent(eventResult.getEventId());
                List<Rate> allRateList = rateDAO.getRatesForEvent(eventResult.getEventId());
                List<Rate> winRateList = new ArrayList<Rate>();
                for (Rate rate : allRateList) {
                    if(checkWin(rate, eventResult)){
                        winRateList.add(rate);
                    }
                }
                BigDecimal moneyPerPerson = fullMoneyAmount.divide(BigDecimal.valueOf(winRateList.size()), 2, BigDecimal.ROUND_FLOOR);
                for(Rate rate : allRateList){
                    rate.setWin(BigDecimal.valueOf(0.0));
                }
                for(Rate rate : winRateList){
                    rate.setWin(moneyPerPerson);
                }
                for(Rate rate : allRateList){
                    rateDAO.setWinForRate(rate);
                    userDAO.fillUpBalanceForUser(rate.getUserId(), rate.getWin());
                }
            } catch (Exception exc){
                LOG.error(exc);
            }
        })).run();
    }

    private boolean checkWin(Rate rate, EventResult eventResult){
        switch (rate.getType()){
            case Rate.WIN:
                if(eventResult.getWinnerId() == rate.getMember1Id()){
                    return true;
                }
                return false;
            case Rate.DRAW:
                if(eventResult.getLoserScore() == eventResult.getWinnerScore()){
                    return true;
                }
                return false;
            case Rate.EXACT_SCORE:
                if(eventResult.getWinnerId() == rate.getMember1Id()){
                    if((eventResult.getWinnerScore() == rate.getMember1Score()) &&
                            (eventResult.getLoserScore() == rate.getMember2Score())){
                        return true;
                    }
                    return false;
                } else{
                    if((eventResult.getWinnerScore() == rate.getMember2Score()) &&
                            (eventResult.getLoserScore() == rate.getMember1Score())){
                        return true;
                    }
                    return false;
                }
        }
        return false;
    }
}

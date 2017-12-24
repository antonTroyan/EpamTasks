package by.troyan.web.service.implementation;

import by.troyan.web.dao.EventDAO;
import by.troyan.web.dao.EventResultDAO;
import by.troyan.web.dao.RateDAO;
import by.troyan.web.dao.UserDAO;
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

/**
 * EventResultService implementation. Describe method works with EventResults.
 */

public class EventResultServiceImpl implements EventResultService {
    private static final EventResultServiceImpl instance = new EventResultServiceImpl();
    private final static Logger LOG = LogManager.getLogger("EventResultServiceImpl");
    EventResultDAO eventResultDAO;
    EventDAO eventDAO;
    RateDAO rateDAO;
    UserDAO userDAO;

    public static EventResultService getInstance(){
        return instance;
    }

    EventResultServiceImpl(){
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
    public EventResult addEventResult(String eventId, String winnerId, String loserId, String winnerScore, String loserScore) throws ServiceException, EventResultException {
        EventResult eventResult = new EventResult();
        EventResultException eventResultException = new EventResultException(eventResult);
        eventResult.setEventId(checkInt(eventId, eventResultException, "err.event-id-is-invalid"));
        eventResult.setWinnerId(checkInt(winnerId, eventResultException, "err.winner-id-is-invalid"));
        eventResult.setWinnerScore(checkInt(winnerScore, eventResultException, "err.winner-score-is-invalid"));
        eventResult.setLoserId(checkInt(loserId, eventResultException, "err.loser-id-is-invalid"));
        eventResult.setLoserScore(checkInt(loserScore, eventResultException, "err.loser-score-is-invalid"));
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
        return eventResult;
    }

    private void distributePrize(EventResult eventResult){
        (new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BigDecimal fullMoneyAmount = rateDAO.getFullMoneyAmountForEvent(eventResult.getEventId());
                    List<Rate> rateList = rateDAO.getRatesForEvent(eventResult.getEventId());
                    List<Rate> winRateList = new ArrayList<Rate>();
                    for (Rate rate : rateList) {
                        if(checkWin(rate, eventResult)){
                            winRateList.add(rate);
                        }
                    }
                    BigDecimal moneyPerPerson = fullMoneyAmount.divide(BigDecimal.valueOf(winRateList.size()), 2, BigDecimal.ROUND_FLOOR);
                    for(Rate rate : rateList){
                        rate.setWin(BigDecimal.valueOf(0.0));
                    }
                    for(Rate rate : winRateList){
                        rate.setWin(moneyPerPerson);
                    }
                    for(Rate rate : rateList){
                        rateDAO.setWinForRate(rate);
                        userDAO.fillUpBalanceForUser(rate.getUserId(), rate.getWin());
                    }
                } catch (Exception exc){
                    LOG.error(exc);
                }
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

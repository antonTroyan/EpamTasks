package by.troyan.web.command.implementation;

import by.troyan.web.command.CommandEnum;
import by.troyan.web.command.ICommand;
import by.troyan.web.command.exception.CommandException;
import by.troyan.web.command.factory.CommandFactory;
import by.troyan.web.entity.User;
import by.troyan.web.exception.EventResultException;
import by.troyan.web.exception.UnauthorizedException;
import by.troyan.web.service.EventResultService;
import by.troyan.web.service.exception.ServiceException;
import by.troyan.web.service.factory.ServiceFactory;
import by.troyan.web.support.MessageLocalizer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddEventResultCommand implements ICommand {
    private final static Logger LOG = LogManager.getLogger("AddEventResultCommand");
    EventResultService eventResultService = ServiceFactory.getInstance().getEventResultService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,
            CommandException, UnauthorizedException {
        checkRoots(req, new User.Role[]{User.Role.MODERATOR});
        String eventId = req.getParameter("event-id");
        String winnerId = req.getParameter("winner-id");
        String winnerScore = req.getParameter("winner-score");
        String loserId = req.getParameter("loser-id");
        String loserScore = req.getParameter("loser-score");
        try{
            eventResultService.addEventResult(eventId, winnerId, loserId, winnerScore, loserScore);
        } catch (ServiceException exc){
            LOG.error(exc);
            throw new CommandException(exc);
        } catch (EventResultException exc){
            LOG.error(exc);
            req.setAttribute("error", MessageLocalizer.getLocalizedForCurrentLocaleMessage(exc.getErrorMessageList(), req));
            req.setAttribute("eventResult", exc.getEventResult());
            req.getRequestDispatcher("add_result_page.jsp").forward(req, resp);
            CommandFactory.getFactory().createCommand(CommandEnum.SHOW_ADD_EVENT_RESULT_PAGE).execute(req, resp);
        }
        req.setAttribute("eventId", eventId);
        CommandFactory.getFactory().createCommand(CommandEnum.SHOW_EVENT_PAGE).execute(req, resp);
    }
}

package sport.totalizator.command.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sport.totalizator.command.CommandEnum;
import sport.totalizator.command.ICommand;
import sport.totalizator.command.exception.CommandException;
import sport.totalizator.command.factory.CommandFactory;
import sport.totalizator.entity.Event;
import sport.totalizator.exception.UnauthorizedException;
import sport.totalizator.service.EventService;
import sport.totalizator.service.exception.ServiceException;
import sport.totalizator.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ShowEventPageCommand implements ICommand{
    private final static Logger LOG = LogManager.getLogger("ShowEventPageCommand");

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, CommandException, UnauthorizedException {
        CommandFactory.getFactory().createCommand(CommandEnum.ADD_CATEGORIES_TO_REQUEST).execute(req, resp);
        EventService eventService = ServiceFactory.getInstance().getEventService();
        String eventId = req.getParameter("eventId");
        if(eventId == null){
            eventId = (String)req.getAttribute("eventId");
        }
        int intEventId = Integer.parseInt(eventId);
        try {
            Event event = eventService.getEventById(intEventId);
            req.setAttribute("event", event);
        } catch (ServiceException exc){
            LOG.error(exc);
            throw new CommandException(exc);
        }
        req.getRequestDispatcher("event_page.jsp").forward(req, resp);
    }
}

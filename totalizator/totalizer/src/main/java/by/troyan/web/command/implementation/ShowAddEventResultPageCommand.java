package by.troyan.web.command.implementation;

import by.troyan.web.command.CommandEnum;
import by.troyan.web.command.ICommand;
import by.troyan.web.command.exception.CommandException;
import by.troyan.web.command.factory.CommandFactory;
import by.troyan.web.entity.User;
import by.troyan.web.exception.UnauthorizedException;
import by.troyan.web.service.MemberService;
import by.troyan.web.service.exception.ServiceException;
import by.troyan.web.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowAddEventResultPageCommand implements ICommand {
    private final static Logger LOG = LogManager.getLogger("ShowAddEventResultPageCommand");
    private MemberService memberService = ServiceFactory.getInstance().getMemberService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, CommandException, UnauthorizedException {
        checkRoots(req, new User.Role[]{User.Role.MODERATOR});
        CommandFactory.getFactory().createCommand(CommandEnum.ADD_CATEGORIES_TO_REQUEST).execute(req, resp);
        String eventId = req.getParameter("eventId");
        if(eventId == null){
            eventId = (String)req.getAttribute("eventId");
        }
        try{
            int intEventId = Integer.parseInt(eventId);
            req.setAttribute("members", memberService.getMembersByEvent(intEventId));
            req.setAttribute("eventId", eventId);
        } catch (ServiceException | NumberFormatException exc){
            LOG.error(exc);
            throw new CommandException(exc);
        }
        req.getRequestDispatcher("add_result_page.jsp").forward(req, resp);
    }
}

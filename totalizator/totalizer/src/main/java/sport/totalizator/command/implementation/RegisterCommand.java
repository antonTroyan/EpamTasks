package sport.totalizator.command.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sport.totalizator.command.CommandEnum;
import sport.totalizator.command.ICommand;
import sport.totalizator.command.exception.CommandException;
import sport.totalizator.command.factory.CommandFactory;
import sport.totalizator.entity.User;
import sport.totalizator.exception.UnauthorizedException;
import sport.totalizator.exception.UserException;
import sport.totalizator.service.UserService;
import sport.totalizator.service.exception.ServiceException;
import sport.totalizator.service.factory.ServiceFactory;
import sport.totalizator.util.MessageLocalizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterCommand implements ICommand {
    private final static Logger LOG = LogManager.getLogger("RegisterCommand");

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, CommandException, UnauthorizedException {
        UserService userService = ServiceFactory.getInstance().getUserService();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("password-confirm");
        String email = req.getParameter("email");
        User user = null;
        try {
            user = userService.registerUser(login, password, confirmPassword, email);
        } catch (ServiceException exc){
            LOG.error(exc);
            throw new CommandException(exc);
        } catch (UserException exc){
            req.setAttribute("error", MessageLocalizer.getLocalizedForCurrentLocaleMessage(exc.getMessage(), req));
            req.setAttribute("user", exc.getUser());
            CommandFactory.getFactory().createCommand(CommandEnum.SHOW_REGISTRATION_PAGE).execute(req, resp);
        }
        req.setAttribute("success", MessageLocalizer.getLocalizedForCurrentLocaleMessage("success.register", req));
        CommandFactory.getFactory().createCommand(CommandEnum.SHOW_REGISTRATION_PAGE).execute(req, resp);
    }
}

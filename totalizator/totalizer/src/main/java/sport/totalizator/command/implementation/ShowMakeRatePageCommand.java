package sport.totalizator.command.implementation;

import sport.totalizator.command.CommandEnum;
import sport.totalizator.command.ICommand;
import sport.totalizator.command.exception.CommandException;
import sport.totalizator.command.factory.CommandFactory;
import sport.totalizator.entity.User;
import sport.totalizator.exception.UnauthorizedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static sport.totalizator.entity.User.Role.ADMINISTRATOR;
import static sport.totalizator.entity.User.Role.MODERATOR;
import static sport.totalizator.entity.User.Role.USER;

public class ShowMakeRatePageCommand implements ICommand{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, CommandException, UnauthorizedException {
        checkRoots(req, new User.Role[]{USER, MODERATOR, ADMINISTRATOR});
        CommandFactory.getFactory().createCommand(CommandEnum.ADD_CATEGORIES_TO_REQUEST).execute(req, resp);
        req.setAttribute("eventId", req.getParameter("eventId"));
        req.getRequestDispatcher("make_rate_page.jsp").forward(req, resp);
    }
}

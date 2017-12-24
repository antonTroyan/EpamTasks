package sport.totalizator.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sport.totalizator.command.CommandEnum;
import sport.totalizator.command.ICommand;
import sport.totalizator.command.factory.CommandFactory;
import sport.totalizator.exception.UnauthorizedException;
import sport.totalizator.util.MessageLocalizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Главный контроллер - сервлет. Получает из запроса команду, создает ее и приказывает выполнить.
 * @author  Anton Troyan
 */

public class MainController extends HttpServlet {
    private static final CommandFactory commandFactory = CommandFactory.getFactory();
    private final static Logger LOG = LogManager.getLogger("MainController");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICommand command = null;
        String commandName = req.getParameter("command");
        try {
            CommandEnum commandEnum = CommandEnum.getEnum(commandName);
            command = commandFactory.createCommand(commandEnum);
            command.execute(req, resp);
        } catch (UnauthorizedException exc){
            LOG.error(exc);
            req.setAttribute("message", exc.getMessage());
            req.getRequestDispatcher("error_page.jsp").forward(req, resp);
        } catch (Exception exc){
            LOG.error(exc);
            req.setAttribute("message", MessageLocalizer.getLocalizedForCurrentLocaleMessage("err.smth-error", req));
            req.getRequestDispatcher("error_page.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}

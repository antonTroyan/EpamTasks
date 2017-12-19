package by.troyan.web.controller;

import by.troyan.web.command.CommandEnum;
import by.troyan.web.command.ICommand;
import by.troyan.web.command.factory.CommandFactory;
import by.troyan.web.exception.UnauthorizedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MainController extends HttpServlet {
    private static final CommandFactory commandFactory = CommandFactory.getFactory();
    private final static Logger LOG = LogManager.getLogger("MainController");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICommand command;
        String commandName = req.getParameter("command");
        try {
            CommandEnum commandEnum = CommandEnum.getEnum(commandName);
            command = commandFactory.createCommand(commandEnum);
            command.execute(req, resp);
        } catch (UnauthorizedException e) {
            LOG.warn("UnauthorizedException " + e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}

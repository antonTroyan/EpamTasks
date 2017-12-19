package by.troyan.web.command.implementation;


import by.troyan.web.command.ICommand;
import by.troyan.web.exception.UnauthorizedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowMainPageCommand implements ICommand {

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, UnauthorizedException {

    }
}

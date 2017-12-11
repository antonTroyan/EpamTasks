package sport.totalizator.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sport.totalizator.command.CommandEnum;
import sport.totalizator.command.ICommand;
import sport.totalizator.command.exception.CommandException;
import sport.totalizator.command.factory.CommandFactory;
import sport.totalizator.exception.UnauthorizedException;
import sport.totalizator.service.EventService;
import sport.totalizator.service.exception.ServiceException;
import sport.totalizator.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static sport.totalizator.command.CommandEnum.SHOW_CATEGORY_PAGE;
import static sport.totalizator.util.PaginationObject.DEFAULT_PAGE;

public class ShowCategoryPageCommand implements ICommand {
    private final static Logger LOG = LogManager.getLogger("ShowCategoryPageCommand");

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, CommandException, UnauthorizedException {
        CommandFactory.getFactory().createCommand(CommandEnum.ADD_CATEGORIES_TO_REQUEST).execute(req, resp);
        EventService eventService = ServiceFactory.getInstance().getEventService();
        int page;
        try{
            page = Integer.parseInt(req.getParameter("page"));
        } catch (NumberFormatException exc){
            page = DEFAULT_PAGE;
        }
        try {
            req.setAttribute("events", eventService.getAllNotEndedEventsByCategoryId(req.getParameter("categoryId"), page));
        }
        catch (ServiceException exc){
            LOG.error(exc);
        }
        req.setAttribute("command", SHOW_CATEGORY_PAGE.getValue());
        req.getRequestDispatcher("main_page.jsp").forward(req, resp);
    }
}

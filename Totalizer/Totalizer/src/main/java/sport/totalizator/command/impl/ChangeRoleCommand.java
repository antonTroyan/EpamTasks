package sport.totalizator.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sport.totalizator.command.ICommand;
import sport.totalizator.command.exception.CommandException;
import sport.totalizator.entity.User;
import sport.totalizator.exception.UnauthorizedException;
import sport.totalizator.service.UserService;
import sport.totalizator.service.exception.ServiceException;
import sport.totalizator.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChangeRoleCommand implements ICommand {
    private final static Logger LOG = LogManager.getLogger("ChangeRoleCommand");
    private UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, CommandException, UnauthorizedException {
        checkRoots(req, new User.Role[]{User.Role.ADMINISTRATOR});
        String[] stringIdList = req.getParameter("id-list").split(",");
        List<Integer> idList = new ArrayList<>();
        String role = req.getParameter("role");
        for(String str : stringIdList){
            idList.add(Integer.parseInt(str));
        }
        try{
            userService.changeRoleForUsers(idList, role);
        } catch (ServiceException exc){
            LOG.error(exc);
            throw new CommandException(exc);
        }
    }
}
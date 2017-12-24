package sport.totalizator.command.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sport.totalizator.command.ICommand;
import sport.totalizator.command.exception.CommandException;
import sport.totalizator.entity.Member;
import sport.totalizator.service.MemberService;
import sport.totalizator.service.exception.ServiceException;
import sport.totalizator.service.factory.ServiceFactory;
import sport.totalizator.util.JsonSerializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetMembersByLeagueJsonCommand implements ICommand {
    private final static Logger LOG = LogManager.getLogger("GetMembersByLeagueJsonCommand");

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, CommandException {
        MemberService memberService = ServiceFactory.getInstance().getMemberService();
        int leagueId = Integer.parseInt(req.getParameter("leagueId"));
        List<Member> members = new ArrayList<Member>();
        try {
            members = memberService.getMembersByLeague(leagueId);
        } catch (ServiceException exc){
            LOG.error(exc);
            throw new CommandException(exc);
        }
        resp.setHeader("Content-type", "json");
        req.setAttribute("json", JsonSerializer.json(members));
        req.getRequestDispatcher("json.jsp").forward(req, resp);
    }

}

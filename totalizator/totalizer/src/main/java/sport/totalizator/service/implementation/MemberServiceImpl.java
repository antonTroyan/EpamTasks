package sport.totalizator.service.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sport.totalizator.dao.MemberDAO;
import sport.totalizator.dao.exception.DAOException;
import sport.totalizator.dao.factory.DAOFactory;
import sport.totalizator.entity.Member;
import sport.totalizator.exception.MemberException;
import sport.totalizator.service.MemberService;
import sport.totalizator.service.exception.ServiceException;

import java.util.List;

public class MemberServiceImpl  implements MemberService{

    private final static Logger LOG = LogManager.getLogger("MemberServiceImpl");
    private static final MemberServiceImpl instance = new MemberServiceImpl();
    private MemberDAO memberDAO;

    public static MemberServiceImpl getInstance(){
        return instance;
    }

    MemberServiceImpl(){
        memberDAO = DAOFactory.getFactory().getMemberDAO();
    }

    @Override
    public List<Member> getMembersByLeague(int leagueId) throws ServiceException {
        try{
            return memberDAO.getMembersByLeague(leagueId);
        } catch (DAOException exc){
            LOG.error(exc);
            throw new ServiceException(exc);
        }
    }

    @Override
    public List<Member> getMembersByEvent(int eventId) throws ServiceException {
        try{
            return memberDAO.getMembersByEvent(eventId);
        } catch (DAOException exc){
            LOG.error(exc);
            throw new ServiceException(exc);
        }
    }

    @Override
    public Member addMember(String name, String categoryId, String leagueId) throws ServiceException, MemberException {
        Member member = new Member();
        MemberException memberException = new MemberException(member);
        if(name.isEmpty() || (name == null)){
            memberException.addMessage("err.name-is-invalid");
        }
        member.setName(name);
        int intCategoryId = 0;
        try{
            intCategoryId = Integer.parseInt(categoryId);
        } catch (NumberFormatException exc){
            LOG.error(exc);
        }
        member.setCategoryId(intCategoryId);
        int intLeagueId = 0;
        try{
            intLeagueId = Integer.parseInt(leagueId);
        } catch (NumberFormatException exc){
            LOG.error(exc);
        }
        member.setLeagueId(intLeagueId);
        if(memberException.getErrorMessageList().size() > 0){
            throw memberException;
        }
        try {
            return memberDAO.addMember(member);
        } catch (DAOException exc){
            LOG.error(exc);
            throw new ServiceException(exc);
        }
    }
}

package sport.totalizator.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import sport.totalizator.dao.exception.DAOException;
import sport.totalizator.dao.implementation.UserDAOImpl;
import sport.totalizator.entity.User;
import java.util.List;



public class UserDAOTest {
    private final static Logger LOG = LogManager.getLogger("UserDAOTest");

    @Test
    public void getAllUsersTest(){
        List<User> users = null;
        UserDAOImpl dao = UserDAOImpl.getInstance();
        try {
            users = dao.getAllUsers();
        } catch (DAOException exc){
            LOG.error(exc);
        }
        Assert.assertEquals(true, users.size() > 0);
    }
}

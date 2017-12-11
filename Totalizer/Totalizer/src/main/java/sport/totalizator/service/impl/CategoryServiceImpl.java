package sport.totalizator.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sport.totalizator.dao.CategoryDAO;
import sport.totalizator.dao.exception.DAOException;
import sport.totalizator.dao.factory.DAOFactory;
import sport.totalizator.entity.Category;
import sport.totalizator.exception.CategoryException;
import sport.totalizator.service.CategoryService;
import sport.totalizator.service.exception.ServiceException;

public class CategoryServiceImpl implements CategoryService {
    private static final CategoryServiceImpl instance = new CategoryServiceImpl();
    private final static Logger LOG = LogManager.getLogger("CategoryServiceImpl");

    private CategoryDAO categoryDAO;

    public static CategoryServiceImpl getInstance(){
        return instance;
    }

    CategoryServiceImpl(){
        categoryDAO = DAOFactory.getFactory().getCategoryDAO();
    }

    @Override
    public Category addCategory(String name) throws ServiceException, CategoryException {
        Category category = new Category();
        CategoryException categoryException = new CategoryException(category);
        if(name.isEmpty() || (name == null)){
            categoryException.addMessage("err.name-is-invalid");
        }
        category.setName(name);
        if(categoryException.getErrorMessageList().size() > 0){
            throw categoryException;
        }
        try {
            return categoryDAO.addCategory(category);
        } catch (DAOException exc){
            LOG.error(exc);
            throw new ServiceException(exc);
        }
    }
}

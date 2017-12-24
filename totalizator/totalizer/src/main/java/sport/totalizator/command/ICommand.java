package sport.totalizator.command;

import sport.totalizator.command.exception.CommandException;
import sport.totalizator.entity.User;
import sport.totalizator.exception.UnauthorizedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Интерфейс, реализуемый всеми командами. <p>
 * 1 метод дефолтный - система проверки прав доступа. Требует Енам и запрос.
 * Из запроса достает атрибут который является ролью. Если все в порядке, то метод просто выполняется.
 * Иначе выбрасывает исключение <p>
 * 2 метод абстрактный. Описывает главный метод для всех команд
 * @author  Anton Troyan
 */

public interface ICommand {
    default void checkRoots(HttpServletRequest req, User.Role[] needLevels)
            throws ServletException, IOException, CommandException, UnauthorizedException{
        if((needLevels.length == 0) || (needLevels == null)){
            return;
        }
        String currentLevel = (String) req.getSession().getAttribute("role");
        for (User.Role needLevel : needLevels) {
            if(needLevel.getValue().equals(currentLevel)){
                return;
            }
        }
        throw new UnauthorizedException("Not enough permissions for this operation");
    }

    void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,
            CommandException, UnauthorizedException;
}

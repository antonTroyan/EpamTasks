package by.troyan.web.support;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.ResourceBundle;

/**
 * MessageLocalizer class. Help to work with locales.
 */

public class MessageLocalizer {
    private final static String LOCALE_BUNDLE_NAME = "locale_";

    public static String getLocalizedForCurrentLocaleMessage(String msgName, HttpServletRequest req){
        ResourceBundle bundle = ResourceBundle.getBundle(
                LOCALE_BUNDLE_NAME.concat((String)req.getSession().getAttribute("locale")));
        return bundle.getString(msgName);
    }

    public static String getLocalizedForCurrentLocaleMessage(List<String> msgNameList, HttpServletRequest req){
        ResourceBundle bundle = ResourceBundle.getBundle(
                LOCALE_BUNDLE_NAME.concat((String)req.getSession().getAttribute("locale")));
        StringBuilder stringBuilder = new StringBuilder();
        for(String msgName : msgNameList){
            stringBuilder.append(bundle.getString(msgName));
            stringBuilder.append("<br>");
        }
        return stringBuilder.toString();
    }
}

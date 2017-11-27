package creator;

import creator.parser.ParserInterface;
import entity.component.Component;
import entity.Symbol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolHandler implements ParserInterface {

    @Override
    public Component chain(Component result, String text) {
        Matcher matcher = Pattern.compile(RegularExpressions.REGEX_SYMBOL).matcher(text);
        String symbol;

        while(matcher.find()){
            symbol = matcher.group();
            result.add(new Symbol(symbol));
        }
        return result;
    }
}

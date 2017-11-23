package Chain.simple;

import Composite.Component;
import Composite.Symbol;
import text.RegularExpressions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolHandler implements ParserInterface {

    ParserInterface successor;

    public SymbolHandler(ParserInterface successor) {
        this.successor = successor;
    }

    @Override
    public Component chain(Component result, String text) {
        Matcher matcher = Pattern.compile(RegularExpressions.REGEX_SYMBOL).matcher(text);

        while(matcher.find()){
            result.add(new Symbol(matcher.group()));
        }
        return result;
    }
}

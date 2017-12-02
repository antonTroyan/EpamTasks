package by.troyan.task4.creator;

import by.troyan.task4.creator.handler.HandlerInterface;
import by.troyan.task4.entity.component.Component;
import by.troyan.task4.entity.Symbol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolHandler implements HandlerInterface {

    @Override
    public Component chain(Component result, String text) {
        Matcher matcher = Pattern.compile(RegularExpression.REGEX_SYMBOL).matcher(text);
        String symbol;

        while(matcher.find()){
            symbol = matcher.group();
            result.add(new Symbol(symbol));
        }
        return result;
    }
}

package by.troyan.task4.creator;

import by.troyan.task4.creator.handler.HandlerInterface;
import by.troyan.task4.entity.component.Component;
import by.troyan.task4.entity.SymbolSet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphHandler implements HandlerInterface {
    private HandlerInterface successor;

    public ParagraphHandler(HandlerInterface successor) {
        this.successor = successor;
    }

    @Override
    public Component chain(Component result, String text) {
        Matcher matcher = Pattern.compile(RegularExpression.REGEX_PARAGRAPH).matcher(text);
        SymbolSet paragraph;
        String paragraphText;
        while(matcher.find()){
            paragraphText = matcher.group();
            paragraph = new SymbolSet();
            result.add(successor.chain(paragraph, paragraphText));
        }
        return result;
    }
}

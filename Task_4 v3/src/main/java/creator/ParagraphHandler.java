package creator;

import creator.handler.HandlerInterface;
import entity.component.Component;
import entity.SymbolSet;

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

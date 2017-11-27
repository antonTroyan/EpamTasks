package сhain;

import сomposite.Component;
import сomposite.SymbolSet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphHandler implements ParserInterface {
    ParserInterface successor;

    public ParagraphHandler(ParserInterface successor) {
        this.successor = successor;
    }

    @Override
    public Component chain(Component result, String text) {
        Matcher matcher = Pattern.compile(RegularExpressions.REGEX_PARAGRAPH).matcher(text);
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

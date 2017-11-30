package creator;

import creator.handler.HandlerInterface;
import entity.component.Component;
import entity.SymbolSet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordAndSignHandler implements HandlerInterface {

    private HandlerInterface successor;

    public WordAndSignHandler(HandlerInterface successor) {
        this.successor = successor;
    }
    
    @Override
    public Component chain(Component result, String text) {

        Matcher matcher = Pattern.compile(RegularExpression.REGEX_WORD).matcher(text);
        SymbolSet word;
        String wordText;

        while(matcher.find()){
            wordText = matcher.group();
            word = new SymbolSet();
            result.add(successor.chain(word, wordText));
        }
        return result;
    }
}

package creator;

import creator.parser.ParserInterface;
import entity.component.Component;
import entity.SymbolSet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordAndSignHandler implements ParserInterface {

    ParserInterface successor;

    public WordAndSignHandler(ParserInterface successor) {
        this.successor = successor;
    }
    
    @Override
    public Component chain(Component result, String text) {

        Matcher matcher = Pattern.compile(RegularExpressions.REGEX_WORD).matcher(text);

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

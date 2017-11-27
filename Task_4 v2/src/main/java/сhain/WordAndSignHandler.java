package сhain;

import сomposite.Component;
import сomposite.SymbolSet;

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

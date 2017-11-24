package Chain.simple;

import Composite.Component;
import Composite.SymbolSet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordHandler implements ParserInterface {

    ParserInterface successor;

    public WordHandler(ParserInterface successor) {
        this.successor = successor;
    }

    @Override
    public Component chain(Component result, String text) {
        System.out.println("WordHandler");
        Matcher matcher = Pattern.compile(RegularExpressions.REGEX_WORD).matcher(text);
        SymbolSet word;
        String wordText;

        while(matcher.find()){
            wordText = matcher.group();
            System.out.println("Word " + wordText);
            word = new SymbolSet();
            result.add(successor.chain(word, wordText));
        }
        return result;
    }
}

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
        Matcher matcher = Pattern.compile("([^a-zA-Z']+)'*\\1*").matcher(text);
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

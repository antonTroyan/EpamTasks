package Chain.simple;

import Composite.Component;
import Composite.SymbolSet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceHandler implements ParserInterface {
    ParserInterface successor;

    public SentenceHandler (ParserInterface successor) {
        this.successor = successor;
    }

    @Override
    public Component chain(Component result, String text) {
        Matcher matcher = Pattern.compile(RegularExpressions.REGEX_SENTENCE).matcher(text);
        SymbolSet sentence;
        String sentenceText;

        while(matcher.find()){
            sentenceText = matcher.group();
            sentence = new SymbolSet();
            result.add(successor.chain(sentence, sentenceText));
        }
        return result;
    }
}

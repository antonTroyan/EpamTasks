package by.troyan.task4.creator;

import by.troyan.task4.creator.handler.HandlerInterface;
import by.troyan.task4.entity.SymbolSet;
import by.troyan.task4.entity.component.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceHandler implements HandlerInterface {

    private HandlerInterface successor;

    public SentenceHandler (HandlerInterface successor) {
        this.successor = successor;
    }

    @Override
    public Component chain(Component result, String text) {
        Matcher matcher = Pattern.compile(RegularExpression.REGEX_SENTENCE).matcher(text);
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

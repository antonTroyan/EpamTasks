package Chain;
import Composite.Symbol;
import Composite.SymbolSet;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static Chain.RegularExpressions.*;

public class SymbolSetCreator {

    public SymbolSet create (String filename) {
        System.out.println("Try to create");
        SymbolSet result = new SymbolSet();
        result = parseToParagraph(result, downloadText(filename));
        return result;
    }

    private String downloadText(String filename) {
        System.out.println("Initializtion");
        String allText = "";
        try {
            Scanner scanner = new Scanner(new FileReader(filename));
            while (scanner.hasNext()){
                allText += scanner.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Init text = " + allText);
        return allText;
    }

    private SymbolSet parseToParagraph(SymbolSet allText, String text) {

        Matcher matcher = Pattern.compile(REGEX_NEW_PARAGRAPH).matcher(text);
        SymbolSet paragraph;
        String paragraphText;
        while(matcher.find()){
            paragraphText = matcher.group();
            paragraph = new SymbolSet();
            allText.add(parseToSentense(paragraph, paragraphText));
        }
        return allText;
    }

    private SymbolSet parseToSentense(SymbolSet paragraph, String text) {
        Matcher matcher = Pattern.compile(REGEX_SENTENCE).matcher(text);
        SymbolSet sentence;
        String sentenceText;

        while(matcher.find()){
            sentenceText = matcher.group();
            sentence = new SymbolSet();
            sentence.add(parseToWord(sentence, sentenceText));
            paragraph.add(sentence);
        }
        return paragraph;
    }

    private SymbolSet parseToWord(SymbolSet sentence, String text) {
        Matcher matcher = Pattern.compile(REGEX_WORD).matcher(text);
        SymbolSet word;
        String wordText;

        while(matcher.find()){
            wordText = matcher.group();
            word = new SymbolSet();
            word.add(parseToSignAndWord(word, wordText));
            sentence.add(word);
        }
        return sentence;
    }

    private SymbolSet parseToSignAndWord(SymbolSet word, String text) {

        Matcher matcher = Pattern.compile(REGEX_WORD_AND_SIGN).matcher(text);
        SymbolSet signAndWord;
        String signAndWordText;

        while(matcher.find()){
            signAndWordText = matcher.group();
            signAndWord = new SymbolSet();
            signAndWord.add(parseToSymbol(signAndWord, signAndWordText));
            word.add(signAndWord);
        }
        return word;
    }

    private SymbolSet parseToSymbol(SymbolSet signAndWord, String text) {

        Matcher matcher = Pattern.compile(REGEX_SYMBOL).matcher(text);

        while(matcher.find()){
            Symbol symbol = new Symbol(matcher.group());
            signAndWord.add(symbol);
        }
        return signAndWord;
    }
}

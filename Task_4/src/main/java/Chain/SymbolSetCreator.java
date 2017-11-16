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

    public SymbolSet createSymbolSet (String filename) {
        System.out.println("Try to create");
        SymbolSet result = new SymbolSet();
        result = parseToParagraph(result, downloadText(filename));
        return result;
    }

    public String downloadText(String filename) {
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

    public SymbolSet parseToParagraph(SymbolSet result, String text) {

        Matcher matcher = Pattern.compile(REGEX_NEW_PARAGRAPH).matcher(text);
        SymbolSet paragraph;
        String paragraphText;
        while(matcher.find()){
            paragraphText = matcher.group();
            paragraph = new SymbolSet();
            result.add(parseToSentence(paragraph, paragraphText));
        }
        return result;
    }

    public SymbolSet parseToSentence(SymbolSet paragraph, String text) {
        Matcher matcher = Pattern.compile(REGEX_SENTENCE).matcher(text);
        SymbolSet sentence;
        String sentenceText;

        while(matcher.find()){
            sentenceText = matcher.group();
            sentence = new SymbolSet();
            paragraph.add(parseToWord(sentence, sentenceText));
        }
        return paragraph;
    }

    public SymbolSet parseToWord(SymbolSet sentence, String text) {

        String [] splitted = text.split("([^a-zA-Z']+)'*\\1*");




        Matcher matcher = Pattern.compile("([^a-zA-Z']+)'*\\1*").matcher(text);
        SymbolSet word;
        String wordText;

        while(matcher.find()){
            wordText = matcher.group();
            word = new SymbolSet();
            sentence.add(parseToSymbol(word, wordText));
        }
        return sentence;
    }

//    public SymbolSet parseToSignAndWord(SymbolSet word, String text) {

//        Matcher matcher = Pattern.compile(REGEX_WORD_AND_SIGN).matcher(text);
//        SymbolSet signAndWord;
//        String signAndWordText;
//
//        while(matcher.find()){
//            signAndWordText = matcher.group();
//            System.out.println(signAndWordText + " signAndWordText");
//            signAndWord = new SymbolSet();
//            word.add(parseToSymbol(signAndWord, signAndWordText));
//        }
//        return word;
//    }

    public SymbolSet parseToSymbol(SymbolSet word, String text) {
        Matcher matcher = Pattern.compile(REGEX_SYMBOL).matcher(text);

        while(matcher.find()){
            word.add(new Symbol(matcher.group()));
        }
        return word;
    }
}
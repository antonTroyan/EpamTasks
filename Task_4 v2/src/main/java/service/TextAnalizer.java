package service;

import Chain.simple.*;
import Composite.Component;
import Composite.SymbolSet;

import java.util.*;


public class TextAnalizer {
    public static void main(String[] args) {
        SymbolHandler symbolHandler = new SymbolHandler();
        WordAndSignHandler wordHandler = new WordAndSignHandler(symbolHandler);
        SentenceHandler sentenceHandler = new SentenceHandler(wordHandler);
        ParagraphHandler paragraphHandler = new ParagraphHandler(sentenceHandler);
        TextHandler textHandler = new TextHandler(paragraphHandler);
        TextAnalizer textAnalizer = new TextAnalizer();
   //     textAnalizer.countSentenciesWithSimilarWords(textHandler.chain(new SymbolSet(), "Hello"));
   //     textAnalizer.printSortedSentenciesByLexemsAmmount(textHandler.chain(new SymbolSet(), "Hello"));
        textAnalizer.printLexemsInAlphobeticOrder(textHandler.chain(new SymbolSet(), "Hello"));
    }

    public int countSentenciesWithSimilarWords(Component text){
        int counter = 0;

        for(int i=0; i < text.getComponentsSize(); i++){
            Component paragraph = (Component) text.getChild(i);
            for (int j=0; j < paragraph.getComponentsSize(); j++){
                Component sentence = (Component) paragraph.getChild(j);
                for(int k=0; k < sentence.getComponentsSize(); k++){
                    Component word = (Component)sentence.getChild(k);
                    for (int m=0; m < sentence.getComponentsSize(); m++){
                        if(word.equals(sentence.getChild(m) ) && m != k){
                            System.out.println(word + " equals " + sentence.getChild(m));
                            counter++;
                        }
                    }
                }
            }
        }
        System.out.println(counter/2-1);
        int result = counter/2-1;
        return result;
    }

    public void printSortedSentenciesByLexemsAmmount(Component text) {
        String[] allSentensies;
        String sentences[] = text.toString().split("[.!?]\\s*");
        sort(sentences, STRING_COMPARATOR);
        for (String tmp : sentences) {
            System.out.println(tmp + ": " + getNumberOfWords(tmp));
        }
    }

    private static int getNumberOfWords(String sentence) {
        return sentence.split("[\\p{Punct}\\s]+").length;
    }

    private static final Comparator<String> STRING_COMPARATOR = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return getNumberOfWords(o1) - getNumberOfWords(o2);
        }
    };

    private static <T> void sort(final T[] array, final Comparator<T> comparator) {
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
                if (comparator.compare(array[i], array[j]) > 0) {
                    final T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public void printLexemsInAlphobeticOrder(Component component) {
        List<String> result = new ArrayList<>();
        String[] lexems = component.toString().split("[[ ]*|[,]*|[\\.]*|[:]*|[/]*|[!]*|[?]*|[+]*]+") ;

        for (int i = 0; i < lexems.length; i++) {
            if (!(lexems[i].trim().length() == 0)){
                result.add(lexems[i]);
            }
        }
        Collections.sort(result);
        String previousRedLine = " ";
        for(String tmp: result){
            if(tmp.charAt(0) == previousRedLine.charAt(0)){
                System.out.println(tmp);

            } else {
                System.out.println("\t" + tmp);
                previousRedLine = tmp;
            }
        }


    }

}

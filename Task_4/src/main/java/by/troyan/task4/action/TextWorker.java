package by.troyan.task4.action;

import by.troyan.task4.creator.RegularExpression;
import by.troyan.task4.entity.component.Component;
import java.util.*;

public class TextWorker {

    public int countSentenciesWithSimilarWords(Component text) {
        int counter = 0;

        for (int i = 0; i < text.getComponentsSize(); i++) {
            Component paragraph = (Component) text.getChild(i);
            for (int j = 0; j < paragraph.getComponentsSize(); j++) {
                Component sentence = (Component) paragraph.getChild(j);
                for (int k = 0; k < sentence.getComponentsSize(); k++) {
                    Component word = (Component) sentence.getChild(k);
                    for (int m = 0; m < sentence.getComponentsSize(); m++) {
                        if (word.equals(sentence.getChild(m)) && m != k) {
                            counter++;
                        }
                    }
                }
            }
        }
        int result = counter / 2 - 1;
        return result;
    }

    public void printSortedSentenciesByLexemsAmmount(Component text) {
        String sentences[] = text.toString().split(RegularExpression.REGEX_SENTENCE_SPLITTER);
        sort(sentences, (o1, o2) -> getNumberOfWords(o1) - getNumberOfWords(o2));
        for (String tmp : sentences) {
            System.out.println(tmp + ": " + getNumberOfWords(tmp));
        }
    }

    // Метод для теста. Поскольку в задании сказано просто вывести на экран
    public String sortSentenciesByLexemsAmmount(Component text) {
        String sentences[] = text.toString().split(RegularExpression.REGEX_SENTENCE_SPLITTER);
        sort(sentences, (o1, o2) -> getNumberOfWords(o1) - getNumberOfWords(o2));
        String result = "";
        for (String tmp : sentences) {
            result += tmp + ": " + getNumberOfWords(tmp) + "\n";
        }
        return result;
    }

    // Метод для теста. Поскольку в задании сказано просто вывести на экран
    public String sortLexemsInAlphobetic(Component component) {
        List<String> list = new ArrayList<>();
        String[] lexems = component.toString().split(RegularExpression.REGEX_LEXEMS_SPLITTER);
        String result = "";
        for (int i = 0; i < lexems.length; i++) {
            if (!(lexems[i].trim().length() == 0)) {
                list.add(lexems[i]);
            }
        }
        Collections.sort(list);
        String previousRedLine = " ";
        for (String tmp : list) {
            if (tmp.charAt(0) == previousRedLine.charAt(0)) {
                result += tmp + "\n";
            } else {
                result += "\t" + tmp + "\n";
                previousRedLine = tmp;
            }
        }
        return result;
    }

    public void printLexemsInAlphobeticOrder(Component component) {
        List<String> result = new ArrayList<>();
        String[] lexems = component.toString().split(RegularExpression.REGEX_LEXEMS_SPLITTER);

        for (int i = 0; i < lexems.length; i++) {
            if (!(lexems[i].trim().length() == 0)) {
                result.add(lexems[i]);
            }
        }
        Collections.sort(result);
        String previousRedLine = " ";
        for (String tmp : result) {
            if (tmp.charAt(0) == previousRedLine.charAt(0)) {
                System.out.println(tmp);

            } else {
                System.out.println("\t" + tmp);
                previousRedLine = tmp;
            }
        }
    }

    private static int getNumberOfWords(String sentence) {
        return sentence.split(RegularExpression.REGEX_WORD_SPLITTER).length;
    }


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
}

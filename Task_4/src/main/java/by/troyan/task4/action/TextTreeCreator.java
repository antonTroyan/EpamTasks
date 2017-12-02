package by.troyan.task4.action;

import by.troyan.task4.structurecreator.*;
import by.troyan.task4.structurecreator.handler.HandlerInterface;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TextTreeCreator {

    public HandlerInterface createTextTree (String filename, int i, int j){
        TextFormulaCalculator textFormulaCalculator = new TextFormulaCalculator();
        String calculatedText = textFormulaCalculator.calculateTextFormulas(downloadTextFromFile(filename), i, j);

        SymbolHandler symbolHandler = new SymbolHandler();
        WordAndSignHandler wordAndSignHandler = new WordAndSignHandler(symbolHandler);
        SentenceHandler sentenceHandler = new SentenceHandler(wordAndSignHandler);
        ParagraphHandler paragraphHandler = new ParagraphHandler(sentenceHandler);
        TextHandler textHandler = new TextHandler(paragraphHandler, calculatedText);

        return textHandler;
    }


    public String downloadTextFromFile(String filename) {
        String allText = "";
        try {
            Scanner scanner = new Scanner(new FileReader(filename));
            while (scanner.hasNext()) allText += scanner.nextLine() + "\n";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return allText;
    }
}

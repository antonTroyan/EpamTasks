package by.troyan.task4.action;

import by.troyan.task4.entity.SymbolSet;
import by.troyan.task4.entity.component.Component;
import by.troyan.task4.creator.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TextTreeCreator {
    private final static Logger LOG = LogManager.getLogger("ParametersTextFiller");
    public Component createTextTree (String filename, int i, int j){
        TextFormulaCalculator textFormulaCalculator = new TextFormulaCalculator();
        String calculatedText = textFormulaCalculator.calculateTextFormulas(downloadTextFromFile(filename), i, j);

        SymbolHandler symbolHandler = new SymbolHandler();
        WordAndSignHandler wordAndSignHandler = new WordAndSignHandler(symbolHandler);
        SentenceHandler sentenceHandler = new SentenceHandler(wordAndSignHandler);
        ParagraphHandler paragraphHandler = new ParagraphHandler(sentenceHandler);
        TextHandler textHandler = new TextHandler(paragraphHandler, calculatedText);

        return textHandler.chain(new SymbolSet(), calculatedText);
    }


    public String downloadTextFromFile(String filename) {
        String result = "";
        try {
            Scanner scanner = new Scanner(new FileReader(filename));
            while (scanner.hasNext()) result += scanner.nextLine() + "\n";
        } catch (FileNotFoundException e) {
            LOG.fatal("File not found " + filename);
            throw new RuntimeException(e);
        }
        return result;
    }
}

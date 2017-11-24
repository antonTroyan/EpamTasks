package Chain.simple;

import Composite.SymbolSet;

public class Test {
    public static void main(String[] args) {
        SymbolHandler symbolHandler = new SymbolHandler();
        WordAndSignHandler wordHandler = new WordAndSignHandler(symbolHandler);
        SentenceHandler sentenceHandler = new SentenceHandler(wordHandler);
        ParagraphHandler paragraphHandler = new ParagraphHandler(sentenceHandler);
        TextHandler textHandler = new TextHandler(paragraphHandler);


        System.out.println(textHandler.chain(new SymbolSet(), "Hello"));

    }
}

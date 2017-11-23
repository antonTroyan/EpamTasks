package text;
import Composite.SymbolSet;

public class test {
    public static void main(String[] args) {
        AbstractHandler textHandler = new TextHandler ();
        ParagraphHandler paragraphHandler = new ParagraphHandler();
        SentenceHandler sentenceHandler = new SentenceHandler();
        LexemHandler lexemHandler = new LexemHandler();
        WordHandler wordHandler = new WordHandler();
        SymbolHandler symbolHandler = new SymbolHandler();

        wordHandler.setSuccessor(symbolHandler);
        lexemHandler.setSuccessor(wordHandler);
        sentenceHandler.setSuccessor(lexemHandler);
        paragraphHandler.setSuccessor(sentenceHandler);
        textHandler.setSuccessor(paragraphHandler);

        textHandler.chain(new SymbolSet());
    }
}

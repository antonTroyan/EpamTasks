package text;

import Composite.SymbolSet;

public class SentenceHandler extends AbstractHandler {
    @Override
    public SymbolSet parse(SymbolSet symbolSet, String text) {

        System.out.println("SentenceHandler");
        return new SymbolSet();
    }
}

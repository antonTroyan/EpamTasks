package text;

import Composite.SymbolSet;

public class LexemHandler extends AbstractHandler {
    @Override
    public SymbolSet parse(SymbolSet symbolSet, String text) {
        System.out.println("LexemHandler");
        return new SymbolSet();
    }
}

package text;

import Composite.SymbolSet;

public class SymbolHandler extends AbstractHandler {
    @Override
    public SymbolSet parse(SymbolSet symbolSet, String text) {
        System.out.println("SymbolHandler");
        return new SymbolSet();
    }
}

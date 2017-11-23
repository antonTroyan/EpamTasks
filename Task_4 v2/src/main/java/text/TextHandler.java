package text;


import Composite.SymbolSet;


public class TextHandler extends AbstractHandler {

    @Override
    public SymbolSet parse(SymbolSet symbolSet, String text) {
        System.out.println("TextHandler");
        return new SymbolSet();
    }
}

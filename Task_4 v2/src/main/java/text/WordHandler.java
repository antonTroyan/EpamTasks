package text;

import Composite.SymbolSet;

public class WordHandler extends AbstractHandler {
    @Override
    public SymbolSet parse(SymbolSet symbolSet, String text) {
        System.out.println("WordHandler");
        return new SymbolSet();
    }

    String parse (String input){
        return "";
    }
}

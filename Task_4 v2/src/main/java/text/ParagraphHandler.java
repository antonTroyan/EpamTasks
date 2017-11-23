package text;


import Composite.SymbolSet;


public class ParagraphHandler extends AbstractHandler{
    @Override
    public SymbolSet parse(SymbolSet symbolSet, String text) {
        System.out.println("ParagraphHandler");
        return new SymbolSet();
    }

}

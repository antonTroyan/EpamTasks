package Chain;

import Composite.Symbol;
import Composite.SymbolSet;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        SymbolSetCreator symbolSetCreator = new SymbolSetCreator();

//        // работает
//        System.out.println(symbolSetCreator.parseToSymbol(new SymbolSet(), "Hello ddd"));

        //  работает но создает лишние объекты. Ошибка в паттерне
        System.out.println(symbolSetCreator.parseToWord(new SymbolSet(), "Hello dear anton!"));

//       System.out.println(symbolSetCreator.parseToSentence(new SymbolSet(), "Hello dear anton. Hi!"));



    }
}

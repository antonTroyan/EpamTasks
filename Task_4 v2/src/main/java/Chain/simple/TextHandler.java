package Chain.simple;

import Composite.Component;
import Composite.SymbolSet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TextHandler implements ParserInterface {
    ParserInterface successor;

    public TextHandler(ParserInterface successor) {
        this.successor = successor;
    }

    @Override
    public Component chain(Component result, String text) {
        SymbolSet core = new SymbolSet();
        core = (SymbolSet) successor.chain(core, loadFile("data//data.txt"));
        return core;
    }


    public String loadFile(String filename) {
        String allText = "";
        try {
            Scanner scanner = new Scanner(new FileReader(filename));
            while (scanner.hasNext()){
                allText += scanner.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return allText;
    }
}

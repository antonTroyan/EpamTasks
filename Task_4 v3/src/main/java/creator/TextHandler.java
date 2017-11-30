package creator;

import creator.handler.HandlerInterface;
import entity.component.Component;
import entity.SymbolSet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TextHandler implements HandlerInterface {

    private HandlerInterface successor;

    public TextHandler(HandlerInterface successor) {
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
            while (scanner.hasNext()) allText += scanner.nextLine() + "\n";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return allText;
    }
}

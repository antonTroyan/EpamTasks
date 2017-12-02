package by.troyan.task4.structurecreator;

import by.troyan.task4.structurecreator.handler.HandlerInterface;
import by.troyan.task4.entity.component.Component;
import by.troyan.task4.entity.SymbolSet;

public class TextHandler implements HandlerInterface {
    private String text;
    private HandlerInterface successor;

    public TextHandler(HandlerInterface successor, String text) {
        this.text = text;
        this.successor = successor;
    }

    @Override
    public Component chain(Component result, String text) {
        SymbolSet core = new SymbolSet();
        core = (SymbolSet) successor.chain(core, text);
        return core;
    }

}

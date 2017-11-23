package text;

import Composite.Component;
import Composite.SymbolSet;


import java.util.ArrayList;

public abstract class AbstractHandler {
    protected ArrayList<Component> components;
    protected Component mainComponent;
    protected AbstractHandler successor = DefaultHandleRequest.getHandleRequest();

    public AbstractHandler(AbstractHandler successor){
        this.components = new ArrayList();
        this.successor = successor;
    }
    public AbstractHandler(){
        this.components = new ArrayList();
    }

    abstract public SymbolSet parse(SymbolSet symbolSet, String text);

    public void setSuccessor(AbstractHandler successor) {  this.successor = successor; }

    public void chain (Component symbolSet){
            mainComponent = new SymbolSet();
            successor.chain(symbolSet);
    }

    private static class DefaultHandleRequest extends AbstractHandler {
        private static DefaultHandleRequest handler = new DefaultHandleRequest();

        private DefaultHandleRequest() {
        }

        @Override
        public SymbolSet parse(SymbolSet symbolSet, String text) {
            return null;
        }

        public static DefaultHandleRequest getHandleRequest() {
            return handler;
        }

        @Override
        public void chain(Component symbolSet) {
        }
    }
}

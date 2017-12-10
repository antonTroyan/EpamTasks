package by.troyan.task4.entity;

import by.troyan.task4.entity.component.Component;

public class Symbol implements Component {
    private String content;

    public Symbol(String enteringData) {
        this.content = enteringData;
    }

    public void add(Component c) {
        throw new UnsupportedOperationException();
    }

    public void remove(Component c) {
        throw new UnsupportedOperationException();
    }

    public Object getChild(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getComponentsSize() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol = (Symbol) o;

        return content != null ? content.equals(symbol.content) : symbol.content == null;
    }

    @Override
    public int hashCode() {
        return content != null ? content.hashCode() : 0;
    }

    @Override
    public String toString() {
        return content;
    }

}

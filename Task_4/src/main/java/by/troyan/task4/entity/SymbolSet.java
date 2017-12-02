package by.troyan.task4.entity;

import by.troyan.task4.entity.component.Component;

import java.util.ArrayList;
import java.util.List;

public class SymbolSet implements Component {
    private List<Component> components = new ArrayList<>();
    private static long idCounter = 0;
    private long symbolSetID;

    public SymbolSet() {
        symbolSetID = createID();
    }

    private static synchronized long createID()
    {
        return idCounter++;
    }

    public void operation() {
        int size = components.size();
        for (int i = 0; i < size; i++) {
            components.get(i).operation();
        }
    }

    public int getComponentsSize (){
        return components.size();
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    public Object getChild(int index) {
        return components.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SymbolSet symbolSet = (SymbolSet) o;

        return components != null ? components.equals(symbolSet.components) : symbolSet.components == null;
    }

    @Override
    public int hashCode() {
        return components != null ? components.hashCode() : 0;
    }

    @Override
    public String toString() {
        String result = " ";
        for (int i = 0; i < components.size(); i++){
            result += components.get(i);
        }
        return result;
    }
}

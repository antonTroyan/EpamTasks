package Composite;

import java.util.ArrayList;

public class SymbolSet implements Component{
    private ArrayList<Component> components = new ArrayList<>();

    private static long idCounter = 0;
    private long symbolSetID;

    public SymbolSet() {
        symbolSetID = createID();
    }

    public static synchronized long createID()
    {
        return idCounter++;
    }

    public void operation() {
        System.out.println("SymbolSet -> Call children operations");
        int size = components.size();
        for (int i = 0; i < size; i++) {
            components.get(i).operation();
        }
    }

    public void add(Component component) {
        components.add(component);
    }


    public void remove(Component component) {
        System.out.println("SymbolSet -> Removing component");
        components.remove(component);
    }

    public Object getChild(int index) {
        System.out.println("SymbolSet -> Getting component");
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
        String result = "Компонент id=" + symbolSetID + "[";
        for (int i = 0; i < components.size(); i++){

            System.out.println();
            result += "\n\t"+components.get(i);
        }
        return result + "]";
    }
}

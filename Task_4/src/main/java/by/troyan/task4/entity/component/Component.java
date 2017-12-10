package by.troyan.task4.entity.component;

public interface Component {

    void add(Component c);

    void remove(Component c);

    Object getChild(int index);

    int getComponentsSize ();
}

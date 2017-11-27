package entity.component;

public interface Component {

    void operation();

    void add(Component c);

    void remove(Component c);

    Object getChild(int index);

    int getComponentsSize ();

}

package Chain;

import Composite.Component;

public interface BaseInterface {
    Component parse(Component component);
    Component chain();
}

package creator.parser;

import entity.component.Component;

public interface ParserInterface {
    Component chain (Component result, String text);
}

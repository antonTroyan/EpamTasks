package Composite;

public class Symbol implements Component{
    private String content;
    private static long idCounter = 0;
    private long symbolID;


    public static synchronized long createID()
    {
        return idCounter++;
    }

    public Symbol(String enteringData) {
        this.content = enteringData;
        symbolID = createID();
    }


    public void operation() {
        System.out.println("Leaf -> Performing operation");
    }

    public void add(Component c) {
        throw new UnsupportedOperationException(); // генерация исключения и return false (если метод не void)
    }

    public void remove(Component c) {
        throw new UnsupportedOperationException(); // генерация исключения и return false (если метод не void)
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



//    @Override
//    public String toString() {
//        return "\tSymbol " +"id=" + symbolID + " {" +
//                "content='" + content + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return content;
    }

}

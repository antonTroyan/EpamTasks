package Composite;

public class Symbol implements Component{
    private String enteringData;

    public Symbol(String enteringData) {
        this.enteringData = enteringData;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol = (Symbol) o;

        return enteringData != null ? enteringData.equals(symbol.enteringData) : symbol.enteringData == null;
    }

    @Override
    public int hashCode() {
        return enteringData != null ? enteringData.hashCode() : 0;
    }



    @Override
    public String toString() {
        return "Symbol{" +
                "enteringData='" + enteringData + '\'' +
                '}';
    }
}

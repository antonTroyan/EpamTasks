package by.troyan.task4.calculating.counter;

public class TerminalExpressionDivide extends AbstractMathExpression {
    @Override
    public void interpret(Context c) {
        c.pushValue((c.popValue() / c.popValue()));
    }
}
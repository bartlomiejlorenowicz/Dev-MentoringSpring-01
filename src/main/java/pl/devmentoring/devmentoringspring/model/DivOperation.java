package pl.devmentoring.devmentoringspring.model;

public class DivOperation implements CalculationStrategy {
    @Override
    public int execute(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Don't divide by zero");
        }
        return a / b;
    }

    @Override
    public Operation getStrategy() {
        return Operation.DIV;
    }
}

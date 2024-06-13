package pl.devmentoring.devmentoringspring.model;

public class SubOperation implements CalculationStrategy {
    @Override
    public int execute(int a, int b) {
        return a - b;
    }

    @Override
    public Operation getStrategy() {
        return Operation.SUB;
    }
}

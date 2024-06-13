package pl.devmentoring.devmentoringspring.model;

public interface CalculationStrategy {

    int execute(int a, int b);

    Operation getStrategy();
}

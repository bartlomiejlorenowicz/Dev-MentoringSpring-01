package pl.devmentoring.devmentoringspring.model;

import lombok.Getter;

@Getter
public class Calculation {

    private int first;
    private int second;
    private Operation operation;

    public Calculation(int first, int second, Operation operation) {
        this.first = first;
        this.second = second;
        this.operation = operation;
    }
}

package pl.devmentoring.devmentoringspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.devmentoring.devmentoringspring.model.Calculation;
import pl.devmentoring.devmentoringspring.model.Operation;
import pl.devmentoring.devmentoringspring.repository.Database;

import java.util.UUID;

@Service
public class CalculationService {

    private Database database;

    @Autowired
    public CalculationService(Database database) {
        this.database = database;
    }

    public int operationResult(Calculation calculation) {
        int firstNumber = calculation.getFirst();
        int secondNumber = calculation.getSecond();
        Operation operation = calculation.getOperation();

        UUID uuid = generateUUID(firstNumber, secondNumber, operation);
        if (database.getOperations().containsKey(uuid)) {
            System.out.println("zwracana z cache");
            return database.getOperations().get(uuid);
        }

        int result = 0;
        if (operation == Operation.ADD) {
            result = addNumbers(firstNumber, secondNumber);
        } else if (operation == Operation.ODD) {
            result = oddNumbers(firstNumber, secondNumber);
        } else if (operation == Operation.MUL) {
            result = mulNumbers(firstNumber, secondNumber);
        } else if (operation == Operation.DIV) {
            result = divNumbers(firstNumber, secondNumber);
        }
        database.getOperations().put(uuid, result);
        System.out.println("zwracana z bazy danych");

        return result;
    }

    private UUID generateUUID(int first, int second, Operation operation) {
        String uniqueOperation = first + ":" + second + ":" + operation;
        return UUID.nameUUIDFromBytes(uniqueOperation.getBytes());
    }

    public int addNumbers(int first, int second) {
        return first + second;
    }

    public int oddNumbers(int first, int second) {
        return first - second;
    }

    public int mulNumbers(int first, int second) {
        return first * second;
    }

    public int divNumbers(int first, int second) {
        if (second == 0) {
            throw new IllegalArgumentException("Don't divide by zero");
        }
        return first / second;
    }
}

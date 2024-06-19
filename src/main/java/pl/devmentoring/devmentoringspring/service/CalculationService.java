package pl.devmentoring.devmentoringspring.service;

import org.springframework.stereotype.Service;
import pl.devmentoring.devmentoringspring.model.Calculation;
import pl.devmentoring.devmentoringspring.model.CalculationStrategy;
import pl.devmentoring.devmentoringspring.model.Operation;
import pl.devmentoring.devmentoringspring.repository.Database;

import java.util.Map;
import java.util.UUID;

@Service
public class CalculationService {

    private Map<Operation, CalculationStrategy> calculationStrategyMap;
    private Database database;

    public CalculationService(Map<Operation, CalculationStrategy> calculationStrategyMap, Database database) {
        this.calculationStrategyMap = calculationStrategyMap;
        this.database = database;
    }

    public Map<Operation, CalculationStrategy> getCalculationStrategyMap() {
        return calculationStrategyMap;
    }

    public int calculate(Operation operation, int a, int b) {
        CalculationStrategy strategy = calculationStrategyMap.get(operation);
        if (strategy != null) {
            return strategy.execute(a, b);
        } else {
            throw new IllegalArgumentException("Invalid operation");
        }
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

        int result = calculate(operation, firstNumber, secondNumber);
        database.getOperations().put(uuid, result);
        System.out.println("zwracana z bazy danych");

        return result;
    }

    private UUID generateUUID(int first, int second, Operation operation) {
        String uniqueOperation = first + ":" + second + ":" + operation;
        return UUID.nameUUIDFromBytes(uniqueOperation.getBytes());
    }
}

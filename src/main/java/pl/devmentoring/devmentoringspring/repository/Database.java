package pl.devmentoring.devmentoringspring.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class Database {

    Map<UUID, Integer> operations = new HashMap<>();

    public Map<UUID, Integer> getOperations() {
        return operations;
    }
}

package pl.devmentoring.devmentoringspring.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Repository
public class Database {

    Map<UUID, Integer> operations = new HashMap<>();
}

package pl.devmentoring.devmentoringspring.model;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToOperationConverter implements Converter<String, Operation> {

    @Override
    public Operation convert(String source) {
        try {
            return Operation.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid operation.");
        }
    }
}

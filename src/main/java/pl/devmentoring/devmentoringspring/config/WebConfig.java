package pl.devmentoring.devmentoringspring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.devmentoring.devmentoringspring.model.StringToOperationConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final StringToOperationConverter stringToOperationConverter;

    public WebConfig(StringToOperationConverter stringToOperationConverter) {
        this.stringToOperationConverter = stringToOperationConverter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToOperationConverter);
    }
}

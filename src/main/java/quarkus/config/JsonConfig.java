package quarkus.config;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import io.quarkus.jackson.ObjectMapperCustomizer;

import javax.inject.Singleton;


@Singleton
public class JsonConfig implements ObjectMapperCustomizer {

    @Override
    public void customize(ObjectMapper objectMapper) {
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static ObjectMapper build() {
        JsonConfig jsonConfig = new JsonConfig();
        ObjectMapper objectMapper = new ObjectMapper();
        jsonConfig.customize(objectMapper);
        return objectMapper;
    }
}

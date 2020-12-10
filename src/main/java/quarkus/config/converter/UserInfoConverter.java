package quarkus.config.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import quarkus.config.JsonConfig;
import quarkus.model.entity.UserInfo;
import quarkus.model.exception.ApiException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UserInfoConverter implements AttributeConverter<UserInfo, String> {
    private final ObjectMapper objectMapper = JsonConfig.build();

    @Override
    public String convertToDatabaseColumn(UserInfo attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new ApiException(e);
        }
    }

    @Override
    public UserInfo convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        try {
            return objectMapper.readValue(dbData, UserInfo.class);
        } catch (JsonProcessingException e) {
            throw new ApiException(e);
        }
    }
}



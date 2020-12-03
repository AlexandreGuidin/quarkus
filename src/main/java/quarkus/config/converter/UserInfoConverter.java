package quarkus.config.converter;

import quarkus.model.entity.UserInfo;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UserInfoConverter implements AttributeConverter<UserInfo, String> {
    private static final Jsonb jsonb = JsonbBuilder.create();

    @Override
    public String convertToDatabaseColumn(UserInfo attribute) {
        return jsonb.toJson(attribute);
    }

    @Override
    public UserInfo convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return jsonb.fromJson(dbData, UserInfo.class);
    }
}



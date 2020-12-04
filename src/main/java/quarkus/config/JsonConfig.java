package quarkus.config;


import io.quarkus.jsonb.JsonbConfigCustomizer;

import javax.inject.Singleton;
import javax.json.bind.JsonbConfig;

import static javax.json.bind.JsonbConfig.PROPERTY_NAMING_STRATEGY;
import static javax.json.bind.config.PropertyNamingStrategy.LOWER_CASE_WITH_UNDERSCORES;

@Singleton
public class JsonConfig implements JsonbConfigCustomizer {

    public void customize(JsonbConfig config) {
        config.setProperty(PROPERTY_NAMING_STRATEGY, LOWER_CASE_WITH_UNDERSCORES);
    }
}

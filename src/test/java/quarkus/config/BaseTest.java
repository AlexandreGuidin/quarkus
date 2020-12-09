package quarkus.config;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.IOException;
import java.util.Objects;

public abstract class BaseTest {

    public String readJson(String path) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            return new String(Objects.requireNonNull(classLoader.getResourceAsStream(path)).readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

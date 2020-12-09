package quarkus.config;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;
import java.util.Objects;

public class JsonMatcher extends BaseMatcher<String> {

    private final String fileValue;

    public JsonMatcher(String jsonPath) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            this.fileValue = new String(Objects.requireNonNull(classLoader.getResourceAsStream(jsonPath)).readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean matches(Object responseBody) {
        try {
            JSONAssert.assertEquals(fileValue, String.valueOf(responseBody), false);
            return true;
        } catch (JSONException e) {
            return false;
        }

    }

    @Override
    public void describeTo(Description description) {
    }

    public static Matcher<String> equalToJson(String substring) {
        return new JsonMatcher(substring);
    }
}

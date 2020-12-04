package quarkus.model;

import org.jboss.resteasy.api.validation.ResteasyConstraintViolation;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class ValidationError {

    private String field;
    private String message;
    private String value;

    public ValidationError(ResteasyConstraintViolation violation) {
        this.field = Arrays.stream(violation.getPath().split("\\.")).skip(2).collect(Collectors.joining("."));
        this.message = violation.getMessage();
        this.value = Optional.ofNullable(violation.getValue()).map(Object::toString).orElse("null");
    }

    public boolean haveValues() {
        return !field.isEmpty() && !message.isEmpty();
    }

    public ValidationError() {
    }

    public ValidationError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public ValidationError(String field, String message, String value) {
        this.field = field;
        this.message = message;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public ValidationError setField(String field) {
        this.field = field;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ValidationError setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getValue() {
        return value;
    }

    public ValidationError setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                "field='" + field + '\'' +
                ", message='" + message + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

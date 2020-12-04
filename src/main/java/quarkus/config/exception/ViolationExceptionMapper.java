package quarkus.config.exception;

import org.jboss.resteasy.api.validation.ResteasyViolationException;
import quarkus.model.ValidationError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;
import java.util.stream.Collectors;

@Provider
public class ViolationExceptionMapper implements ExceptionMapper<ResteasyViolationException> {

    @Override
    public Response toResponse(ResteasyViolationException exception) {
        List<ValidationError> errors = exception.getViolations()
                .stream()
                .map(ValidationError::new)
                .collect(Collectors.toList());

        return Response.status(422).entity(errors).build();
    }
}

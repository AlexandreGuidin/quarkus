package quarkus.config.exception;

import org.jboss.logging.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {
    private static final Logger logger = Logger.getLogger(RuntimeExceptionMapper.class);

    @Override
    public Response toResponse(RuntimeException exception) {
        logger.error(String.format("unexpect runtime exception: %s", exception.getMessage()), exception);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}

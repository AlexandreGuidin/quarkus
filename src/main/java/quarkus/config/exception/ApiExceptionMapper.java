package quarkus.config.exception;

import org.jboss.logging.Logger;
import quarkus.model.exception.ApiException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApiExceptionMapper implements ExceptionMapper<ApiException> {
    private static final Logger logger = Logger.getLogger(ApiExceptionMapper.class);

    @Override
    public Response toResponse(ApiException exception) {
        logger.error(exception);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}

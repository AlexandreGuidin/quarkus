package quarkus.config.exception;

import org.jboss.logging.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {
    private static final Logger logger = Logger.getLogger(GenericExceptionMapper.class);

    @Override
    public Response toResponse(Exception exception) {
        logger.error(exception);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}

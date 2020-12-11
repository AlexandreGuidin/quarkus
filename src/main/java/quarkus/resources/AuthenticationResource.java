package quarkus.resources;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;
import quarkus.model.to.AuthenticationRequest;
import quarkus.security.JwtUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Base64;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Authentication")
public class AuthenticationResource {
    private static final Logger logger = Logger.getLogger(AuthenticationRequest.class);
    private final Response UNAUTHORIZED = Response.status(Response.Status.UNAUTHORIZED).build();

    @ConfigProperty(name = "app.security.jwt-secret")
    private String jwtSecret;

    @POST
    public Response authenticate(@HeaderParam("Authorization") String basicAuth) {
        if (basicAuth == null || basicAuth.isEmpty()) {
            return UNAUTHORIZED;
        }

        basicAuth = basicAuth.replace("Basic ", "");
        AuthenticationRequest authenticationRequest = AuthenticationRequest.build(new String(Base64.getDecoder().decode(basicAuth)).split(":"));
        if (authenticationRequest == null) {
            return UNAUTHORIZED;
        }

        //TODO find by email

        String jwt = JwtUtils.buildJwt(jwtSecret, "id");
        return Response.ok().header("Authorization", jwt).build();
    }
}

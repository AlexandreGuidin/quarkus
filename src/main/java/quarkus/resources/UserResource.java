package quarkus.resources;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import quarkus.model.ValidationError;
import quarkus.model.to.UserRequest;
import quarkus.model.to.UserResponse;
import quarkus.repository.UserRepository;
import quarkus.service.UserService;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
@Tag(name = "User")
public class UserResource {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserResource(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GET
    @RolesAllowed({ "User", "Admin" })
    @APIResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = UserResponse[].class)))
    @APIResponse(responseCode = "500", description = "Internal error")
    public List<UserResponse> list() {
        return userRepository.streamAll()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({ "User", "Admin" })
    @APIResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = UserResponse.class)))
    @APIResponse(responseCode = "404", description = "Not found")
    @APIResponse(responseCode = "500", description = "Internal error")
    public UserResponse findById(@PathParam("id") UUID id) {
        return userRepository.findByIdOptional(id)
                .map(UserResponse::new)
                .orElseThrow(NotFoundException::new);
    }

    @POST
    @RolesAllowed({ "User", "Admin" })
    @APIResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = UserResponse.class)))
    @APIResponse(responseCode = "422", content = @Content(schema = @Schema(implementation = ValidationError[].class)))
    @APIResponse(responseCode = "500", description = "Internal error")
    public UserResponse save(@Valid UserRequest request) {
        return userService.save(request);
    }
}

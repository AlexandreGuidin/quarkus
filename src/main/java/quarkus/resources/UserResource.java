package quarkus.resources;

import org.jboss.logging.Logger;
import quarkus.model.to.UserRequest;
import quarkus.model.to.UserResponse;
import quarkus.repository.UserRepository;
import quarkus.service.UserService;

import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("/user")
public class UserResource {
    private static final Logger logger = Logger.getLogger(UserResource.class);

    private final UserRepository userRepository;
    private final UserService userService;

    public UserResource(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GET
    @Produces("application/json")
    public List<UserResponse> list() {
        return userRepository.streamAll()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public UserResponse findById(@PathParam("id") UUID id) {
        return userRepository.findByIdOptional(id)
                .map(UserResponse::new)
                .orElseThrow(NotFoundException::new);
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public UserResponse save(@Valid UserRequest request) {
        return userService.save(request);
    }
}

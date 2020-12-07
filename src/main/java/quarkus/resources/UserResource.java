package quarkus.resources;

import quarkus.model.to.UserRequest;
import quarkus.model.to.UserResponse;
import quarkus.repository.UserRepository;
import quarkus.service.UserService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    private final UserRepository userRepository;
    private final UserService userService;

    public UserResource(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GET
    public List<UserResponse> list() {
        return userRepository.streamAll()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public UserResponse findById(@PathParam("id") UUID id) {
        return userRepository.findByIdOptional(id)
                .map(UserResponse::new)
                .orElseThrow(NotFoundException::new);
    }

    @POST
    public UserResponse save(@Valid UserRequest request) {
        return userService.save(request);
    }
}

package quarkus.resources;

import quarkus.model.to.UserResponse;
import quarkus.repository.UserRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("/user")
public class UserResource {

    private final UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        return new UserResponse(userRepository.findById(id));
    }

//    @GET
//    @Produces("application/json")
//    @Consumes("application/json")
//    public UserResponse save(UserRequest request) {
//        return new UserResponse();
//    }
}

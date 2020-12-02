package quarkus.resources;

import quarkus.model.entity.UserEntity;
import quarkus.model.to.UserRequest;
import quarkus.model.to.UserResponse;
import quarkus.repository.UserRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
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

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Transactional
    public UserResponse save(@Valid UserRequest request) {
        System.out.println(request);
        UserEntity entity = new UserEntity(request);
        userRepository.persist(entity);
        return new UserResponse(entity);
    }
}

package guidin.resources;

import guidin.model.to.UserRequest;
import guidin.model.to.UserResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Arrays;
import java.util.List;

@Path("/user")
public class UserResource {

    @GET
    @Produces("application/json")
    public List<UserResponse> list(){
        return Arrays.asList(new UserResponse(), new UserResponse());
    }

    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public UserResponse save(UserRequest request){
        return new UserResponse();
    }
}

package guidin.model.to;

import java.time.ZonedDateTime;
import java.util.UUID;

public class UserResponse {
    private UUID id;
    private String name;
    private ZonedDateTime lastLogin;

    public UserResponse() {
        this.id = UUID.randomUUID();
        this.name = "bla";
        this.lastLogin = ZonedDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public UserResponse setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserResponse setName(String name) {
        this.name = name;
        return this;
    }

    public ZonedDateTime getLastLogin() {
        return lastLogin;
    }

    public UserResponse setLastLogin(ZonedDateTime lastLogin) {
        this.lastLogin = lastLogin;
        return this;
    }
}

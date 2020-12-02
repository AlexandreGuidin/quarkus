package quarkus.model.to;

public class UserRequest {
    private String name;

    public String getName() {
        return name;
    }

    public UserRequest setName(String name) {
        this.name = name;
        return this;
    }
}

package quarkus.model.to;

import quarkus.model.entity.UserInfo;

public class UserInfoResponse {
    private String name;
    private String email;

    public UserInfoResponse() {
    }

    public UserInfoResponse(UserInfo info) {
        if(info != null) {
            this.name = info.getName();
            this.email = info.getEmail();
        }
    }

    public String getName() {
        return name;
    }

    public UserInfoResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserInfoResponse setEmail(String email) {
        this.email = email;
        return this;
    }
}

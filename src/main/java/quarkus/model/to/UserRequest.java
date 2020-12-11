package quarkus.model.to;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserRequest {
    @NotEmpty
    private String documentNumber;

    @NotEmpty
    private String name;

    @Email(message = "invalid")
    private String email;

    @NotEmpty
    private String password;

    private String passwordHash;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public UserRequest setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public UserRequest setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
        return this;
    }
}

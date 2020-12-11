package quarkus.model.to;

import quarkus.security.CryptUtils;

public class AuthenticationRequest {
    private final String email;
    private final String passwordHash;

    public AuthenticationRequest(String email, String passwordHash) {
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public static AuthenticationRequest build(String[] data) {
        String email = data[0];
        if (email == null || email.isEmpty()) {
            return null;
        }

        String rawPassword = data[1];
        if (rawPassword == null || rawPassword.isEmpty()) {
            return null;
        }

        String passwordHash = CryptUtils.tryToCrypt(rawPassword);
        if (passwordHash == null || passwordHash.isEmpty()) {
            return null;
        }

        return new AuthenticationRequest(email, passwordHash);
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}

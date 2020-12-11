package quarkus.security;

import io.smallrye.jwt.build.Jwt;

public class JwtUtils {

    public static String buildJwt(String jwtSecret, String userId) {
        return Jwt.subject(userId).signWithSecret(jwtSecret);
    }
}

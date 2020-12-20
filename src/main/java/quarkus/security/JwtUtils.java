package quarkus.security;

import io.smallrye.jwt.build.Jwt;

import java.util.Arrays;
import java.util.HashSet;

public class JwtUtils {

    public static String buildJwt(String userId) {
        return Jwt.subject(userId)
                .groups(new HashSet<>(Arrays.asList("User")))
                .sign();
    }
}

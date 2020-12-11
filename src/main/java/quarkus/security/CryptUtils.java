package quarkus.security;

import io.quarkus.elytron.security.common.BcryptUtil;
import org.jboss.logging.Logger;
import quarkus.model.exception.ApiException;
import quarkus.model.to.AuthenticationRequest;

import java.util.Optional;

public class CryptUtils {
    private static final Logger logger = Logger.getLogger(AuthenticationRequest.class);

    public static String crypt(String raw) {
        try {
            return BcryptUtil.bcryptHash(raw);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public static String tryToCrypt(String raw) {
        try {
            return BcryptUtil.bcryptHash(raw);
        } catch (Exception e) {
            logger.error("failed to crypt", e);
            return null;
        }
    }
}

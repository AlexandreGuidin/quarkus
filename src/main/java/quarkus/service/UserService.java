package quarkus.service;

import quarkus.model.entity.UserEntity;
import quarkus.model.to.UserRequest;
import quarkus.model.to.UserResponse;
import quarkus.repository.UserRepository;
import quarkus.security.CryptUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponse save(UserRequest request) {
        request.setPasswordHash(CryptUtils.crypt(request.getPassword()));

        UserEntity entity = new UserEntity(request);
        userRepository.persist(entity);
        return new UserResponse(entity);
    }
}

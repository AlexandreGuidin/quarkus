package quarkus.service;

import quarkus.model.entity.UserEntity;
import quarkus.model.to.UserRequest;
import quarkus.model.to.UserResponse;
import quarkus.repository.UserRepository;

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
        UserEntity entity = new UserEntity(request);
        userRepository.persist(entity);
        return new UserResponse(entity);
    }
}

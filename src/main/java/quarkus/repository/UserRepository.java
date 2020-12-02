package quarkus.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import quarkus.model.entity.UserEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<UserEntity, UUID> {
}

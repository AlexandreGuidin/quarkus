package quarkus.model.to;

import quarkus.model.entity.UserEntity;

import java.time.ZonedDateTime;
import java.util.UUID;

public class UserResponse {
    private UUID id;
    private String documentNumber;
    private ZonedDateTime createdAt;

    public UserResponse(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.documentNumber = userEntity.getDocumentNumber();
        this.createdAt = userEntity.getCreatedAt();
    }

    public UUID getId() {
        return id;
    }

    public UserResponse setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public UserResponse setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
        return this;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public UserResponse setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}

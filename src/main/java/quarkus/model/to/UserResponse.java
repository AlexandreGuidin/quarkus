package quarkus.model.to;

import quarkus.model.entity.UserEntity;

import javax.json.bind.annotation.JsonbDateFormat;
import java.time.ZonedDateTime;
import java.util.UUID;

public class UserResponse {
    private UUID id;
    private String documentNumber;
    private UserInfoResponse info;
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
    private ZonedDateTime createdAt;

    public UserResponse(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.documentNumber = userEntity.getDocumentNumber();
        this.info = new UserInfoResponse(userEntity.getInfo());
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

    public UserInfoResponse getInfo() {
        return info;
    }

    public UserResponse setInfo(UserInfoResponse info) {
        this.info = info;
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

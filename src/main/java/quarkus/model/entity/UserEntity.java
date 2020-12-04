package quarkus.model.entity;

import quarkus.config.converter.UserInfoConverter;
import quarkus.model.to.UserRequest;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity(name = "user_sample_table")
public class UserEntity {

    @Id
    private UUID id;

    @Column(name = "document_number")
    private String documentNumber;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @Convert(converter = UserInfoConverter.class)
    @Column(columnDefinition = "jsonb")
    private UserInfo info;

    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    public UserEntity() {
    }

    public UserEntity(UserRequest userRequest) {
        this.id = UUID.randomUUID();
        this.documentNumber = userRequest.getDocumentNumber();
        this.createdAt = ZonedDateTime.now();
        this.info = new UserInfo(userRequest);
    }

    public UUID getId() {
        return id;
    }

    public UserEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public UserEntity setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
        return this;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public UserEntity setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public UserInfo getInfo() {
        return info;
    }

    public UserEntity setInfo(UserInfo info) {
        this.info = info;
        return this;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public UserEntity setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}

package quarkus.model.to;

import javax.validation.constraints.NotEmpty;

public class UserRequest {
    @NotEmpty
    private String documentNumber;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public UserRequest setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
        return this;
    }
}

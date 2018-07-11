package com.jersey.app.ws.ui.model.response.errors;

public enum ErrorMessages {
    MISSING_REQUIRED_FIELD("Missing required field."),
    RECORD_ALREADY_EXISTS("Record already exists."),
    INTERNAL_SERVER_ERROR("Generic class exception.");
    private String errorMessages;

    ErrorMessages(String errorMessages) {
        this.errorMessages = errorMessages;
    }

    public String getErrorMessage() {
        return errorMessages;
    }

    public void setErrorMessages(String errorMessages) {
        this.errorMessages = errorMessages;
    }
}

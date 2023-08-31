package com.example.GoogleDriveDemo.model;

public class ResponseModal {
    boolean success;
    String message;
    Object object;

    public ResponseModal(boolean success, String message, Object object) {
        this.success = success;
        this.message = message;
        this.object = object;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "ResponseModal{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", object=" + object +
                '}';
    }
}

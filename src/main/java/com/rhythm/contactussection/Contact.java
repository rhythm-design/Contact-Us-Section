package com.rhythm.contactussection;

public class Contact {
    private String fullName;

    private String email;

    private String message;

    private long id;

    public Contact(String fullName, String email, String message, long id) {
        this.fullName = fullName;
        this.email = email;
        this.message = message;
        this.id = id;
    }

    public Contact(String fullName, String email, String message) {
        this.fullName = fullName;
        this.email = email;
        this.message = message;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", id=" + id +
                '}';
    }
}


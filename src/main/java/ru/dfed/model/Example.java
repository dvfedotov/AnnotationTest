package ru.dfed.model;

import java.time.LocalDateTime;

public class Example {


    private long id;
    private String firstName;
    private String lastName;
    private LocalDateTime dateCreated;


    public Example() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public Example firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Example lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }


    @Override
    public String toString() {
        return "Example{"
            + "id=" + id
            + ", firstName='" + firstName + '\''
            + ", lastName='" + lastName + '\''
            + ", dateCreated='" + dateCreated + '\''
            + '}';
    }
}




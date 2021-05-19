package ru.dfed.model.dto;

import java.util.Objects;

public class ExampleDto {

    private long id;
    private String fullName;


    public ExampleDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExampleDto that = (ExampleDto) o;
        return Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }

    @Override
    public String toString() {
        return "ExampleDto{"
            + "id=" + id
            + ", firstName='" + fullName + '\''
            + '}';
    }
}


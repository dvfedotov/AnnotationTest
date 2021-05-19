package ru.dfed.model.dto;

public class ExampleDto {

    private long id;
    private String fullName;
    private String dateCreated;


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

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "ExampleDto{"
            + "id=" + id
            + ", firstName='" + fullName + '\''
            + ", dateCreated='" + dateCreated + '\''
            + '}';
    }
}

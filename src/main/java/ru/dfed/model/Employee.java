package ru.dfed.model;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1493034508761989322L;
    private String id;
    private String firstName;
    private String lastName;
    private List<Address> address = null;
    private List<Phone> phone = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Employee.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null) ? "<null>" : this.firstName));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null) ? "<null>" : this.lastName));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null) ? "<null>" : this.address));
        sb.append(',');
        sb.append("phone");
        sb.append('=');
        sb.append(((this.phone == null) ? "<null>" : this.phone));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.firstName == null) ? 0 : this.firstName.hashCode()));
        result = ((result * 31) + ((this.lastName == null) ? 0 : this.lastName.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.address == null) ? 0 : this.address.hashCode()));
        result = ((result * 31) + ((this.phone == null) ? 0 : this.phone.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Employee) == false) {
            return false;
        }
        Employee rhs = ((Employee) other);
        return ((((((this.firstName == rhs.firstName) || ((this.firstName != null)
            && this.firstName.equals(rhs.firstName)))
            && ((this.lastName == rhs.lastName) || ((this.lastName != null) && this.lastName.equals(rhs.lastName))))
            && ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id))))
            && ((this.address == rhs.address) || ((this.address != null) && this.address.equals(rhs.address))))
            && ((this.phone == rhs.phone) || ((this.phone != null) && this.phone.equals(rhs.phone))));
    }

}
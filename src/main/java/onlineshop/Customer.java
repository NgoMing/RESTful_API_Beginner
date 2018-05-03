package onlineshop;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Customer {

    private Long   id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public Customer() {}

    public Customer(String firstName, String lastName, String username, String password) {
        this(null, firstName, lastName, username, password);
    }

    public Customer(Long id, String firstName, String lastName, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    // getter and setter for id attribute
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // getter and setter for firstName attribute

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // getter and setter for lastName attribute

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // getter and setter for username attribute

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // getter and setter for password attribute

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "firstName", "lastName", "username", "password");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "firstName", "lastName", "username", "password");
    }
}

package com.yudha29.contactperson;

/**
 * User data model
 *
 * Class to define the user model.
 */
public class User {
    /** Attributes **/

    public String id;
    public String name;
    public String email;

    /** Getter & Setter **/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

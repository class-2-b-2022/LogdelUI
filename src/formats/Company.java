package formats;

import java.io.Serializable;

    /*
     Fields required for company registration
     - TIN (Tax Identification Number)
     - name
     - email
     - type
     - phone
     */


public class Company implements Serializable {
    private Integer TIN;
    private String name;
    private String email;
    private String type;
    private Integer phone;
    private String description;

    public Integer getTIN() {
        return TIN;
    }

    public void setTIN(Integer TIN) {
        this.TIN = TIN;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}


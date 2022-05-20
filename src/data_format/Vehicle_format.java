package data_format;
import java.io.Serializable;

public class Vehicle_format implements Serializable {
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String description;
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    String owner;
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    String brand;
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String model;

    public String getPlateNbr() {
        return plateNbr;
    }

    public void setPlateNbr(String plate) {
        this.plateNbr = plate;
    }

    public String plateNbr;

}
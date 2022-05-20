package formats;

import java.io.Serializable;
import java.sql.Date;

public class VehicleModel implements Serializable {
    private String model;
    private Integer vehicleId;
    private String plateNbr;
    private String brand;
    private String owner;
    private String description;
    private Date createdAt;

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlateNbr() {
        return plateNbr;
    }

    public void setPlateNbr(String plateNbr) {
        this.plateNbr = plateNbr;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

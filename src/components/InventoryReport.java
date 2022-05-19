package components;

import java.sql.Date;

public class InventoryReport {
    private Date date;
    private String companyName;
    private String status;
    private String  product;
    private Integer quantity;

    public Date getDate() {
        return date;
    }

    public Date setDate(Date date) {
        this.date = date;
        return date;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatus(String status) {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProduct(Integer productName) {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity(int quantity) {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



}
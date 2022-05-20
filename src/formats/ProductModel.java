package formats;

import java.io.Serializable;

public class ProductModel implements Serializable {
    int productId;
    String productName;
    String productType;
    int companyId;
    int pricePerBulk;

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setPricePerBulk(int pricePerBulk) {
        this.pricePerBulk = pricePerBulk;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getCompanyId() {
        return companyId;
    }

    public int getProductId() {
        return productId;
    }

    public int getPricePerBulk() {
        return pricePerBulk;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }
}

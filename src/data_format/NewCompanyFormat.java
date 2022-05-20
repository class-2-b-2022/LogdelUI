package data_format;


public class NewCompanyFormat {
    private int companyOwner;
    private String companyName;
    private String companyEmail;
    private String companyType;
    private String companyPhone;
    private String companyDescription;

    public NewCompanyFormat(int companyOwner, String companyName, String companyEmail, String companyPhone, String companyType, String companyDescription){
        this.companyOwner = companyOwner;
        this.companyDescription = companyDescription;
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyPhone = companyPhone;
        this.companyType = companyType;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyType() {
        return companyType;
    }

    public int getCompanyOwner() {
        return companyOwner;
    }

    public void setCompanyOwner(int companyOwner) {
        this.companyOwner = companyOwner;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public NewCompanyFormat(){

    }

    // @Override
    // public String toString() {
    //     return "Company{" +
    //             "companyName='" + companyName + '\'' +
    //             ", companyEmail='" + companyEmail + '\'' +
    //             ", companyType='" + companyType + '\'' +
    //             ", companyPhone='" + companyPhone + '\'' +
    //             ", companyDescription='" + companyDescription + '\'' +
    //             '}';
    // }



}

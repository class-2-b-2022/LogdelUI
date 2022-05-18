package formats;

public class User {
	private String names;
    private String email;
    private String password;
    private String roleAsString;
    private int phone;
    private int role;
    private int userId;
    public User() {}
    public User(String names,String email,String password,String roleAsString,int phone,int role) {
        this.names=names;
        this.email=email;
        this.password=password;
        this.roleAsString=roleAsString;
        this.phone=phone;
        this.role=role;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getRoleAsString() {
        return roleAsString;
    }

    public void setRoleAsString(String roleAsString) {
        this.roleAsString = roleAsString;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

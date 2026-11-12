package entity.user;

public class User {
    private String id;
    private String username;
    private String passwordH;
    private String name;
    private String zipCode;
    private String countryCode;

    public User(String id, String username, String passwordH, String name, String zipCode, String countryCode){
        this.id = id;
        this.username = username;
        this.passwordH = passwordH;
        this.name = name;
        this.zipCode = zipCode;
        this.countryCode = countryCode;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordH() {
        return passwordH;
    }

    public String getName() {
        return name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswordH(String passwordH) {
        this.passwordH = passwordH;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}

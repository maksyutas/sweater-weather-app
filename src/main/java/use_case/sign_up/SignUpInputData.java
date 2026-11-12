package use_case.sign_up;

public class SignUpInputData {
    private final String username;
    private final String password;
    private final String name;
    private final String zipCode;
    private final String countryCode;

    public SignUpInputData (String username, String password, String name, String zipCode, String countryCode){
        this.username = username;
        this.password = password;
        this.name = name;
        this.zipCode = zipCode;
        this.countryCode = countryCode;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }

    public String getZipCode(){
        return zipCode;
    }

    public String getCountryCode(){
        return countryCode;
    }


}

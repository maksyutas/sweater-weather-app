package use_case.sign_up;

public class SignUpOutputData {
    private final String userId;
    private final String username;

    public SignUpOutputData(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername(){
        return username;
    }
}

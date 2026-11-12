package use_case.sign_up;

import entity.user.User;

public interface SignUpAccessInterface {
    boolean existByUserName(String username);

    void save(User user);
}

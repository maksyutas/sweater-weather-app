package use_case.sign_up;

import entity.user.User;

import java.util.Locale;
import java.util.UUID;

public class SignUpInteractor implements SignUpInputBoundary {
    private final SignUpAccessInterface userDatabase;
    private final SignUpOutputBoundary presenter;
    private final PasswordHasher passwordHasher;

    public SignUpInteractor(SignUpAccessInterface userDatabase, SignUpOutputBoundary presenter, PasswordHasher passwordHasher) {
        this.userDatabase = userDatabase;
        this.presenter = presenter;
        this.passwordHasher = passwordHasher;
    }

    @Override
    public void execute(SignUpInputData inputData) {
        String username = inputData.getUsername();
        String password = inputData.getPassword();
        String name = inputData.getName();
        String zipCode = inputData.getZipCode();
        String countryCode = inputData.getCountryCode();

        if (username == null || username.isBlank()) {
            presenter.prepareFailView("Username is required.");
            return;
        }
        if (name == null || name.isBlank()) {
            presenter.prepareFailView("Name is required.");
            return;
        }
        if (password == null || password.length() < 6 || password.length() > 12) {
            presenter.prepareFailView("Password must be between 6 and 12 character long.");
            return;
        }
        if (zipCode == null || zipCode.isBlank() || postalCode.codePoints().anyMatch(c -> Character.isWhitespace(c) || Character.isSpaceChar(c))) {
            presenter.prepareFailView("Zip Code is required and cannot have spaces.");
            return;
        }
        if (countryCode == null
                || !countryCode.matches("[a-zA-Z]{2}")) {
            presenter.prepareFailView(
                    "Country code must contain exactly two letters.");
            return;
        }
        username = username.strip();
        name = name.strip();
        zipCode = zipCode.toUpperCase(Locale.ROOT);
        countryCode = countryCode.toUpperCase(Locale.ROOT);

        if (userDatabase.existByUserName(username)) {
            presenter.prepareFailView("The username is already taken.");
            return;
        }

        String userId = UUID.randomUUID().toString();
        String passwordHash = passwordHasher.hash(password);

        User user = new User(
                userId,
                username,
                passwordHash,
                name,
                zipCode,
                countryCode
        );
        userDatabase.save(user);

        SignUpOutputData outputData = new SignUpOutputData(userId, username);

        presenter.prepareSuccessView(outputData);
    }


}

package use_case.sign_up;

public class SignUpInputTest {
    public static void main(String[] args) {
        SignUpInputData input = new SignUpInputData(
                "carmen",
                "Sweater123!",
                "Carmen",
                "M5S 1A1",
                "CA"
        );

        check("username", "carmen", input.getUsername());
        check("password", "Sweater123!", input.getPassword());
        check("name", "Carmen", input.getName());
        check("postal code", "M5S 1A1", input.getZipCode());
        check("country code", "CA", input.getCountryCode());

        System.out.println("All checks passed!");
    }

    private static void check(String field, String expected,
                              String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(field + " was stored incorrectly");
        }
    }
}
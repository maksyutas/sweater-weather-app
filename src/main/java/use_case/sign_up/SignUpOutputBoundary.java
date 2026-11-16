package use_case.sign_up;

public interface SignUpOutputBoundary {
    void prepareSuccessView(SignUpOutputData outputData);

    void prepareFailView(String errorMessage);
}

package use_case.algorithm;

/**
 * Output boundary (presenter port) used by {@link AlgorithmInteractor}
 * to send outfit results or failure messages to the presentation layer.
 */

/**
 * TODO: SOFIAA
 */
public interface AlgorithmOutputBoundary {
    /**
     * Prepares the view when an outfit is successfully generated.
     *
     * @param outputData the {@link AlgorithmOutputData} containing the outfit and status info
     */
    void prepareSuccessView(AlgorithmOutputData outputData);

    /**
     * Prepares the view when an outfit cannot be generated or an error occurs.
     *
     * @param errorMessage explanation or alternative suggestion for the user
     */
    void prepareFailView(String errorMessage);
}
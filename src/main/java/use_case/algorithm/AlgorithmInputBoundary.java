package use_case.algorithm;

/**
 * Input boundary (use case port) invoked to run the outfit recommendation algorithm.
 */

/**
 * TODO: SOFIAA
 */
public interface AlgorithmInputBoundary {

    /**
     * Executes the outfit recommendation use case using the provided input data.
     *
     * @param inputData the {@link AlgorithmInputData} containing mode and user preferences
     */
    void execute(AlgorithmInputData inputData);
}
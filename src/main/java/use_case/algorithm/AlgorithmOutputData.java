package use_case.algorithm;

import entity.Outfit;

/**
 * Output data transfer object passed from {@link AlgorithmInteractor}
 * to {@link AlgorithmOutputBoundary} upon outfit generation.
 */

/**
 * TODO: SOFIAA
 */
public class AlgorithmOutputData {
    private final Outfit outfit;
    private final boolean success;
    private final String message;

    /**
     * Constructs an output data payload for the presenter.
     *
     * @param outfit  the generated {@link Outfit}, or {@code null} if none could be formed
     * @param success {@code true} if a valid outfit was produced
     * @param message status or informational message (such as fallback/style notes)
     */
    public AlgorithmOutputData(Outfit outfit, boolean success, String message) {
        this.outfit = outfit;
        this.success = success;
        this.message = message;
    }

    /**
     * Returns the generated outfit.
     *
     * @return the {@link Outfit} instance, or {@code null}
     */
    public Outfit getOutfit() {
        return outfit;
    }

    /**
     * Returns whether outfit generation succeeded.
     *
     * @return {@code true} if successful, {@code false} otherwise
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Returns any accompanying status or guidance message.
     *
     * @return the message string
     */
    public String getMessage() {
        return message;
    }
}
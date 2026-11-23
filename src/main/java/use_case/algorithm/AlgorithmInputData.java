package use_case.algorithm;

/**
 * Input data transfer object carrying user preferences and mode flags
 * from the controller into {@link AlgorithmInteractor}.
 */


/**
 * TODO: SOFIAA
 */
public class AlgorithmInputData {
    private final boolean isRandomMode;
    private final String vibe;
    private final String topColor;
    private final String bottomColor;
    private final String occasion;
    private final String layeringPreference;

    /**
     * Constructs input data for generating an outfit.
     *
     * @param isRandomMode       {@code true} if generating a random outfit ignoring vibe/color preferences
     * @param vibe               selected style vibe (e.g., Streetwear, Vintage, Minimalist)
     * @param topColor           preferred color for the top
     * @param bottomColor        preferred color for the bottom
     * @param occasion           target occasion for the outfit
     * @param layeringPreference layering preference (e.g., "Yes", "No", "Either")
     */
    public AlgorithmInputData(boolean isRandomMode,
                              String vibe,
                              String topColor,
                              String bottomColor,
                              String occasion,
                              String layeringPreference) {
        this.isRandomMode = isRandomMode;
        this.vibe = vibe;
        this.topColor = topColor;
        this.bottomColor = bottomColor;
        this.occasion = occasion;
        this.layeringPreference = layeringPreference;
    }

    /**
     * Returns whether random outfit mode is enabled.
     *
     * @return {@code true} if random mode is active, {@code false} otherwise
     */
    public boolean isRandomMode() {
        return isRandomMode;
    }

    /**
     * Returns the selected style vibe.
     *
     * @return the vibe string
     */
    public String getVibe() {
        return vibe;
    }

    /**
     * Returns the requested color for the top item.
     *
     * @return the top color string
     */
    public String getTopColor() {
        return topColor;
    }

    /**
     * Returns the requested color for the bottom item.
     *
     * @return the bottom color string
     */
    public String getBottomColor() {
        return bottomColor;
    }

    /**
     * Returns the requested occasion.
     *
     * @return the occasion string
     */
    public String getOccasion() {
        return occasion;
    }

    /**
     * Returns the user's layering preference.
     *
     * @return the layering preference string
     */
    public String getLayeringPreference() {
        return layeringPreference;
    }
}
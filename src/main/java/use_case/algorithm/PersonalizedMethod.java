package use_case.algorithm;

import entity.Outfit;
import java.util.List;

/**
 * {@link OutfitSelectionMethod} implementation that selects an outfit tailored
 * to the user's preferences from valid candidate outfits.
 */


public class PersonalizedMethod implements OutfitSelectionMethod{
    /**
     * Constructs a {@code PersonalizedMethod}.
     */
    public PersonalizedMethod() {
    }

    /**
     * Selects an outfit matching the user's preferences from the provided candidates.
     *
     * @param candidates eligible {@link Outfit} combinations
     * @param inputData  the {@link AlgorithmInputData} containing user style and layering preferences
     * @return a selected {@link Outfit}, or {@code null} if {@code candidates} is empty
     */
    @Override
    public Outfit selectOutfit(List<Outfit> candidates, AlgorithmInputData inputData) {
        return null;
    }
}

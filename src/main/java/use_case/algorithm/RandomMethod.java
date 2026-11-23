package use_case.algorithm;

import entity.Outfit;
import java.util.List;

/**
 * {@link OutfitSelectionMethod} implementation that selects an outfit randomly
 * from valid candidate outfits without prioritizing vibe or color preferences.
 */

public class RandomMethod implements OutfitSelectionMethod{
    /**
     * Constructs a {@code RandomMethod}.
     */
    public RandomMethod() {
    }

    /**
     * Randomly selects an outfit from the provided candidates.
     *
     * @param candidates eligible {@link Outfit} combinations
     * @param inputData  the {@link AlgorithmInputData} (vibe/color preferences are ignored)
     * @return a randomly chosen {@link Outfit}, or {@code null} if {@code candidates} is empty
     */
    @Override
    public Outfit selectOutfit(List<Outfit> candidates, AlgorithmInputData inputData) {
        return null;
    }
}

package use_case.algorithm;

import entity.Outfit;
import java.util.List;

/**
 * Strategy interface for selecting an {@link Outfit} from weather- and rule-filtered candidates.
 */

public interface OutfitSelectionMethod {
    /**
     * Selects a single outfit from the list of eligible candidate outfits.
     *
     * @param candidates eligible {@link Outfit} combinations
     * @param inputData  the {@link AlgorithmInputData} with user preferences and mode
     * @return the selected {@link Outfit}, or {@code null} if {@code candidates} is empty
     */
    Outfit selectOutfit(List<Outfit> candidates, AlgorithmInputData inputData);
}

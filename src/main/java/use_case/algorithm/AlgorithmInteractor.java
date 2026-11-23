package use_case.algorithm;

import entity.ClothingItem;
import entity.Outfit;
import entity.WeatherData;
import java.util.List;

/**
 * Interactor implementing the outfit recommendation use case using Clean Architecture
 * and the {@link OutfitStrategy} pattern.
 */

/**
 * TODO: SOFIAA
 */
public class AlgorithmInteractor implements AlgorithmInputBoundary {
    private final AlgorithmDataAccessInterface closetDataAccess;
    private final WeatherDataAccessInterface weatherDataAccess;
    private final AlgorithmOutputBoundary presenter;
    private final OutfitSelectionMethod randomMethod;
    private final OutfitSelectionMethod personalizedStrategy;

    /**
     * Constructs an {@code AlgorithmInteractor} with its required dependencies.
     *
     * @param closetDataAccess     data access gateway for closet items
     * @param weatherDataAccess    data access gateway for current weather
     * @param presenter            output boundary for presenting results or errors
     * @param randomMethod       strategy used in random mode
     * @param personalizedMethod strategy used in personalized mode
     */
    public AlgorithmInteractor(AlgorithmDataAccessInterface closetDataAccess,
                               WeatherDataAccessInterface weatherDataAccess,
                               AlgorithmOutputBoundary presenter,
                               OutfitSelectionMethod randomMethod,
                               OutfitSelectionMethod personalizedMethod) {
        this.closetDataAccess = closetDataAccess;
        this.weatherDataAccess = weatherDataAccess;
        this.presenter = presenter;
        this.randomMethod = randomMethod;
        this.personalizedStrategy = personalizedMethod;
    }

    /**
     * Orchestrates weather lookup, closet filtering, candidate outfit building,
     * strategy selection, and presenter notification.
     *
     * @param inputData the {@link AlgorithmInputData} driving outfit generation
     */
    @Override
    public void execute(AlgorithmInputData inputData) {
    }

    /**
     * Filters closet items according to the current weather and user preferences.
     *
     * @param items     all items from the closet
     * @param weather   current {@link WeatherData}
     * @param inputData user preference input data
     * @return filtered list of eligible {@link ClothingItem} objects
     */
    private List<ClothingItem> filterItems(List<ClothingItem> items,
                                           WeatherData weather,
                                           AlgorithmInputData inputData) {
        return List.of();
    }

    /**
     * Builds valid candidate outfits (top + bottom + layering/opacity rules)
     * that satisfy warmth requirements.
     *
     * @param eligibleItems filtered closet items
     * @param weather       current {@link WeatherData}
     * @param inputData     user preference input data
     * @return list of valid candidate {@link Outfit} objects
     */
    private List<Outfit> buildCandidateOutfits(List<ClothingItem> eligibleItems,
                                               WeatherData weather,
                                               AlgorithmInputData inputData) {
        return List.of();
    }
}
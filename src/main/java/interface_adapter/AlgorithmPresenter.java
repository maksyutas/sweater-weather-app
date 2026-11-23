package interface_adapter;

import use_case.algorithm.AlgorithmOutputBoundary;
import use_case.algorithm.AlgorithmOutputData;

/**
 * Presenter translating {@link AlgorithmOutputData} or error messages
 * into updates for {@link OutfitViewModel}.
 */

public class AlgorithmPresenter implements AlgorithmOutputBoundary{
    private final OutfitViewModel viewModel;

    /**
     * Constructs an {@code AlgorithmPresenter} bound to an {@link OutfitViewModel}.
     *
     * @param viewModel the view model updated for the outfit view
     */
    public AlgorithmPresenter(OutfitViewModel viewModel) {
        this.viewModel = viewModel;
    }

    /**
     * Updates {@link OutfitViewModel} with the newly generated outfit.
     *
     * @param outputData the {@link AlgorithmOutputData} produced by the interactor
     */
    @Override
    public void prepareSuccessView(AlgorithmOutputData outputData) {
    }

    /**
     * Updates {@link OutfitViewModel} with an error or "can't style you" message.
     *
     * @param errorMessage message to display to the user
     */
    @Override
    public void prepareFailView(String errorMessage) {
    }
}

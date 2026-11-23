package use_case.algorithm;

import entity.ClothingItem;
import java.util.List;

/**
 * Data access interface for retrieving clothing items from the closet.
 */

/**
 * TODO: SOFIAA
 */
public interface AlgorithmDataAccessInterface {
    /**
     * Retrieves all clothing items currently available in the user's closet.
     *
     * @return a list of {@link ClothingItem} objects in the closet
     */
    List<ClothingItem> getClosetItems();

    }

package view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 * The Swing screen for letting the user pick their top 2-3 style vibes.
 * Checkboxes for each style the user actually owns (Streetwear, Vintage...)
 * and a Save button. Shown on first launch and from settings.
 * Only shows things and passes clicks to the Controller; no logic here.
 *TODO: for sofiia
 */
public class AlgorithmView extends JPanel{

    private final JButton saveButton;

    /**
     * Constructs an {@code AlgorithmView} with initial UI components.
     */
    public AlgorithmView() {
        this.saveButton = new JButton("Save");
    }

    /**
     * Updates the displayed style checkboxes based on the styles available in the closet.
     *
     * @param availableStyles list of style names present in the user's closet
     */
    public void setAvailableStyles(Iterable<String> availableStyles) {
    }

    /**
     * Returns the Save button so a controller or listener can be attached.
     *
     * @return the {@link JButton} used to save selected style vibes
     */
    public JButton getSaveButton() {
        return saveButton;
    }

    /**
     * Creates a checkbox for a single style option.
     *
     * @param styleName the name of the style vibe (e.g., "Streetwear", "Vintage")
     * @return a configured {@link JCheckBox} for that style
     */
    protected JCheckBox createStyleCheckBox(String styleName) {
        return new JCheckBox(styleName);
    }
}

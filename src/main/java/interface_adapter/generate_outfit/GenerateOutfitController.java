package interface_adapter.generate_outfit;

import java.util.ArrayList;
import java.util.List;

public class GenerateOutfitController {
    public List<String> availableTops = new ArrayList<>();
    public List<String> availableBottoms = new ArrayList<>();
    public List<String> availableStyles = new ArrayList<>();

    public void execute(String top, String bottom, String style, String layered) {
    }

    public void addTopColor(String top) {
        if (!availableTops.contains(top)) {
            availableTops.add(top);
        }
    }
    public void addBottomColor( String bottom) {
        if (!availableBottoms.contains(bottom)) {
            availableBottoms.add(bottom);
        }
    }
    public void addStyle(String style) {
        if (!availableStyles.contains(style)) {
            availableStyles.add(style);
        }
    }

}

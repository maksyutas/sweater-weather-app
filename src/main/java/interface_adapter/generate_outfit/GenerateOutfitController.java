package interface_adapter.generate_outfit;

public class GenerateOutfitController {
    public String top;
    public String bottom;
    public String style;
    public String layered;

    public void setOutfitPreference(String top, String bottom, String style, String layered) {
        this.top = top;
        this.bottom = bottom;
        this.style = style;
        this.layered = layered;
    }
}

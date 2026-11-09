package view;

import java.util.Scanner;
/**
 * The Swing screen for checking the weather and picking a valid outfit (random or personalized).
 * The main dashboard: city box, weather display, Personalized / Random buttons,
 * and the outfit pictures. Also holds the Save and Regenerate buttons (Issue #4).
 * Only shows things and passes clicks to the Controller; no logic here.
 *TODO: for zahraa
 */
public class GenerateOutfitView {
    public String getCity() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your postal code (no space!): ");
        String zipCode = scanner.nextLine();

        System.out.print("Enter your country code (2 uppercase letters!): ");
        String countryCode = scanner.nextLine();
        return zipCode + "," + countryCode;
    }
}

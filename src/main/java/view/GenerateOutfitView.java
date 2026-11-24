package view;

import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;

/**
 * The Swing screen for checking the weather and picking a valid outfit (random or personalized).
 * The main dashboard: city box, weather display, Personalized / Random buttons,
 * and the outfit pictures. Also holds the Save and Regenerate buttons (Issue #4).
 * Only shows things and passes clicks to the Controller; no logic here.
 *TODO: for zahraa
 */
public class GenerateOutfitView {

    public void GeneratePage() {
        JPanel colorPanel = new JPanel();
        colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.Y_AXIS));

        JLabel colorLabel = new JLabel("Which color are you feeling today?");
        JPanel colorRow = new JPanel();
        String[] topList = {"Choose top!", "red", "yellow", "blue"};
        String [] bottomList = {"Choose bottom!", "denim", "black", "brown"};
        JComboBox<String> topDropdown = new JComboBox<>(topList);
        JComboBox<String> bottomDropdown = new JComboBox<>(bottomList);
        colorRow.add(topDropdown);
        colorRow.add(bottomDropdown);

        colorLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        colorRow.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        colorPanel.add(Box.createVerticalStrut(100));
        colorPanel.add(colorLabel);
        colorPanel.add(Box.createVerticalStrut(10));
        colorPanel.add(colorRow);

        JPanel stylePanel = new JPanel();
        stylePanel.setLayout(new BoxLayout(stylePanel, BoxLayout.Y_AXIS));

        JLabel styleLabel = new JLabel("Which style do you prefer to wear today?");
        String[] styleList = {"Choose!", "Grunge", "Coquette", "Streetwear"};
        JComboBox<String> styleDropdown = new JComboBox<>(styleList);

        styleLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        styleDropdown.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        java.awt.Dimension dropdownSize = new java.awt.Dimension(294, 30);
        styleDropdown.setPreferredSize(dropdownSize);
        styleDropdown.setMaximumSize(dropdownSize);

        stylePanel.add(Box.createVerticalStrut(20));
        stylePanel.add(styleLabel);
        stylePanel.add(Box.createVerticalStrut(10));
        stylePanel.add(styleDropdown);


        JPanel layeredPanel = new JPanel();
        layeredPanel.setLayout(new BoxLayout(layeredPanel, BoxLayout.Y_AXIS));
        JLabel layeredLabel = new JLabel("Do you want a layered outfit?");
        JPanel layeredRow =  new JPanel(new java.awt.FlowLayout(
                java.awt.FlowLayout.CENTER, -2, 5));
        JToggleButton yes = new JToggleButton("Yes");
        JToggleButton no = new JToggleButton("No");
        JToggleButton chooseForMe = new JToggleButton("Choose for me ;p");

        ButtonGroup group = new ButtonGroup();
        for (JToggleButton button : new JToggleButton[]{yes, no, chooseForMe}) {
            group.add(button);
            layeredRow.add(button);

            java.awt.Color defaultColor = button.getForeground();
            button.addItemListener(event -> {
                if (button.isSelected()) {
                    button.setForeground(Color.MAGENTA);
                } else {
                    button.setForeground(defaultColor);
                }
            });
        }

        layeredLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        layeredRow.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        layeredPanel.add(Box.createVerticalStrut(20));
        layeredPanel.add(layeredLabel);
        layeredPanel.add(Box.createVerticalStrut(10));
        layeredPanel.add(layeredRow);

        colorPanel.setMaximumSize(new java.awt.Dimension(
                Integer.MAX_VALUE, colorPanel.getPreferredSize().height));
        stylePanel.setMaximumSize(new java.awt.Dimension(
                Integer.MAX_VALUE, stylePanel.getPreferredSize().height));
        layeredPanel.setMaximumSize(new java.awt.Dimension(
                Integer.MAX_VALUE, layeredPanel.getPreferredSize().height));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(colorPanel);
        mainPanel.add(stylePanel);
        mainPanel.add(layeredPanel);

        JFrame frame = new JFrame("Outfit Questionnaire Page");
        frame.setMinimumSize(new java.awt.Dimension(457, 813));
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        GenerateOutfitView tryThis = new GenerateOutfitView();
        tryThis.GeneratePage();

    }
}
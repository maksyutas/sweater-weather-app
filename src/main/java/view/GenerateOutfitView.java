package view;

import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.util.Objects;
import interface_adapter.generate_outfit.GenerateOutfitController;

/**
 * The Swing screen for checking the weather and picking a valid outfit (random or personalized).
 * The main dashboard: city box, weather display, Personalized / Random buttons,
 * and the outfit pictures. Also holds the Save and Regenerate buttons (Issue #4).
 * Only shows things and passes clicks to the Controller; no logic here.
 *TODO: for zahraa
 */
public class GenerateOutfitView {

    private GenerateOutfitController controller;
    public void setController(GenerateOutfitController controller) {
        this.controller = controller;
    }

    public void GeneratePage() {
        Color lightPink = new Color(255, 228, 239);
        Color darkPink = new Color(163, 52, 100);
        Color darkGreen = new Color(184, 219, 128);
        Color lightGreen = new Color(247, 246, 211);
        Color darkestGreen = new Color(69, 82, 35);

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
        colorRow.setBackground(lightGreen);
        colorLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        colorRow.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        colorPanel.add(colorLabel);
        colorPanel.add(Box.createVerticalStrut(10));
        colorPanel.add(colorRow);
        colorPanel.setBackground(lightGreen);

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
        stylePanel.setBackground(lightGreen);

        JPanel layeredPanel = new JPanel();
        layeredPanel.setLayout(new BoxLayout(layeredPanel, BoxLayout.Y_AXIS));
        JLabel layeredLabel = new JLabel("Do you want a layered outfit?");
        JPanel layeredRow =  new JPanel(new java.awt.FlowLayout(
                java.awt.FlowLayout.CENTER, -3, 5));
        JToggleButton yes = new JToggleButton("Yes");
        JToggleButton no = new JToggleButton("No");
        JToggleButton chooseForMe = new JToggleButton("Choose for me ;p");
        layeredRow.setBackground(lightGreen);
        ButtonGroup group = new ButtonGroup();
        for (JToggleButton button : new JToggleButton[]{yes, no, chooseForMe}) {
            group.add(button);
            layeredRow.add(button);

            java.awt.Color defaultColor = button.getForeground();
            button.addItemListener(event -> {
                if (button.isSelected()) {
                    button.setForeground(darkestGreen);
                } else {
                    button.setForeground(darkPink);
                }
            });
        }
        layeredLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        layeredRow.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        layeredPanel.add(Box.createVerticalStrut(20));
        layeredPanel.add(layeredLabel);
        layeredPanel.add(Box.createVerticalStrut(10));
        layeredPanel.add(layeredRow);
        layeredPanel.setBackground(lightGreen);

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new BoxLayout(submitPanel, BoxLayout.Y_AXIS));
        JButton submitButton = new JButton("Work the magic !!!");
        submitButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        java.awt.Dimension submitSize = new java.awt.Dimension(294, 30);
        submitButton.setPreferredSize(submitSize);
        submitButton.setMaximumSize(submitSize);
        submitPanel.add(Box.createVerticalStrut(90));
        submitPanel.add(submitButton);
        submitPanel.setBackground(lightPink);

        JPanel directoryPanel = new JPanel();
        directoryPanel.setLayout(new BoxLayout(directoryPanel ,BoxLayout.X_AXIS));
        JButton homeButton = new JButton("Home Page");
        JButton closetButton = new JButton("Go to My Closet");
        Dimension buttonSize = new Dimension(140, 30);
        homeButton.setPreferredSize(buttonSize);
        homeButton.setMaximumSize(buttonSize);
        closetButton.setPreferredSize(buttonSize);
        closetButton.setMaximumSize(buttonSize);
        homeButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        closetButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        directoryPanel.add(Box.createVerticalStrut(455));
        directoryPanel.add(Box.createHorizontalGlue());
        directoryPanel.add(homeButton);
        directoryPanel.add(Box.createRigidArea(new Dimension(145, 0)));
        directoryPanel.add(closetButton);
        directoryPanel.add(Box.createHorizontalGlue());

        homeButton.setForeground(darkestGreen);
        closetButton.setForeground(darkestGreen);
        submitButton.setForeground(darkPink);
        submitButton.setForeground(darkPink);
        topDropdown.setForeground(darkPink);
        bottomDropdown.setForeground(darkPink);
        yes.setForeground(darkPink);
        no.setForeground(darkPink);
        chooseForMe.setForeground(darkPink);
        styleDropdown.setForeground(darkPink);
        colorLabel.setForeground(darkestGreen);
        styleLabel.setForeground(darkestGreen);
        layeredLabel.setForeground(darkestGreen);
        directoryPanel.setBackground(lightPink);

        JLabel errorLabel = new JLabel("You missed a button! Please select all options!");
        errorLabel.setForeground(Color.red);
        errorLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        errorLabel.setVisible(false);

        submitButton.addActionListener( e  -> {
            errorLabel.setVisible(topDropdown.getSelectedIndex() == 0 || bottomDropdown.getSelectedIndex() == 0
                    || styleDropdown.getSelectedIndex() == 0 || (!yes.isSelected() && !no.isSelected()
                    && !chooseForMe.isSelected()));

            if (!errorLabel.isVisible()) {
                String top = Objects.requireNonNull(topDropdown.getSelectedItem()).toString();
                String bottom = Objects.requireNonNull(bottomDropdown.getSelectedItem()).toString();
                String style = Objects.requireNonNull(styleDropdown.getSelectedItem()).toString();
                String layered;
                if (yes.isSelected()) {
                    layered = "yes";
                } else if (no.isSelected()) {
                    layered = "no";
                } else {
                    layered = "either";
                }
                controller.setOutfitPreference(top, bottom, style, layered);
            }
        });

        JPanel questionnairePanel = new JPanel();
        questionnairePanel.setLayout(new BoxLayout(questionnairePanel, BoxLayout.Y_AXIS));
        Dimension questionnaireSize = new Dimension(400, 400);
        questionnairePanel.setPreferredSize(questionnaireSize);
        questionnairePanel.setMaximumSize(questionnaireSize);
        questionnairePanel.add(Box.createVerticalStrut(20));
        questionnairePanel.add(colorPanel);
        questionnairePanel.add(stylePanel);
        questionnairePanel.add(layeredPanel);
        questionnairePanel.add(errorLabel);
        questionnairePanel.add(Box.createVerticalStrut(10));
        questionnairePanel.setBackground(lightGreen);
        questionnairePanel.setBorder(BorderFactory.createLineBorder(darkGreen, 4, true));

        colorPanel.setMaximumSize(new java.awt.Dimension(
                Integer.MAX_VALUE, colorPanel.getPreferredSize().height));
        stylePanel.setMaximumSize(new java.awt.Dimension(
                Integer.MAX_VALUE, stylePanel.getPreferredSize().height));
        layeredPanel.setMaximumSize(new java.awt.Dimension(
                Integer.MAX_VALUE, layeredPanel.getPreferredSize().height));
        submitPanel.setMaximumSize(new java.awt.Dimension(
                Integer.MAX_VALUE, submitPanel.getPreferredSize().height));
        directoryPanel.setMaximumSize(new java.awt.Dimension(
                Integer.MAX_VALUE, directoryPanel.getPreferredSize().height));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(Box.createVerticalStrut(140));
        mainPanel.add(questionnairePanel);
        mainPanel.add(submitPanel);
        mainPanel.add(directoryPanel);
        mainPanel.setBackground(lightPink);

        JFrame frame = new JFrame("Sweater Weather");
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
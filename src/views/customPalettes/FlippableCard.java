package views.customPalettes;

import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class FlippableCard extends ContainerPanel {
    private final Label frontLabel;
    private final ImageContainer backLabel;

    private boolean isFlipped;
    private boolean isSelected;


    public FlippableCard(Color color, String word, String backImage) {
        super(color, new Dimension(150, 100));
        setLayout(new CardLayout());


        Label wordLabel = new Label(word.toUpperCase(), Font.BOLD, 16, Color.WHITE);
        add(wordLabel);
        frontLabel = wordLabel;
        add(frontLabel, "Front");

        backLabel = new ImageContainer(backImage, new Dimension(150, 100), CustomColor.FRAME.getColor());
        add(backLabel, "Back");

        showFront();

    }

    // Method to flip the card
    public void flip() {
        if (isFlipped) {
            showFront();
        } else {
            showBack();
        }
        isFlipped = !isFlipped;
    }

    // Method to show the front side of the card
    private void showFront() {
        CardLayout layout = (CardLayout) getLayout();
        layout.show(this, "Front");
    }

    // Method to show the back side of the card
    private void showBack() {
        CardLayout layout = (CardLayout) getLayout();
        layout.show(this, "Back");
    }


    // Method to set the selected state of the card
    public void setSelected(boolean selected) {
        isSelected = selected;
        // Update the appearance of the card based on its selected state
        if (isSelected) {
            setBorder(BorderFactory.createLineBorder(Color.WHITE.darker(), 1)); // Custom border for selected state
        } else {
            setBorder(null); // Remove the border when deselected
        }
    }

    // Method to check if the card is selected
    public boolean isSelected() {
        return isSelected;
    }

}

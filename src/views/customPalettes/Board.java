package views.customPalettes;

import models.Card;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.List;


public class Board extends JPanel {

    private boolean isOperativeBoard;


    public Board(List<Card> cards, Boolean isOperativeBoard) {
        this.isOperativeBoard = isOperativeBoard;
        setLayout(new GridBagLayout());
        setBackground(CustomColor.FRAME_GREEN.getColor());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        for (int index = 0; index < cards.size(); index++) {
            Card card = cards.get(index);
            FlippableCard flippableCard = new FlippableCard(getCardColor(card.getColor()), card.getWord(), getImagePathForCard(card, index));
            gridBagConstraints.gridx = index % 5;
            gridBagConstraints.gridy = index / 5;
            add(flippableCard, gridBagConstraints);


            if (isOperativeBoard) {
                // Add mouse listener to flip the card only for the operative board
                flippableCard.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        super.mouseClicked(e);
                        flippableCard.flip();
                    }
                });
            } else {
                // Add mouse listener to select the card only for the spymaster board
                flippableCard.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        super.mouseClicked(e);
                        flippableCard.setSelected(!flippableCard.isSelected());
                    }
                });
            }

        }

    }

    public void setBackgroundColor(Color color) {
        setBackground(color);
    }

    private Color getCardColor(models.enums.Color color) {
        return switch (color) {
            case RED -> CustomColor.CARD_RED.getColor();
            case BLUE -> CustomColor.CARD_BLUE.getColor();
            case NEUTRAL -> CustomColor.CARD_NEUTRAL.getColor();
            case ASSASSIN -> CustomColor.CARD_ASSASSIN.getColor();
        };
    }

    private String getImagePathForCard(Card card, int index) {
        models.enums.Color color = card.getColor();

        return switch (color) {
            case RED -> "src/assets/" + ((index % 2 == 0) ? "operative-red.png" : "spymaster-red.png");
            case BLUE -> "src/assets/" + ((index % 2 == 0) ? "operative-blue.png" : "spymaster-blue.png");
            case NEUTRAL -> "src/assets/neutral" + (index % 7 + 1) + ".png"; // Use index for consistency
            case ASSASSIN -> "src/assets/assassin.png";
        };
    }

    public void setCardColor(Color color) {
        for (Component component : getComponents()) {
            if (component instanceof FlippableCard) {
                ((FlippableCard) component).setBackgroundColor(color);
            }
        }
    }

}

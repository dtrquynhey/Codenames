package views.customPalettes;

import views.customPalettes.enums.CustomColor;

import javax.swing.*;

public class ScrollPane extends JScrollPane {

    public ScrollPane(Table table) {
        super(table);
        //getViewport().setSize(table.getSize());
        getViewport().setBackground(CustomColor.FRAME.getColor()); // Set background color of the viewport
        setBorder(BorderFactory.createLineBorder(CustomColor.FRAME.getColor())); // Set border color
    }

}

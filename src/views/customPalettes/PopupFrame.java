package views.customPalettes;

import views.gui.MainFrame;

import javax.swing.*;

public class PopupFrame extends MainFrame {
    public PopupFrame() {
        super();
        setSize(768, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose on close to avoid closing the main frame
        setVisible(true);
    }
}

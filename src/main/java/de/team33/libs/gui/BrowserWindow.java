package de.team33.libs.gui;

import javax.swing.*;
import java.awt.*;

public class BrowserWindow {

    private final JFrame jFrame = new JFrame("Title");

    public final void open() {
        final Dimension dim = new Dimension(640, 480);
        jFrame.setSize(dim);
        jFrame.setLocationByPlatform(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}

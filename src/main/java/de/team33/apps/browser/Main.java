package de.team33.apps.browser;

import de.team33.libs.gui.BrowserWindow;
import de.team33.libs.gui.FrameManager;

import javax.swing.*;

public class Main implements Runnable {

    private final Args args;
    private final FrameManager frames;

    private Main(final Args args) {
        this.args = args;
        this.frames = new FrameManager();
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Main(new Args(args)));
    }

    @Override
    public final void run() {
        JOptionPane.showMessageDialog(null, "Diese Anwendung erwartet den Pfad/Dateinamen einer MIDI-Datei als Parameter.", "Keine Datei angegeben", JOptionPane.ERROR_MESSAGE);
        new BrowserWindow().open();
    }
}

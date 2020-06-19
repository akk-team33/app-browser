package de.team33.apps.browser;

import de.team33.apps.browser.ui.BrowserPane;
import de.team33.apps.browser.ui.Fxml;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(final String[] args) {
        launch(Main.class, args);
    }

    @Override
    public final void start(final Stage stage) throws IOException {
        stage.setTitle("Browser");
        stage.setScene(Fxml.load(BrowserPane.class));
        stage.show();
    }
}

package de.team33.apps.browser.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public final class Fxml {

    private Fxml() {
    }

    public static Scene load(final Class<?> controllerClass) throws IOException {
        return new Scene(FXMLLoader.load(controllerClass.getResource(controllerClass.getSimpleName() + ".fxml")));
    }
}

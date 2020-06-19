package de.team33.apps.browser.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class BrowserPane {

    @FXML private TextField cwdTextField;
    @FXML private TreeView<String> dirTreeView;
    @FXML private Label statusMonitor;

    @FXML
    private void initialize() throws IOException {
        statusMonitor.setText("initialize");
        readDirTree();
        statusMonitor.setText("ready");
    }

    private void readDirTree() {

        final List<Path> rootDirectories = getRootDirectories();
        final TreeItem<String> rootItem;
        if (1 == rootDirectories.size())
            rootItem = newTreeItem(rootDirectories.get(0), 3);
        else {
            rootItem = new TreeItem<>("Filesystem"/*, rootIcon*/);
            for (final Path path : rootDirectories) {
                if(null != path)
                rootItem.getChildren().add(newTreeItem(path, 3));
            }
        }
        dirTreeView.setRoot(rootItem);
    }

    private static TreeItem<String> newTreeItem(final Path path, final int depth) {
        final String value = Optional.ofNullable(path.getFileName())
                                     .map(Path::toString)
                                     .orElseGet(path::toString);
        final TreeItem<String> result = new TreeItem<>(value/*, dirIcon*/);
        if (0 < depth) {
            try {
                Files.list(path)
                     .filter(path1 -> Files.isDirectory(path1))
                     .forEach(path1 -> result.getChildren().add(newTreeItem(path1, depth - 1)));
            } catch (final IOException e) {
                result.getChildren().add(new TreeItem<>(e.toString() /*, exIcon*/));
            }
        }
        return result;
    }

    private static List<Path> getRootDirectories() {
        final List<Path> result = new LinkedList<>();
        FileSystems.getDefault().getRootDirectories()
                   .forEach(result::add);
        return result;
    }
}

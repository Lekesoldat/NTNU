package app;

import javafx.scene.Scene;

public class Screen<T> {
    private Scene scene;
    private ScreenController<T> controller;

    public Screen(Scene scene, ScreenController<T> controller) {
        this.scene = scene;
        this.controller = controller;
    }

    public Scene getScene() {
        return scene;
    }

    public ScreenController<T> getController() {
        return controller;
    }
}

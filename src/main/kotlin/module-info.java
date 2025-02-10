module su.duvanoff.shapes {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires kotlin.reflect;

    opens su.duvanoff.shapes to javafx.fxml;
    exports su.duvanoff.shapes;

    opens su.duvanoff.shapes.controller to javafx.fxml;
    exports su.duvanoff.shapes.controller;
}
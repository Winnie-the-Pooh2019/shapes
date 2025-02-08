module su.duvanoff.shapes {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.kordamp.bootstrapfx.core;

    opens su.duvanoff.shapes to javafx.fxml;
    exports su.duvanoff.shapes;
}
module guiapptest.guitest {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens guiapptest.guitest to javafx.fxml;
    exports guiapptest.guitest;
}
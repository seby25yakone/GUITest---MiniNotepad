package guiapptest.guitest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("scene1.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Scene1Controller controller = fxmlLoader.getController();
        stage.setTitle("Yakone's application");
        stage.setScene(scene);
        stage.show();

        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            // Adjust layout when scene width changes
            controller.adjustLayout(newVal.doubleValue(), scene.getHeight());
        });

        scene.heightProperty().addListener((obs, oldVal, newVal) -> {
            // Adjust layout when scene height changes
            controller.adjustLayout(scene.getWidth(), newVal.doubleValue());
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
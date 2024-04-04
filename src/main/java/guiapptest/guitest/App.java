package guiapptest.guitest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("scene1.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Scene1Controller controller = fxmlLoader.getController();
        stage.setTitle("My mini notepad");
        stage.setScene(scene);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("/notepadlogo.png")));
        stage.show();

        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            controller.adjustLayout(newVal.doubleValue(), scene.getHeight());
        });

        scene.heightProperty().addListener((obs, oldVal, newVal) -> {
            controller.adjustLayout(scene.getWidth(), newVal.doubleValue());
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
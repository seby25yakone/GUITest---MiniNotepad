package guiapptest.guitest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Scene1Controller {
    @FXML
    private TextArea textArea;

    @FXML
    public void fileWrite() {
        // Create a FileChooser
        FileChooser fileChooser = new FileChooser();

        // Set initial directory (optional)
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        // Set extension filter (optional)
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save dialog
        File file = fileChooser.showSaveDialog(textArea.getScene().getWindow());

        // Proceed if a file is selected
        if (file != null) {
            try {
                BufferedWriter bf = new BufferedWriter(new FileWriter(file));
                bf.write(textArea.getText());
                bf.flush();
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
package ranks.javafxmidtermpaperpractice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class PracticingFileChooser extends Application {
    @Override
    public void start(Stage stage) {

        // UI Components
        TextArea textArea = new TextArea();
        Button openBtn = new Button("Open File");
        Button saveBtn = new Button("Save File");

        // OPEN FILE
        openBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");

            File file = fileChooser.showOpenDialog(stage);

            if (file != null) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

                    textArea.clear(); // clear old content
                    String line;

                    while ((line = reader.readLine()) != null) {
                        textArea.appendText(line + "\n");
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // SAVE FILE
        saveBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save File");

            File file = fileChooser.showSaveDialog(stage);

            if (file != null) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

                    writer.write(textArea.getText());

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Layout
        VBox root = new VBox(10, openBtn, saveBtn, textArea);

        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Simple Notepad");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

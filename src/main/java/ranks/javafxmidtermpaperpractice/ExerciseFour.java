package ranks.javafxmidtermpaperpractice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;

public class ExerciseFour {

    @FXML
    private Button btnRead;

    @FXML
    private Button btnWrite;

    @FXML
    private Label lblDisplay;

    @FXML
    private Label lblFeedback;

    @FXML
    private TextField txtMessage;

    @FXML
    void handleRead(ActionEvent event) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("users.txt"));
            String line;
            lblFeedback.setText("Loaded");
            while((line = br.readLine()) != null){
                lblDisplay.setText(line);
            }
        }catch(IOException i){
            i.printStackTrace();
        }
    }

    @FXML
    void handleWrite(ActionEvent event) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt",true));
            bw.write(txtMessage.getText()+"\n");
            lblFeedback.setText("Written");
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

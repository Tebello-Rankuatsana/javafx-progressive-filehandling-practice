package ranks.javafxmidtermpaperpractice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;

public class ExerciseThree {

    @FXML
    private Button btnLoad;

    @FXML
    private Button btnWrite;

    @FXML
    private Label lblDisplay;

    @FXML
    private Label lblFeedback;

    @FXML
    private TextField txtMessage;

    @FXML
    void handleLoad(ActionEvent event) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("message.txt"));
            String line;
            while((line = br.readLine()) != null){
                lblDisplay.setText(line);
            }
        }catch (IOException i){
            lblFeedback.setText(i.getMessage());
        }
    }

//    writing into a file
    @FXML
    void handleWrite(ActionEvent event) {
        String message = txtMessage.getText();
        if(message.isEmpty()){
            lblFeedback.setText("Enter a message you imbecile!!!");
        }
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("message.txt",true));
            bw.write(txtMessage.getText()+"\n");
            bw.close();
        }catch(IOException e){
            lblFeedback.setText(e.getMessage());
        }
    }

}

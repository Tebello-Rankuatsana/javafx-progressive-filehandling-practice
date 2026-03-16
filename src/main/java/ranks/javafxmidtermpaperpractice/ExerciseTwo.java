package ranks.javafxmidtermpaperpractice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;

public class ExerciseTwo {

    @FXML
    private Button btnWrite;

    @FXML
    private TextField txtMesaage;

    @FXML
    void handleWrite(ActionEvent event) {
        try{
            FileWriter fw = new FileWriter("exerciseTwo.txt",true);
            String line;
            fw.write(txtMesaage.getText()+"\n");
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}

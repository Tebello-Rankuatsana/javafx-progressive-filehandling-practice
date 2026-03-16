package ranks.javafxmidtermpaperpractice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class exerciseOneRegistrationAppController {

    @FXML
    private Button btnRead;

    @FXML
    private Button btnWrite;

    @FXML
    private ComboBox<String> cmbStudents;

    @FXML
    private Label lblStudent;

    @FXML
    private TextField txtStudent;

    @FXML
    void handleRead(ActionEvent event) {
        try{
            FileReader f =  new FileReader("studentNames.txt");
            BufferedReader br = new BufferedReader(f);
            String line;
            while((line = br.readLine()) != null){
                cmbStudents.getItems().add(line);
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void handleWrite(ActionEvent event) {
        try{
            String student = cmbStudents.getValue();
            if(student == null){
                txtStudent.setText("Please select a student first");
                return;
            }
            FileWriter fw = new FileWriter("DoesNotOwe.txt");
            fw.write(student+ " does not owe the institution");
            fw.close();
            txtStudent.setText(student+" written successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

package ranks.javafxmidtermpaperpractice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.io.*;

public class PeopleDetails {

    @FXML
    private Button btnLoad;

    @FXML
    private Button btnSave;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton rdFemale;

    @FXML
    private RadioButton rdMale;

    @FXML
    private TextArea txtDisplay;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSurname;

    @FXML
    void handleLoad(ActionEvent event) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("user_details.txt"));
            String line;
            while((line = br.readLine()) != null){
                txtDisplay.appendText(line+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleSave(ActionEvent event) {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("user_details.txt",true));
//            bw.write("______________________________"+"\n");
            bw.write("Name: "+txtName.getText()+"\n");
            bw.write("Surname: "+txtSurname.getText()+"\n");
            if(rdMale.isSelected())
                bw.write("Gender: Male");
            if(rdFemale.isSelected())
                bw.write("Gender: Female");
            bw.write("______________________________"+"\n");
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}

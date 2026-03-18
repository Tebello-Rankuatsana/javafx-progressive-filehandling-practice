package ranks.javafxmidtermpaperpractice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.io.*;

public class RememberingFileHandling {

    @FXML
    private ToggleGroup Gender;

    @FXML
    private Button btnLoad;

    @FXML
    private Button btnWrite;

    @FXML
    private RadioButton rbFemale;

    @FXML
    private RadioButton rbMale;

    @FXML
    private TextArea txtDisplay;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSurname;

    @FXML
    void handleLoad(ActionEvent event) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("remembering.txt"));
            String line;
            txtDisplay.clear();// making it so that it doesn't repeat stuff
            while((line = br.readLine()) != null){
                txtDisplay.appendText(line+"\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleWrite(ActionEvent event) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("remembering.txt",true));
            bw.write("Name: "+txtName.getText()+"\n");
            bw.write("Surname: "+txtSurname.getText()+"\n");
            if(rbMale.isSelected())
                bw.write("Gender: Male"+"\n");
            if(rbFemale.isSelected())
                bw.write("Gender: Female"+"\n");
            bw.write("____________________________"+"\n");
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

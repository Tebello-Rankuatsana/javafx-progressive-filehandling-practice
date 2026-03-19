package ranks.javafxmidtermpaperpractice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("remembering.txt"));
//            String line;
//            txtDisplay.clear();// making it so that it doesn't repeat stuff
//            while((line = br.readLine()) != null){
//                txtDisplay.appendText(line+"\n");
//            }
//            br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try{
            BufferedReader br = new BufferedReader(new FileReader("remembering_two.txt"));
            String line;
            txtDisplay.clear();
            while((line = br.readLine()) != null)
                txtDisplay.appendText(line + "\n");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void handleWrite(ActionEvent event) {
//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter("remembering.txt",true));
//            bw.write("Name: "+txtName.getText()+"\n");
//            bw.write("Surname: "+txtSurname.getText()+"\n");
//            if(rbMale.isSelected())
//                bw.write("Gender: Male"+"\n");
//            if(rbFemale.isSelected())
//                bw.write("Gender: Female"+"\n");
//            bw.write("____________________________"+"\n");
//            bw.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("remembering_two.txt",true));
            bw.write("Name: "+txtName.getText()+"\n");
            bw.write("Surname: "+txtSurname.getText()+"\n");
            if(rbMale.isSelected())
                bw.write("Gender: Male"+"\n");
            if(rbFemale.isSelected())
                bw.write("Gender: Female"+"\n");

            bw.write("_______________________"+"\n");

            if(txtSurname.getText().isEmpty() || txtName.getText().isEmpty()){
                Alert warning = new Alert(Alert.AlertType.ERROR);
                warning.setTitle("Fill in Credentials");
                warning.setContentText("Fill in proper information");
                warning.showAndWait();
            }else {
//            adding an alert(cause I'm HIM)
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("File Operation");
                alert.setHeaderText(null);
                alert.setContentText("Information was written successfully!!!");
                alert.showAndWait();
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

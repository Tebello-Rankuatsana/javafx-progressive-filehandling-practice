package ranks.javafxmidtermpaperpractice;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;

public class ExerciseFive {

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnView;

    @FXML
    private ComboBox<String> cmbCourses;

    @FXML
    private Label lblStudent;

    @FXML
    private Label lblStudentNumber;

    @FXML
    private TextArea txtDisplay;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNumber;

    @FXML
    void initialize(){
        ObservableList<String> courses = FXCollections.observableArrayList(
                "BSCSM",
                "BSCBIT",
                "BSCIT"
        );
        cmbCourses.setItems(courses);
    }

    @FXML
    void handleDisplay(ActionEvent event) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));
            String line;
            txtDisplay.clear();
            while((line = br.readLine()) != null){
//                we used appendText because setText replaces the existing text every time
                txtDisplay.appendText(line+"\n");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void handleRegister(ActionEvent event) {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt",true));
            bw.write("Name: "+txtName.getText()+"\n");
            bw.write("Student Number: "+txtNumber.getText()+"\n");
            bw.close();
        }catch(IOException i){
            i.printStackTrace();
        }
    }

}

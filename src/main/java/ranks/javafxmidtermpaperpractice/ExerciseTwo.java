package ranks.javafxmidtermpaperpractice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.*;
import java.nio.Buffer;

public class ExerciseTwo {

    @FXML
    private Button btnWrite;

    @FXML
    private TextField txtMesaage;

    @FXML
    private Button btnRead;

    @FXML
    void initialize(){
        btnRead.setOnAction(e ->{
            try{
                FileReader f = new FileReader("exerciseTwo.txt");
                BufferedReader br = new BufferedReader(f);
                String line;
                while((line = br.readLine()) != null){
                    txtMesaage.getText();
                }
                br.close();
            }catch(IOException ie){
                ie.printStackTrace();
            }
        });
    }
    @FXML
    void handleWrite(ActionEvent event) {
        try{
            FileWriter fw = new FileWriter("exerciseTwo.txt",true);
            fw.write(txtMesaage.getText()+"\n");
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
//    functionality for reading and display information from the .txt file
    @FXML
    void handleRead(ActionEvent event) {
        try{
            FileReader f = new FileReader("exerciseTwo.txt");
            BufferedReader br = new BufferedReader(f);
            String line;
            while((line = br.readLine()) != null){
                txtMesaage.getText();
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}

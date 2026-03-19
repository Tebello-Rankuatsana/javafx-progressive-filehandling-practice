package ranks.javafxmidtermpaperpractice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class LoginPage {

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblPassword;

    @FXML
    private PasswordField psdPass;

    @FXML
    private TextField txtEmail;

//    valid credentials from the notepad
    @FXML
    void handleLogin(ActionEvent event) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("login-credentials.txt"));
            String line;

            String inputEmail = txtEmail.getText();
            String inputPass = psdPass.getText();

            boolean isValid = false;
            
            while ((line = br.readLine()) != null){
//                String[] parts = line.split(",");
//
//                String fileUsername = parts[0];
//                String filePassword = parts[1];
//
//                if (inputUsername.equals(fileUsername) && inputPassword.equals(filePassword)) {
//                    Alert correct = new Alert(Alert.AlertType.INFORMATION);
//                    correct.setTitle("Successful");
//                    correct.setContentText("Success!!!");
//                    correct.showAndWait();
//                    break;
//                }
//                else {
//                    Alert wrong = new Alert(Alert.AlertType.ERROR);
//                    wrong.setTitle("Wrong Credentials");
//                    wrong.setHeaderText("Incorrect Credentials");
//                    wrong.setContentText("Invalid Email or Password");
//                    wrong.showAndWait();
//                }
                String[] pass = line.split(",");
                String fileEmail = pass[0];
                String filePass = pass[1];

                if(inputEmail.equals(fileEmail) && inputPass.equals(filePass)) {
                    isValid = true;
                    break;
                }
            }
            if(isValid){
                Alert correct = new Alert(Alert.AlertType.INFORMATION);
                correct.setTitle("Success");
                correct.setContentText("Login was successful!!!");
                correct.showAndWait();

                Parent root = FXMLLoader.load(getClass().getResource("People.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    @FXML
    void handleRegister(ActionEvent event) {
//        Credentials will be written to a file
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("login-credentials.txt",true));
            bw.write(txtEmail.getText()+","+psdPass.getText()+"\n");
//            bw.write("Password: "+psdPass.getText()+"\n");
            if(txtEmail.getText().isEmpty()) {
                Alert warning = new Alert(Alert.AlertType.ERROR);
                warning.setTitle("Registration failed");
                warning.setContentText("Fill in credentials");
                warning.showAndWait();
            }
            else{
                Alert btnPressed = new Alert(Alert.AlertType.INFORMATION);
                btnPressed.setTitle("Account Created");
                btnPressed.setHeaderText("Account successfully created");
                btnPressed.setContentText("Data has been saved");
                btnPressed.showAndWait();
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

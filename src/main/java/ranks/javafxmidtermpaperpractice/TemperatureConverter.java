package ranks.javafxmidtermpaperpractice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class TemperatureConverter {

    @FXML
    private Button btnClear;

    @FXML
    private Button btnConvert;

    @FXML
    private Button btnExit;

    @FXML
    private RadioButton radioCentigrade;

    @FXML
    private RadioButton radioFarenheit;

    @FXML
    private ToggleGroup temp;

    @FXML
    private TextField txtTemp;

    @FXML
    void initialize(){
        btnExit.setOnAction(e -> {
            Stage stage = (Stage) txtTemp.getScene().getWindow();
            stage.close();
        });
        btnClear.setOnAction(e -> {
            txtTemp.setText("");
        });
    }

    @FXML
    void calcTemp(ActionEvent event) {

    }

}

package Manager;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class AddMasterController implements Initializable {
    public TextField txtMasterName;
    public TextField txtMasterLastName;
    public TextField txtMasterNationalCode;
    public TextField txtMasterFatherName;
    public TextField txtMasterPhoneNumber;
    public JFXComboBox comboMasterGender;
    public DatePicker masterDataPicker;
    public Button btnAddMaster;
    public Label lblAlert;





    public void addMaster(MouseEvent mouseEvent) {

    }


    public void initialize(URL location, ResourceBundle resources) {
        String[] gender = {"آقا","خانم"};
        comboMasterGender.getItems().addAll(gender);

    }




}

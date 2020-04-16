package Manager;

import Extra.Archive;
import Extra.Field;
import Extra.Master;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class
AddMasterController extends Archive implements Initializable {
    public TextField txtMasterName;
    public TextField txtMasterLastName;
    public TextField txtMasterNationalCode;
    public TextField txtMasterFatherName;
    public TextField txtMasterPhoneNumber;
    public JFXComboBox comboMasterGender;
    public DatePicker masterDataPicker;
    public Button btnAddMaster;
    public Label lblAlert;
    Master master;
    LocalDate date ;




    public void addMaster(MouseEvent mouseEvent) {
        master = new Master();
        master.setName(txtMasterName.getText());
        master.setLastName(txtMasterLastName.getText());
        master.setNationalNumber(Long.parseLong(txtMasterNationalCode.getText()));
        master.setIdCardNumber(Long.parseLong(txtMasterNationalCode.getText()));
        master.setFatherName(txtMasterFatherName.getText());
        master.setPhoneNumber(txtMasterPhoneNumber.getText());
        master.setGender(comboMasterGender.getSelectionModel().getSelectedItem().toString());
        date=masterDataPicker.getValue();
        master.setDateOfBirth(String.valueOf(date));
        ArrayList<Master> teacher = getMasters();
        teacher.add(master);
        setMasters(teacher);

}


    public void initialize(URL location, ResourceBundle resources) {
        String[] gender = {"آقا","خانم"};
        comboMasterGender.getItems().addAll(gender);

    }




}

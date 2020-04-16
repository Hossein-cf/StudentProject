package Manager;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddFieldController implements Initializable {

    public TextField txtFieldName;
    public TextField txtFieldUnit;
    public JFXComboBox comboFirstMeeting;
    public JFXComboBox ComboSecondMeeting;
    public JFXComboBox ComboFirstMeetingTime;
    public JFXComboBox ComboSecondMeetingTime;
    public DatePicker quizTime;
    public Button btnAddField;
    public Label lblAlert;
    public TextField txtFieldCode;











    public void initialize(URL location, ResourceBundle resources) {
        String[] days = {"شنبه","یکشنبه","دوشنبه","سه شنبه","چهارشنبه"};
        String[] times = {"8-10","10-12","14-16","16-18"};
        comboFirstMeeting.getItems().addAll(days);
        ComboSecondMeeting.getItems().addAll(days);
        ComboFirstMeetingTime.getItems().addAll(times);
        ComboSecondMeeting.getItems().addAll(times);


    }

}

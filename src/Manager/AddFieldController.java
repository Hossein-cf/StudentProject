package Manager;

import Extra.Archive;
import Extra.Field;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class AddFieldController extends Archive implements Initializable   {

    public  TextField txtFieldName;
    public  TextField txtFieldCode;
    public  TextField txtFieldUnit;
    public  JFXComboBox comboFirstMeeting;
    public  JFXComboBox ComboSecondMeeting;
    public  JFXComboBox ComboFirstMeetingTime;
    public  JFXComboBox ComboSecondMeetingTime;
    public  DatePicker quizTime;
    public Button btnAddField;
    public Label lblAlert;


    private static Field field;
    private static LocalDate date;






     public  void addField(){

        field = new Field();
        field.setFieldName(txtFieldName.getText());
        field.setUnit(Integer.parseInt(txtFieldUnit.getText()));
        field.setFieldNumber(txtFieldCode.getText());
        field.setFirstMeeting((String) comboFirstMeeting.getSelectionModel().getSelectedItem());
        field.setFirstMeeting(field.getFirstMeeting()+ComboFirstMeetingTime.getSelectionModel().getSelectedItem().toString());
        field.setSecondMeeting((String) ComboSecondMeeting.getSelectionModel().getSelectedItem());
        field.setSecondMeeting(field.getSecondMeeting()+ComboSecondMeetingTime.getSelectionModel().getSelectedItem().toString());
        date = quizTime.getValue();
        field.setExamStartTime(date.toString());
        ArrayList<Field> lesson = getFields();
        lesson.add(field);
        setFields(lesson);


    }


    public void initialize(URL location, ResourceBundle resources) {
        String[] days = {"شنبه","یکشنبه","دوشنبه","سه شنبه","چهارشنبه"};
        String[] times = {"8-10","10-12","14-16","16-18"};
        comboFirstMeeting.getItems().addAll(days);
        ComboSecondMeeting.getItems().addAll(days);
        ComboFirstMeetingTime.getItems().addAll(times);
        ComboSecondMeetingTime.getItems().addAll(times);


    }

}

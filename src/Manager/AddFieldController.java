package Manager;

import Extra.Archive;
import Extra.Field;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;


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

    private int findComboIndex(JFXComboBox Box) {
        return Box.getSelectionModel().getSelectedIndex();
    }


    public EventHandler<KeyEvent> numeric_Validation(final Integer max_Lengh) {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                TextField txt_TextField = (TextField) e.getSource();
                if (txt_TextField.getText().length() >= max_Lengh) {
                    e.consume();
                }
                if (e.getCharacter().matches("[0-9.]")) {
                    if (txt_TextField.getText().contains(".") && e.getCharacter().matches("[.]")) {
                        e.consume();
                    } else if (txt_TextField.getText().length() == 0 && e.getCharacter().matches("[.]")) {
                        e.consume();
                    }
                } else {
                    e.consume();
                }
            }
        };
    }

    public EventHandler<KeyEvent> letter_Validation(final Integer max_Lengh) {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                TextField txt_TextField = (TextField) e.getSource();
                if (txt_TextField.getText().length() >= max_Lengh) {
                    e.consume();
                }
                if (e.getCharacter().matches("[ا-ی-ن]") || e.getCharacter().matches(" ")) {
                } else {
                    e.consume();
                }
            }
        };
    }


    private void alert(String message, Label lbl, String color) {
        lbl.setText(message);
        lbl.setStyle("-fx-text-fill: " + color + ";");
    }


     public  void addField(){
        if(txtFieldCode.getText().equals("")||txtFieldName.getText().equals("")||txtFieldUnit.getText().equals("")||findComboIndex(ComboFirstMeetingTime)==-1||findComboIndex(comboFirstMeeting)==-1||findComboIndex(ComboSecondMeeting)==-1||findComboIndex(ComboSecondMeetingTime)==-1||quizTime.getValue()==null){

        alert("لطفا فیلد هارا تکمیل کنید!",lblAlert,"red");


        }

        else {
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

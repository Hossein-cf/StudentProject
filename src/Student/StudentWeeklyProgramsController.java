package Student;

import Extra.Archive;
import Extra.Field;
import LoginPage.LoginPageController;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentWeeklyProgramsController implements Initializable {
    public TableView<Person> StudentTableView;
    public TableColumn<Person, String> clmFieldName;
    public TableColumn<Person, String> clmFieldCode;
    public TableColumn<Person, String> clmFieldUnit;
    public TableColumn<Person, String> clmMasterName;
    public TableColumn<Person, String> clmStudentMeetingTime;

    private void setTable() {

        Archive archive = new Archive();
        ObservableList<Person> people = FXCollections.observableArrayList();
        for (Field field : archive.getFieldListForStudent(new LoginPageController().getUserName())) {
            people.add(new Person(field.getFieldName(), field.getFieldNumber() + "", field.getUnit() + "", field.getMaster().getName() + " " + field.getMaster().getLastName(), field.getFirstMeeting() + "\n" + field.getSecondMeeting()));
        }
        clmFieldName.setCellValueFactory(new PropertyValueFactory<Person, String>("fieldName"));
        clmFieldCode.setCellValueFactory(new PropertyValueFactory<Person, String>("fieldCode"));
        clmFieldUnit.setCellValueFactory(new PropertyValueFactory<Person, String>("fieldUnit"));
        clmMasterName.setCellValueFactory(new PropertyValueFactory<Person, String>("masterName"));
        clmStudentMeetingTime.setCellValueFactory(new PropertyValueFactory<Person, String>("studentMeetingTime"));

        StudentTableView.setItems(people);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTable();
    }

}

class Person {

    private final SimpleStringProperty fieldName;
    private final SimpleStringProperty fieldCode;
    private final SimpleStringProperty fieldUnit;
    private final SimpleStringProperty masterName;
    private final SimpleStringProperty studentMeetingTime;


    Person(String fieldName, String fieldCode, String fieldUnit, String masterName, String studentMeetingTime) {
        this.fieldName = new SimpleStringProperty(fieldName);
        this.fieldCode = new SimpleStringProperty(fieldCode);
        this.fieldUnit = new SimpleStringProperty(fieldUnit);
        this.masterName = new SimpleStringProperty(masterName);
        this.studentMeetingTime = new SimpleStringProperty(studentMeetingTime);
    }

    public String getFieldName() {
        return fieldName.get();
    }


    public void setFieldName(String fieldName) {
        this.fieldName.set(fieldName);
    }

    public String getFieldCode() {
        return fieldCode.get();
    }


    public void setFieldCode(String fieldCode) {
        this.fieldCode.set(fieldCode);
    }

    public String getFieldUnit() {
        return fieldUnit.get();
    }


    public void setFieldUnit(String fieldUnit) {
        this.fieldUnit.set(fieldUnit);
    }

    public String getMasterName() {
        return masterName.get();
    }


    public void setMasterName(String masterName) {
        this.masterName.set(masterName);
    }

    public String getStudentMeetingTime() {
        return studentMeetingTime.get();
    }


    public void setStudentMeetingTime(String studentMeetingTime) {
        this.studentMeetingTime.set(studentMeetingTime);
    }
}

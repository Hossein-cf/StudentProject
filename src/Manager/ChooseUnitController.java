package Manager;

import Extra.Archive;
import Extra.Field;
import Extra.Master;
import Extra.Student;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXToggleButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChooseUnitController extends Archive implements Initializable {
    public JFXComboBox comboChooseField;
    public JFXComboBox comboChooseMaster;
    public Button btnCreatClass;
    public TableView chooseUnitTableView;
    public TableColumn clmStudentName;
    public TableColumn clmStudentLastName;
    public TableColumn clmStudentCode;
    public TableColumn clmChooseStudent;

    void setTable() {
        Student student;
        ObservableList<Person> people = FXCollections.observableArrayList();
        ArrayList<Student> students = getStudents();
        for (Student value : students) {
            student = value;
            people.add(new Person(student.getName(), student.getLastName(), student.getStudentNumber() + "", new JFXToggleButton()));
        }
        clmStudentName.setCellValueFactory(new PropertyValueFactory<Person, String>("studentName"));
        clmStudentName.setCellValueFactory(new PropertyValueFactory<Person, String>("studentLastName"));
        clmStudentName.setCellValueFactory(new PropertyValueFactory<Person, String>("studentCode"));
        clmStudentName.setCellValueFactory(new PropertyValueFactory<Person, JFXToggleButton>("chooseStudent"));
        chooseUnitTableView.setItems(people);

        String[] fields = new String[getFields().size()];
        Field field;
        for (int i = 0; i < fields.length; i++) {
            field = getFields().get(i);
            fields[i] = field.getFieldNumber();
        }
        Master master;
        String[] masters = new String[getMasters().size()];
        for (int i = 0; i < masters.length; i++) {
            master = getMasters().get(i);
            masters[i] = String.valueOf(master.getIdCardNumber());
        }
        comboChooseField.getItems().addAll(fields);
        comboChooseMaster.getItems().addAll(masters);


    }

    public void getValue() {
        Field field = new Field();
        Master master;
        ArrayList<Student> students = null;
        for (int i = 0; i < chooseUnitTableView.getFixedCellSize(); i++) {
            Person person = (Person) chooseUnitTableView.getItems().get(i);
            if (person.getChooseStudent().isSelected()) {
                students.add(getStudent(Long.parseLong(person.getStudentCode())));
            }
        }
        field.setExamStartTime(getField((String) comboChooseField.getSelectionModel().getSelectedItem()).getExamStartTime());
        field.setSecondMeeting(getField((String) comboChooseField.getSelectionModel().getSelectedItem()).getSecondMeeting());
        field.setFirstMeeting(getField((String) comboChooseField.getSelectionModel().getSelectedItem()).getFirstMeeting());
        field.setFieldNumber(getField((String) comboChooseField.getSelectionModel().getSelectedItem()).getFieldNumber());
        field.setUnit(getField((String) comboChooseField.getSelectionModel().getSelectedItem()).getUnit());
        field.setFieldName(getField((String) comboChooseField.getSelectionModel().getSelectedItem()).getFieldName());

        field.setListOfStudent(students);
        field.setMaster(getMaster((Long) comboChooseMaster.getSelectionModel().getSelectedItem()));
        ArrayList<Field> fields = getFields();
        fields.add(field);
        setFields(fields);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTable();

    }
}

class Person {
    final private String studentName;
    final private String studentLastName;
    final private String studentCode;
    final private JFXToggleButton chooseStudent;

    public String getStudentName() {
        return studentName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public JFXToggleButton getChooseStudent() {
        return chooseStudent;
    }

    Person(String studentName, String studentLastName, String studentCode, JFXToggleButton chooseStudent) {
        this.studentName = studentName;
        this.studentLastName = studentLastName;
        this.studentCode = studentCode;
        this.chooseStudent = chooseStudent;
    }


}

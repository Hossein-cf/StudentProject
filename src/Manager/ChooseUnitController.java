package Manager;

import Extra.Archive;
import Extra.Field;
import Extra.Master;
import Extra.Student;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXToggleButton;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
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
//        Student student;
        ObservableList<chooseUnitTableFormat> people = FXCollections.observableArrayList();
        ArrayList<Student> students = getStudents();
//        for (Student student1:students) {
//            System.out.println(student1.getStudentNumber());
//        }
        for (Student student1 : students) {

            people.add(new chooseUnitTableFormat(student1.getName(), student1.getLastName(), student1.getStudentNumber() + "", new JFXToggleButton()));
        }
        clmStudentName.setCellValueFactory(new PropertyValueFactory<chooseUnitTableFormat, String>("studentName"));
        clmStudentLastName.setCellValueFactory(new PropertyValueFactory<chooseUnitTableFormat, String>("studentLastName"));
        clmStudentCode.setCellValueFactory(new PropertyValueFactory<chooseUnitTableFormat, String>("studentCode"));
        clmChooseStudent.setCellValueFactory(new PropertyValueFactory<chooseUnitTableFormat, JFXToggleButton>("chooseStudent"));
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
        Field field ;
//        Master master;
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < chooseUnitTableView.getItems().size(); i++) {
            chooseUnitTableFormat person = (chooseUnitTableFormat) chooseUnitTableView.getItems().get(i);
            if (person.getChooseStudent().isSelected()) {

                students.add(getStudent(Long.parseLong(person.getStudentCode())));
            }
        }

        field = getField(String.valueOf(comboChooseField.getSelectionModel().getSelectedItem()));


        field.setListOfStudent(students);
        field.setMaster(getMaster(Long.parseLong(comboChooseMaster.getValue()+"")));


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTable();

    }
}



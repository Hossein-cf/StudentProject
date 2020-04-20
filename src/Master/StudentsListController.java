package Master;

import Extra.Archive;
import Extra.Field;
import Extra.Student;
import LoginPage.LoginPageController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentsListController implements Initializable {
    public TableView<StudentListTableFormt> listOfStudentsTableView;
    public TableColumn<StudentListTableFormt, String> clmStudentName;
    public TableColumn<StudentListTableFormt, String> clmStudentLastName;
    public TableColumn<StudentListTableFormt, String> clmStudentCode;
private void setTable(){
    Field field = new Archive().getFieldForMaster(new LoginPageController().getUserName());
    ArrayList<Student> list = field.getListOfStudent();
    ObservableList<StudentListTableFormt> people = FXCollections.observableArrayList();
    for (Student student:list) {
        people.add(new StudentListTableFormt(student.getName(),student.getLastName(),student.getStudentNumber()+""));
    }
    clmStudentName.setCellValueFactory(new PropertyValueFactory<StudentListTableFormt,String >("studentName"));
    clmStudentLastName.setCellValueFactory(new PropertyValueFactory<StudentListTableFormt,String >("studentLastName"));
    clmStudentCode.setCellValueFactory(new PropertyValueFactory<StudentListTableFormt,String >("studentNumber"));
    listOfStudentsTableView.setItems(people);
}


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

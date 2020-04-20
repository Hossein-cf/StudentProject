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
    public TableView<person> listOfStudentsTableView;
    public TableColumn<person, String> clmStudentName;
    public TableColumn<person, String> clmStudentLastName;
    public TableColumn<person, String> clmStudentCode;
private void setTable(){
    Field field = new Archive().getFieldForMaster(new LoginPageController().getUserName());
    ArrayList<Student> list = field.getListOfStudent();
    ObservableList<person> people = FXCollections.observableArrayList();
    for (Student student:list) {
        people.add(new person(student.getName(),student.getLastName(),student.getStudentNumber()+""));
    }
    clmStudentName.setCellValueFactory(new PropertyValueFactory<person,String >("studentName"));
    clmStudentLastName.setCellValueFactory(new PropertyValueFactory<person,String >("studentLastName"));
    clmStudentCode.setCellValueFactory(new PropertyValueFactory<person,String >("studentNumber"));
    listOfStudentsTableView.setItems(people);
}


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
class person{
    private final SimpleStringProperty studentName;
    private final SimpleStringProperty studentLastName;
    private  final SimpleStringProperty studentNumber;


    person(String  studentName, String  studentLastName, String  studentNumber) {
        this.studentName =new SimpleStringProperty( studentName);
        this.studentLastName =new SimpleStringProperty( studentLastName);
        this.studentNumber = new SimpleStringProperty(studentNumber);
    }


    public String getStudentName() {
        return studentName.get();
    }

    public SimpleStringProperty studentNameProperty() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName.set(studentName);
    }

    public String getStudentLastName() {
        return studentLastName.get();
    }

    public SimpleStringProperty studentLastNameProperty() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName.set(studentLastName);
    }

    public String getStudentNumber() {
        return studentNumber.get();
    }

    public SimpleStringProperty studentNumberProperty() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber.set(studentNumber);
    }
}
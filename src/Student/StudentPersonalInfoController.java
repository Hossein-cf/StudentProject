package Student;

import Extra.Archive;
import Extra.Student;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentPersonalInfoController  implements Initializable {
    public JFXTextField txtShowStudentName;
    public JFXTextField txtShowStudentLastName;
    public JFXTextField txtShowStudentCode;
    public JFXTextField txtShowStudentFatherName;
    public JFXTextField txtShowStudentNationalCode;

    public void setInformation(){
        Archive archive = new Archive();
        JFXTextField userName= new JFXTextField();
        try {

            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/LoginPage.fxml"));
            AnchorPane anchorPane1 = (AnchorPane) anchorPane.getChildren().get(1);
            userName = (JFXTextField) anchorPane1.getChildren().get(0);
        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
        Student  student = archive.getStudent(Long.parseLong(userName.getText()));
        txtShowStudentCode.setText(student.getStudentNumber()+"");
        txtShowStudentFatherName.setText(student.getFatherName());
        txtShowStudentLastName.setText(student.getLastName());
        txtShowStudentName.setText(student.getName());
        txtShowStudentNationalCode.setText(student.getNationalNumber()+"");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setInformation();
    }
}

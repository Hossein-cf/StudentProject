package NewStudent;

import Extra.Archive;
import Extra.Student;
import Extra.StudentAndMasterNumberAndFieldSerialProducer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class NewStudentController  extends Archive implements Initializable  {
    public JFXButton btnBack;
    public JFXButton btnExit;
    public AnchorPane mainAnchorPane;
    public Label lbl1;
    public TextField txtName;
    public TextField txtLastName;
    public TextField txtNationalNumber;
    public TextField txtFatherName;
    public TextField txtPhoneNumber;
    public JFXComboBox comboBoxGender;
    public JFXComboBox comboBoxDiplomaType;


    public void exit() {

        Alert alert = new Alert(Alert.AlertType.WARNING, "آیا میخواهید خارج شوید؟ ", ButtonType.YES, ButtonType.NO);
        alert.setTitle("اخطار");
        alert.setHeaderText(null);
        ButtonType yes = new ButtonType("بله");
        ButtonType no = new ButtonType("خیر");
        alert.getButtonTypes().setAll(yes,no);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent())
            if (result.get() == yes)
                System.exit(0);
    }

    public void back() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "آیا می خواهید به صفحه اصلی برگردید؟ ", ButtonType.YES, ButtonType.NO);
        alert.setTitle("اخطار");
        alert.setHeaderText(null);
        ButtonType yes = new ButtonType("بله");
        ButtonType no = new ButtonType("خیر");
        alert.getButtonTypes().setAll(yes,no);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent()) {
            if (result.get() == yes) {

                Parent root;
                try {
                    Stage stage = (Stage) btnBack.getScene().getWindow();
                    stage.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../LoginPage/LoginPage.fxml"));
                    root = loader.load();
                    stage = new Stage();
                    Stage finalStage = stage;
                    finalStage.setResizable(false);
                    finalStage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(new Scene(root, 837, 473));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }

    }

    public void confirm(MouseEvent mouseEvent) {
        Student student = new Student();
        student.setName(txtName.getText());
        student.setFatherName(txtFatherName.getText());
        student.setLastName(txtLastName.getText());
        student.setStudentNumber(new StudentAndMasterNumberAndFieldSerialProducer().getStudentNumber());
        student.setNationalNumber(Long.parseLong(txtNationalNumber.getText()));
        student.setPhoneNumber(txtPhoneNumber.getText());
        student.setTypeOfDiploma((String)comboBoxDiplomaType.getValue());
        student.setGender((String)comboBoxGender.getValue());

        ArrayList<Student> list= getStudents();
        list.add(student);
        setStudents(list);
        loadResultPage(student.getStudentNumber());



    }

    public void loadResultPage(Long studentNumber){
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("./ShowResult.fxml"));
            mainAnchorPane.getChildren().addAll(anchorPane);
            JFXTextField jfxTextField = (JFXTextField) anchorPane.getChildren().get(0);
            jfxTextField.setText(studentNumber+"");
        } catch (IOException ex) {
            System.out.println("Problem in loading");
            ex.printStackTrace();
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       String []gender = {"مرد","زن"};
       String [] diplomaType = {"ریاضی فیزیک"};
       comboBoxGender.setItems(FXCollections.observableArrayList(gender));
       comboBoxDiplomaType.setItems(FXCollections.observableArrayList(diplomaType));
    }
}

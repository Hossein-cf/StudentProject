import Extra.Archive;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {
    public JFXTextField txtUserName;
    public JFXTextField txtPassWord;
    public JFXComboBox comboUseCase;
    public JFXButton btnLogin;
    public JFXButton btnClose;
    public Label lblAlert;

    private int findComboIndex(JFXComboBox Box) {
        return Box.getSelectionModel().getSelectedIndex();
    }

    private void alert(String message, Label lbl, String color) {
        lbl.setText(message);
        lbl.setStyle("-fx-text-fill: " + color + ";");
    }

    public void login() {
        Archive archive = new Archive();
        if (txtPassWord.getText().equals("") || txtUserName.getText().equals("") || findComboIndex(comboUseCase) == -1) {

            alert("لفا فیلد هار تکمیل کنید", lblAlert, "red");
        } else {
            if (findComboIndex(comboUseCase) == 0) {
                if (archive.isNewStudent(txtUserName.getText(), txtPassWord.getText()))
                    loadNewStudent();
                else
                    alert("مشخصات وارد شده صحیح نمیباشند", lblAlert, "red");

            } else if (findComboIndex(comboUseCase) == 1) {
                if (archive.getStudent(Long.parseLong(txtUserName.getText())) != null)
                    loadStudent();
                else
                    alert("مشخصات وارد شده صحیح نمیباشند", lblAlert, "red");

            } else if (findComboIndex(comboUseCase) == 2) {
                if (archive.getMaster(Long.parseLong(txtUserName.getText())) != null)
                    loadMaster();
                else
                    alert("مشخصات وارد شده صحیح نمیباشند", lblAlert, "red");

            } else if (findComboIndex(comboUseCase) == 3) {
                loadManager();
            }
        }

    }

    public void exit() {

        Alert alert = new Alert(Alert.AlertType.WARNING, "آیا میخواهید خارج شوید؟ ", ButtonType.YES, ButtonType.NO);
        alert.setTitle("اخطار");
        alert.setHeaderText(null);
        ButtonType yes = new ButtonType("بله");
        ButtonType no = new ButtonType("خیر");
        alert.getButtonTypes().setAll(yes, no);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent())
            if (result.get() == yes)
                System.exit(0);
    }

    public void loadNewStudent() {

        Parent root;
        try {
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("./NewStudent/NewStudentFXML.fxml"));
            root = loader.load();
            stage = new Stage();
            Stage finalStage = stage;
            finalStage.setResizable(false);
            finalStage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadStudent() {
        Parent root;
        try {
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("./Student/FXML/StudentFXML.fxml"));
            root = loader.load();
            stage = new Stage();
            Stage finalStage = stage;
            finalStage.setResizable(false);
            finalStage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void loadMaster() {

        Parent root;
        try {
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("./Master/FXML/Master.fxml"));
            root = loader.load();
            stage = new Stage();
            Stage finalStage = stage;
            finalStage.setResizable(false);
            finalStage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadManager() {
        Parent root;
        try {
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("./Manager/FXML/ManagerFXML.fxml"));
            root = loader.load();
            stage = new Stage();
            Stage finalStage = stage;
            finalStage.setResizable(false);
            finalStage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


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

    public void initialize(URL location, ResourceBundle resources) {

        txtUserName.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(15));
        txtPassWord.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(15));

        String[] array = {"دانشجو جدیدالورود", "دانشجو", "استاد", "کارمند آموزش"};
        comboUseCase.getItems().addAll(array);

    }
}

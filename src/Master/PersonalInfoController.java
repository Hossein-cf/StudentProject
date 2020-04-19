package Master;

import Extra.Archive;
import Extra.Master;
import LoginPage.LoginPageController;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonalInfoController implements Initializable {
    public JFXTextField txtShowMasterName;
    public JFXTextField txtShowMasterLastName;
    public JFXTextField txtShowMasterCode;
    public JFXTextField txtShowMasterFatherName;
    public JFXTextField txtShowMasterNationalCode;

public void setInformation(){

    Master master = new Archive().getMaster(new LoginPageController().getUserName());
    txtShowMasterCode.setText(master.getMasterNumber()+"");
    txtShowMasterFatherName.setText(master.getFatherName());
    txtShowMasterLastName.setText(master.getLastName());
    txtShowMasterName.setText(master.getName());
    txtShowMasterNationalCode.setText(master.getNationalNumber()+"");

}


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setInformation();
    }
}

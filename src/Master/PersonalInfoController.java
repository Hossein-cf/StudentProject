package Master;

import Extra.Archive;
import Extra.Master;
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
    JFXTextField userName= new JFXTextField();
    try {

        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/LoginPage.fxml"));
        AnchorPane anchorPane1 = (AnchorPane) anchorPane.getChildren().get(1);
        userName = (JFXTextField) anchorPane1.getChildren().get(0);
    }catch (Exception e ){
        System.out.println(e.getMessage());
    }

    Master master = new Archive().getMaster(Long.parseLong(userName.getText()));
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

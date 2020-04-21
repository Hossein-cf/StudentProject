package Master;

import Extra.Archive;
import Extra.Field;
import LoginPage.LoginPageController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class WeeklyProgramController implements Initializable {
    public TableView<WeeklyProgramTableFormat> MasterTableView;
    public TableColumn<WeeklyProgramTableFormat, String> clmMasterFieldName;
    public TableColumn<WeeklyProgramTableFormat, String> clmMasterFieldCode;
    public TableColumn<WeeklyProgramTableFormat, String> clmMasterFieldUnit;
    public TableColumn<WeeklyProgramTableFormat, String> clmMasterFieldTimeInWeek;

    private void setTable() {

        Field field = new Archive().getFieldForMaster(new LoginPageController().getUserName());


        ObservableList<WeeklyProgramTableFormat> people = FXCollections.observableArrayList(new WeeklyProgramTableFormat(field.getFieldName(), field.getFieldNumber() + "", field.getUnit() + "", field.getFirstMeeting() + "\n" + field.getSecondMeeting()));
        clmMasterFieldCode.setCellValueFactory(new PropertyValueFactory<WeeklyProgramTableFormat, String>("fieldCode"));
        clmMasterFieldName.setCellValueFactory(new PropertyValueFactory<WeeklyProgramTableFormat, String>("fieldName"));
        clmMasterFieldUnit.setCellValueFactory(new PropertyValueFactory<WeeklyProgramTableFormat, String>("fieldUnit"));
        clmMasterFieldTimeInWeek.setCellValueFactory(new PropertyValueFactory<WeeklyProgramTableFormat, String>("fieldTimeInWeek"));
        MasterTableView.setItems(people);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTable();
    }
}


package Master;

import Extra.Archive;
import Extra.Field;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class WeeklyProgramController implements Initializable {
    public TableView<Person> MasterTableView;
    public TableColumn<Person, String> clmMasterFieldName;
    public TableColumn<Person, String> clmMasterFieldCode;
    public TableColumn<Person, String> clmMasterFieldUnit;
    public TableColumn<Person, String> clmMasterFieldTimeInWeek;

    private void setTable() {
        JFXTextField userName = new JFXTextField();
        try {

            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/LoginPage.fxml"));
            AnchorPane anchorPane1 = (AnchorPane) anchorPane.getChildren().get(1);
            userName = (JFXTextField) anchorPane1.getChildren().get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Field field = new Archive().getFieldForMaster(Long.parseLong(userName.getText()));
        ObservableList<Person> people = FXCollections.observableArrayList(new Person(field.getFieldName(), field.getFieldNumber() + "", field.getUnit() + "", field.getFirstMeeting() + "\n" + field.getSecondMeeting()));
        clmMasterFieldCode.setCellValueFactory(new PropertyValueFactory<Person, String>("fieldCode"));
        clmMasterFieldName.setCellValueFactory(new PropertyValueFactory<Person, String>("fieldName"));
        clmMasterFieldUnit.setCellValueFactory(new PropertyValueFactory<Person, String>("fieldUnit"));
        clmMasterFieldTimeInWeek.setCellValueFactory(new PropertyValueFactory<Person, String>("fieldTimeInWeek"));
        MasterTableView.setItems(people);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTable();
    }
}

class Person {
    private final SimpleStringProperty fieldName;
    private final SimpleStringProperty fieldCode;
    private final SimpleStringProperty fieldUnit;
    private final SimpleStringProperty fieldTimeInWeek;

    Person(String fieldName, String fieldCode, String fieldUnit, String fieldTimeInWeek) {
        this.fieldName = new SimpleStringProperty(fieldName);
        this.fieldCode = new SimpleStringProperty(fieldCode);
        this.fieldUnit = new SimpleStringProperty(fieldUnit);
        this.fieldTimeInWeek = new SimpleStringProperty(fieldTimeInWeek);
    }

    public String getFieldName() {
        return fieldName.get();
    }

    public SimpleStringProperty fieldNameProperty() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName.set(fieldName);
    }

    public String getFieldCode() {
        return fieldCode.get();
    }

    public SimpleStringProperty fieldCodeProperty() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode.set(fieldCode);
    }

    public String getFieldUnit() {
        return fieldUnit.get();
    }

    public SimpleStringProperty fieldUnitProperty() {
        return fieldUnit;
    }

    public void setFieldUnit(String fieldUnit) {
        this.fieldUnit.set(fieldUnit);
    }

    public String getFieldTimeInWeek() {
        return fieldTimeInWeek.get();
    }

    public SimpleStringProperty fieldTimeInWeekProperty() {
        return fieldTimeInWeek;
    }

    public void setFieldTimeInWeek(String fieldTimeInWeek) {
        this.fieldTimeInWeek.set(fieldTimeInWeek);
    }
}
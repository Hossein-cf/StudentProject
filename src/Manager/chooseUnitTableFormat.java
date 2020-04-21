package Manager;

import com.jfoenix.controls.JFXToggleButton;
import javafx.beans.property.SimpleStringProperty;

public class chooseUnitTableFormat {
    final private SimpleStringProperty studentName;
    final private SimpleStringProperty studentLastName;
    final private SimpleStringProperty studentCode;
    final private JFXToggleButton chooseStudent;

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

    public String getStudentCode() {
        return studentCode.get();
    }

    public SimpleStringProperty studentCodeProperty() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode.set(studentCode);
    }

    public JFXToggleButton getChooseStudent() {
        return chooseStudent;
    }

    chooseUnitTableFormat(String studentName, String studentLastName, String studentCode, JFXToggleButton chooseStudent) {
        this.studentName = new SimpleStringProperty(studentName);
        this.studentLastName = new SimpleStringProperty( studentLastName);
        this.studentCode = new SimpleStringProperty(studentCode);
        this.chooseStudent = chooseStudent;
    }

}

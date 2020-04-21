package Student;

import javafx.beans.property.SimpleStringProperty;

public class Person {
    private final SimpleStringProperty fieldName;
    private final SimpleStringProperty fieldCode;
    private final SimpleStringProperty fieldUnit;
    private final SimpleStringProperty masterName;
    private final SimpleStringProperty studentMeetingTime;


    Person(String fieldName, String fieldCode, String fieldUnit, String masterName, String studentMeetingTime) {
        this.fieldName = new SimpleStringProperty(fieldName);
        this.fieldCode = new SimpleStringProperty(fieldCode);
        this.fieldUnit = new SimpleStringProperty(fieldUnit);
        this.masterName = new SimpleStringProperty(masterName);
        this.studentMeetingTime = new SimpleStringProperty(studentMeetingTime);
    }

    public String getFieldName() {
        return fieldName.get();
    }


    public void setFieldName(String fieldName) {
        this.fieldName.set(fieldName);
    }

    public String getFieldCode() {
        return fieldCode.get();
    }


    public void setFieldCode(String fieldCode) {
        this.fieldCode.set(fieldCode);
    }

    public String getFieldUnit() {
        return fieldUnit.get();
    }


    public void setFieldUnit(String fieldUnit) {
        this.fieldUnit.set(fieldUnit);
    }

    public String getMasterName() {
        return masterName.get();
    }


    public void setMasterName(String masterName) {
        this.masterName.set(masterName);
    }

    public String getStudentMeetingTime() {
        return studentMeetingTime.get();
    }


    public void setStudentMeetingTime(String studentMeetingTime) {
        this.studentMeetingTime.set(studentMeetingTime);
    }
}

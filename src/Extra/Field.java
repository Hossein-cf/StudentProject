package Extra;

import java.util.ArrayList;
import java.util.Date;

public class Field {
    private String fieldName;
    private String fieldNumber;
    private int unit;
    private String firstMeeting;
    private String secondMeeting;
    private String examStartTime;
    private Master master;
    private ArrayList<Student> listOfStudent;


    public void setFirstMeeting(String classStartDay) {
        this.firstMeeting = classStartDay;
    }

    public void setSecondMeeting(String classStartTime) {
        this.secondMeeting = classStartTime;
    }

    public String getFirstMeeting() {
        return firstMeeting;
    }

    public String getSecondMeeting() {
        return secondMeeting;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(String fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public void setExamStartTime(String examStartTime) {
        this.examStartTime = examStartTime;
    }

    public String getExamStartTime() {
        return examStartTime;
    }


    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public ArrayList<Student> getListOfStudent() {
        return listOfStudent;
    }

    public void setListOfStudent(ArrayList<Student> listOfStudent) {
        this.listOfStudent = listOfStudent;
    }
}

package Extra;

import java.util.ArrayList;
import java.util.Date;

public class Field {
    private String fieldName;
    private String fieldNumber;
    private int unit;
    private String classStartDay;
    private String classStartTime;
    private Date examStartTime;
    private Master master;
    private ArrayList<Student> listOfStudent;


    public void setClassStartDay(String classStartDay) {
        this.classStartDay = classStartDay;
    }

    public void setClassStartTime(String classStartTime) {
        this.classStartTime = classStartTime;
    }

    public String getClassStartDay() {
        return classStartDay;
    }

    public String getClassStartTime() {
        return classStartTime;
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

    public void setExamStartTime(Date examStartTime) {
        this.examStartTime = examStartTime;
    }

    public Date getExamStartTime() {
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

package Master;

import javafx.beans.property.SimpleStringProperty;

public class StudentListTableFormt {

        private final SimpleStringProperty studentName;
        private final SimpleStringProperty studentLastName;
        private  final SimpleStringProperty studentNumber;


        StudentListTableFormt(String  studentName, String  studentLastName, String  studentNumber) {
        this.studentName =new SimpleStringProperty( studentName);
        this.studentLastName =new SimpleStringProperty( studentLastName);
        this.studentNumber = new SimpleStringProperty(studentNumber);
    }


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

        public String getStudentNumber() {
        return studentNumber.get();
    }

        public SimpleStringProperty studentNumberProperty() {
        return studentNumber;
    }

        public void setStudentNumber(String studentNumber) {
        this.studentNumber.set(studentNumber);
    }

}

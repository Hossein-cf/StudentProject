package Extra;

public class Student extends Person {
    private long studentNumber;
    private String typeOfDiploma;

    public String getTypeOfDiploma() {
        return typeOfDiploma;
    }

    public void setTypeOfDiploma(String typeOfDiploma) {
        this.typeOfDiploma = typeOfDiploma;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

}

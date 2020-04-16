package Extra;

import java.util.ArrayList;

public class Archive {
    private static ArrayList<Student> students;
    private static ArrayList<Master> masters;
    private static ArrayList<Field> fields;

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void setStudents(ArrayList<Student> students) {
        Archive.students = students;
    }

    public static ArrayList<Master> getMasters() {
        return masters;
    }

    public static void setMasters(ArrayList<Master> masters) {
        Archive.masters = masters;
    }

    public static ArrayList<Field> getFields() {
        return fields;
    }

    public static void setFields(ArrayList<Field> fields) {
        Archive.fields = fields;
    }

    public Student getStudent(long studentNumber) {
        for (Student student1 : getStudents()) {
            if (student1.getStudentNumber() == studentNumber) {
                return student1;
            }
        }
        return null;
    }

    public Master getMaster(long masterNumber) {
        for (Master master : getMasters()) {
            if (master.getMasterNumber() == masterNumber)
                return master;
        }
        return null;
    }

    public ArrayList<Field> getFieldListForStudent(long studentNumber) {

        ArrayList<Field> fields = new ArrayList<>();
        for (Field field : getFields()) {
            for (Student student : field.getListOfStudent()) {
                if (student.getStudentNumber() == studentNumber)
                    fields.add(field);
            }
        }

        return fields;
    }

}

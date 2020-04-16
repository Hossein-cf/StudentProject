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
}

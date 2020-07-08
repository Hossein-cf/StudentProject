package Extra;

import javafx.fxml.Initializable;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Archive implements Initializable {
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Master> masters = new ArrayList<>();
    private static ArrayList<Field> fields = new ArrayList<>();

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
            if (master.getIdCardNumber() == masterNumber)
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

    public Field getFieldForMaster(long masterNumber) {
        for (Field field : getFields()) {
            if (field.getMaster().getIdCardNumber() == masterNumber)
                return field;
        }


        return null;
    }

    public boolean isNewStudent(String nationalNumber, String fileNumber) {
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src\\Files\\newStudents.csv")));
            bufferedReader.readLine();
            while (bufferedReader.ready()) {
                String[] strings = bufferedReader.readLine().split(",");
//                System.out.println(strings[2] + "   " + strings[6]);
                if (strings[2].equals(nationalNumber) && strings[6].equals(fileNumber))
                    return true;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        return false;
    }

    public Field getField(String fieldNumber) {

        for (Field field : getFields()) {
            if (field.getFieldNumber().equals(fieldNumber))
                return field;
        }
        return null;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}

package Extra;

public class StudentAndMasterNumberAndFieldSerialProducer extends Archive {

    public long getStudentNumber() {

        long number;
        int numberOfStudent;
        if (getStudents() == null)
            numberOfStudent = 0;
        else
            numberOfStudent = getStudents().size();
        String str = "98536";
        number = Long.parseLong(getStringNumber(numberOfStudent, str));

        return number;
    }

    public long getMasterNumber() {

        long number;
        int numberOfMaster = getMasters().size();
        String str = "855494";
        number = Long.parseLong(getStringNumber(numberOfMaster, str));
        System.out.println(number);
        return number;
    }

    private String getStringNumber(int number, String str) {

        if (number <= 9) {
            str += "000" + number;
        } else if (number <= 99) {
            str += "00" + number;
        } else if (number <= 999) {
            str += "0" + number;
        } else if (number <= 9999)
            str += number;
        System.out.println(str);
        return str;
    }

    public long getFieldSerial() {

        long serial;
        int numberOfFields = getFields().size();
        String str = "98";
        serial = Long.parseLong(getStringNumber(numberOfFields, str));

        return serial;
    }

}

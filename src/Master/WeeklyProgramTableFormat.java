package Master;

import javafx.beans.property.SimpleStringProperty;

public class WeeklyProgramTableFormat {
    private final SimpleStringProperty fieldName;
    private final SimpleStringProperty fieldCode;
    private final SimpleStringProperty fieldUnit;
    private final SimpleStringProperty fieldTimeInWeek;

    WeeklyProgramTableFormat(String fieldName, String fieldCode, String fieldUnit, String fieldTimeInWeek) {
        this.fieldName = new SimpleStringProperty(fieldName);
        this.fieldCode = new SimpleStringProperty(fieldCode);
        this.fieldUnit = new SimpleStringProperty(fieldUnit);
        this.fieldTimeInWeek = new SimpleStringProperty(fieldTimeInWeek);
    }

    public String getFieldName() {
        return fieldName.get();
    }

    public SimpleStringProperty fieldNameProperty() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName.set(fieldName);
    }

    public String getFieldCode() {
        return fieldCode.get();
    }

    public SimpleStringProperty fieldCodeProperty() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode.set(fieldCode);
    }

    public String getFieldUnit() {
        return fieldUnit.get();
    }

    public SimpleStringProperty fieldUnitProperty() {
        return fieldUnit;
    }

    public void setFieldUnit(String fieldUnit) {
        this.fieldUnit.set(fieldUnit);
    }

    public String getFieldTimeInWeek() {
        return fieldTimeInWeek.get();
    }

    public SimpleStringProperty fieldTimeInWeekProperty() {
        return fieldTimeInWeek;
    }

    public void setFieldTimeInWeek(String fieldTimeInWeek) {
        this.fieldTimeInWeek.set(fieldTimeInWeek);
    }
}

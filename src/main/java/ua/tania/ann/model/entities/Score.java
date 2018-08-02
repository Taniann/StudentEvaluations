package ua.tania.ann.model.entities;

/**
 * Created by Таня on 25.07.2018.
 */
public class Score {
    private int id;
    private int value;
    private int studentId;
    private String subjectName;

    public Score(int value, String subjectName) {
        this.value = value;
        this.subjectName = subjectName;
    }

    public Score(int value, int studentId, String subjectName) {
        this.value = value;
        this.studentId = studentId;
        this.subjectName = subjectName;
    }

    public Score(int id, int value, int studentId, String subjectName) {
        this.id = id;
        this.value = value;
        this.studentId = studentId;
        this.subjectName = subjectName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}

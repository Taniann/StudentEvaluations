package ua.tania.ann.model.entities;

/**
 * Created by Таня on 25.07.2018.
 */
public class Score {
    private int id;
    private int value;
    private int studentId;
    private int subjectId;

    public Score(int value, int studentId, int subjectId) {
        this.value = value;
        this.studentId = studentId;
        this.subjectId = subjectId;
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

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
}

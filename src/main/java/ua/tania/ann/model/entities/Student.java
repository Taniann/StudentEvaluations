package ua.tania.ann.model.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Таня on 25.07.2018.
 */
public class Student {
    private int id;
    private String firstName;
    private String secondName;
    private String middleName;
    private int kurs;
    private String group;
    private String studyForm;
    private String paymentForm;
    private Map<String, Integer> finalResult1 = new HashMap<>();
    private Map<Subject, Score> finalResult = new HashMap<>();
    private Double finalAverageValue;

    public Student(int id, String firstName, String secondName, String middleName, int kurs, String group,
                   String studyForm, String paymentForm) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.kurs = kurs;
        this.group = group;
        this.studyForm = studyForm;
        this.paymentForm = paymentForm;
    }

    public Student(String firstName, String secondName, String middleName, int kurs, String group, String studyForm, String paymentForm) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.kurs = kurs;
        this.group = group;
        this.studyForm = studyForm;
        this.paymentForm = paymentForm;
    }

    public Student(int id, String firstName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getStudyForm() {
        return studyForm;
    }

    public void setStudyForm(String studyForm) {
        this.studyForm = studyForm;
    }

    public String getPaymentForm() {
        return paymentForm;
    }

    public void setPaymentForm(String paymentForm) {
        this.paymentForm = paymentForm;
    }

    public int getKurs() {
        return kurs;
    }

    public void setKurs(int kurs) {
        this.kurs = kurs;
    }

   /* public Map<String, Integer> getFinalResult() {
        return finalResult;
    }*/

    /*public void setFinalResult(Map<String, Integer> finalResult) {
        this.finalResult = finalResult;
    }*/

    public Map<Subject, Score> getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(Map<Subject, Score> finalResult) {
        this.finalResult = finalResult;
    }

    public Double getFinalAverageValue() {
        return finalAverageValue;
    }

    public void setFinalAverageValue(Double finalAverageValue) {
        this.finalAverageValue = finalAverageValue;
    }
}

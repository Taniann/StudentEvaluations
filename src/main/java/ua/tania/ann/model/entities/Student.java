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
    private Map<Subject, Score> resultForFirstAtestation = new HashMap<>();
    private Map<Subject, Score> resultForSecondAtestation = new HashMap<>();
    private Map<String, Integer> finalResult = new HashMap<>();
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

    public Map<Subject, Score> getResultForFirstAtestation() {
        return resultForFirstAtestation;
    }

    public void setResultForFirstAtestation(Map<Subject, Score> resultForFirstAtestation) {
        this.resultForFirstAtestation = resultForFirstAtestation;
    }

    public Map<Subject, Score> getResultForSecondAtestation() {
        return resultForSecondAtestation;
    }

    public void setResultForSecondAtestation(Map<Subject, Score> resultForSecondAtestation) {
        this.resultForSecondAtestation = resultForSecondAtestation;
    }

    public Map<String, Integer> getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(Map<String, Integer> finalResult) {
        this.finalResult = finalResult;
    }

    public Double getFinalAverageValue() {
        return finalAverageValue;
    }

    public void setFinalAverageValue(Double finalAverageValue) {
        this.finalAverageValue = finalAverageValue;
    }
}

package ro.challenge.accepted.magichome.domain;

import java.util.List;
import java.util.Objects;

public class Patient {

    private long patientId;
    private String patientFirstName;
    private String patientLastName;
    private String diagnosis;
    private int age;
    private Doctor doctor;
    private boolean disability;

    public Patient (){

    }
    public Patient(long patientId, String patientFirstName, String patientLastName, String diagnosis, int age, Doctor doctor, boolean disability) {
        this.patientId = patientId;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.diagnosis = diagnosis;
        this.age = age;
        this.doctor = doctor;
        this.disability = disability;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public boolean isDisability() {
        return disability;
    }

    public void setDisability(boolean disability) {
        this.disability = disability;

    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientFirstName='" + patientFirstName + '\'' +
                ", patientLastName='" + patientLastName + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", age=" + age +
                ", doctor=" + doctor +
                ", disability=" + disability +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return patientId == patient.patientId &&
                age == patient.age &&
                disability == patient.disability &&
                Objects.equals(patientFirstName, patient.patientFirstName) &&
                Objects.equals(patientLastName, patient.patientLastName) &&
                Objects.equals(diagnosis, patient.diagnosis) &&
                Objects.equals(doctor, patient.doctor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(patientId, patientFirstName, patientLastName, diagnosis, age, doctor, disability);
    }
}


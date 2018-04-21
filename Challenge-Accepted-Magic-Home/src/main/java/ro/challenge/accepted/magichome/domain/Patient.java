package ro.challenge.accepted.magichome.domain;


import java.util.Objects;

public class Patient {

    private long id;
    private String firstName;
    private String patientLastName;
    private String diagnosis;
    private int age;
    private Doctor doctor;
    private long doctorId;
    private boolean disability;

    public Patient (){

    }
    public Patient(long patientId, String firstName, String patientLastName, String diagnosis, int age, Doctor doctor, boolean disability) {
        this.id = patientId;
        this.firstName = firstName;
        this.patientLastName = patientLastName;
        this.diagnosis = diagnosis;
        this.age = age;
        this.doctor = doctor;
        this.disability = disability;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id &&
                age == patient.age &&
                disability == patient.disability &&
                Objects.equals(firstName, patient.firstName) &&
                Objects.equals(patientLastName, patient.patientLastName) &&
                Objects.equals(diagnosis, patient.diagnosis) &&
                Objects.equals(doctor, patient.doctor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, patientLastName, diagnosis, age, doctor, disability);
    }
}


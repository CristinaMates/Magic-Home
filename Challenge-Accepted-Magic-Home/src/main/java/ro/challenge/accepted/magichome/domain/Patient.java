package ro.challenge.accepted.magichome.domain;


import java.util.Objects;

public class Patient {

    private long id;
    private String firstName;
    private String lastName;
    private String diagnosis;
    private int age;
    private Doctor doctor;
    private boolean disability;


    public Patient (){

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id &&
                age == patient.age &&
                disability == patient.disability &&
                Objects.equals(firstName, patient.firstName) &&
                Objects.equals(lastName, patient.lastName) &&
                Objects.equals(diagnosis, patient.diagnosis) &&
                Objects.equals(doctor, patient.doctor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, diagnosis, age, doctor, disability);
    }
}


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
    private long doctorID;

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

    public long getDoctorId() {
        return doctorID;
    }

    public void setDoctorId(long doctorID) {
        this.doctorID = doctorID;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", age=" + age +
                ", doctor=" + doctor +
                ", disability=" + disability +
                ", doctorID=" + doctorID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (id != patient.id) return false;
        if (age != patient.age) return false;
        if (disability != patient.disability) return false;
        if (doctorID != patient.doctorID) return false;
        if (firstName != null ? !firstName.equals(patient.firstName) : patient.firstName != null) return false;
        if (lastName != null ? !lastName.equals(patient.lastName) : patient.lastName != null) return false;
        if (diagnosis != null ? !diagnosis.equals(patient.diagnosis) : patient.diagnosis != null) return false;
        return doctor != null ? doctor.equals(patient.doctor) : patient.doctor == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (diagnosis != null ? diagnosis.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (doctor != null ? doctor.hashCode() : 0);
        result = 31 * result + (disability ? 1 : 0);
        result = 31 * result + (int) (doctorID ^ (doctorID >>> 32));
        return result;
    }
}


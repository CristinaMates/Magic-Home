package ro.challenge.accepted.magichome.domain;

import java.util.Date;

public class Reservation {
    private int id;

    private long CustodianID;
    private Custodian custodian;

    private long PatientID;
    private Patient patient;

    private int numberOfCustodians;

    private long doctorID;
    private Doctor doctor;
    private Date entranceDate;
    private int days;
    private boolean needsPsychologicalCounseling;

    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Custodian getCustodian() {
        return custodian;
    }

    public void setCustodian(Custodian custodian) {
        this.custodian = custodian;
    }

    public int getNumberOfCustodians() {
        return numberOfCustodians;
    }

    public void setNumberOfCustodians(int numberOfCustodians) {
        this.numberOfCustodians = numberOfCustodians;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(Date entranceDate) {
        this.entranceDate = entranceDate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isNeedsPsychologicalCounseling() {
        return needsPsychologicalCounseling;
    }

    public void setNeedsPsychologicalCounseling(boolean needsPsychologicalCounseling) {
        this.needsPsychologicalCounseling = needsPsychologicalCounseling;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public long getCustodianID() {
        return CustodianID;
    }

    public void setCustodianID(long custodianID) {
        CustodianID = custodianID;
    }

    public long getPatientID() {
        return PatientID;
    }

    public void setPatientID(long patientID) {
        PatientID = patientID;
    }

    public long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(long doctorID) {
        this.doctorID = doctorID;
    }
}
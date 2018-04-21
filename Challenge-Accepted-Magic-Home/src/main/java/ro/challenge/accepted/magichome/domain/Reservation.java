package ro.challenge.accepted.magichome.domain;

import java.util.Date;

public class Reservation {
    private int id;
    private Custodian custodian;
    private int numberOfCustodians;
    private Doctor doctor;
    private Date entranceDate;
    private int days;
    private boolean needsPsychologicalCounseling;

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

    @Override
    public String toString() {
        return "Reservation ID: " + id +
                "\nCustodian: " + custodian.toString() +
                "\nDoctor:" + doctor.toString() +
                "\nWants housing from: " + entranceDate.toString() +
                "\nNeeds counseling: " + ((needsPsychologicalCounseling) ? "yes" : "no");
    }
}

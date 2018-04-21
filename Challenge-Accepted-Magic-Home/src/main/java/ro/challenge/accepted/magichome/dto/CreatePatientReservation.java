package ro.challenge.accepted.magichome.dto;

import ro.challenge.accepted.magichome.domain.Custodian;
import ro.challenge.accepted.magichome.domain.Patient;

import java.util.Date;

public class CreatePatientReservation {
    private Patient pacient;

    private String diagnosis;

    private boolean disability;

    private String doctor;


    private Custodian custodian;

    private Date from;

    int period;

    boolean needsPsychologicalCounseling;

    public Patient getPacient() {
        return pacient;
    }

    public void setPacient(Patient pacient) {
        this.pacient = pacient;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public boolean isDisability() {
        return disability;
    }

    public void setDisability(boolean disability) {
        this.disability = disability;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Custodian getCustodian() {
        return custodian;
    }

    public void setCustodian(Custodian custodian) {
        this.custodian = custodian;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public boolean isNeedsPsychologicalCounseling() {
        return needsPsychologicalCounseling;
    }

    public void setNeedsPsychologicalCounseling(boolean needsPsychologicalCounseling) {
        this.needsPsychologicalCounseling = needsPsychologicalCounseling;
    }
}

package ro.challenge.accepted.magichome.dto;

import ro.challenge.accepted.magichome.domain.Custodian;
import ro.challenge.accepted.magichome.domain.Doctor;
import ro.challenge.accepted.magichome.domain.Pacient;

public class CreatePacientReservation {
private Pacient pacient;
private String pacientFirstName;
private String pacientLastName;
private String diagnosis;
private int age;
private boolean disability;

private Doctor doctor;
private String firstNameDoctor;
private String lastNameDoctor;

private Custodian custodian;
private String firstNameCustodian;
private String lastNameCustodian;
private long telehone;
}

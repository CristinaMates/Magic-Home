package ro.challenge.accepted.magichome.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.challenge.accepted.magichome.domain.Custodian;
import ro.challenge.accepted.magichome.domain.Doctor;
import ro.challenge.accepted.magichome.domain.Patient;
import ro.challenge.accepted.magichome.domain.Reservation;
import ro.challenge.accepted.magichome.dto.AcceptRequest;

import ro.challenge.accepted.magichome.dto.CreatePatientReservation;
import ro.challenge.accepted.magichome.service.ReservationService;
import ro.challenge.accepted.magichome.service.SMSService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private SMSService smsService;


    @RequestMapping("")
    public List<Reservation> list() {
        return reservationService.getAll();
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String create(@PathVariable Reservation dto) {
        reservationService.createReservation(dto);
        // /reservationService.createReservation(null);///new Reservation());

        return "OK";

    }


    @RequestMapping(value = "/accept", method = RequestMethod.POST)
    public String acceptReservation(@RequestBody AcceptRequest acceptRequest) {

        LOGGER.info("Reservation Accept {}", acceptRequest);
        try {
            if (false) {
                smsService.sendSms("40724251112", acceptRequest.getText() + acceptRequest.isAccept());
            }
        }catch (Exception ex ){
            LOGGER.error("Error sending SMS", ex);
            return "ERROR";
        }

        return "OK";
    }


    @RequestMapping(value = "/mock", method = RequestMethod.GET)
    public Reservation mockReservation() {
        Reservation result = new Reservation();
        result.setEntranceDate(new Date());
        result.setDays(5);

        Custodian custodian = new Custodian();
        custodian.setTelephone("40724251112");
        custodian.setFirstName("Tata");
        custodian.setLastName("Lui Georgel");
        result.setCustodian(custodian);

        Patient patient = new Patient();
        patient.setAge(10);
        patient.setDiagnosis("hepatita");
        patient.setDisability(false);
        patient.setFirstName("Georgel");
        patient.setLastName("Popesu");

        result.setPatient(patient);

        Doctor doctor = new Doctor();
        doctor.setFirstName("Doctor");
        doctor.setLastName("Costel");
        result.setDoctor(doctor);


        return result;

    }



    private Reservation getReservation (CreatePatientReservation dto){
        Reservation reservation = new Reservation();
        reservation.setDays(dto.getPeriod());

        Patient patient = new Patient();
        patient.setFirstName(dto.getPacient().getFirstName());
        patient.setLastName(dto.getPacient().getLastName());
        patient.setDiagnosis(dto.getDiagnosis());
        patient.setAge(dto.getPacient().getAge());
        patient.setDisability(dto.isDisability());

        Doctor doctor = new Doctor();

        reservation.setPatient(patient);
        reservation.setDoctor(doctor);

        Custodian custodian = new Custodian();
        custodian.setFirstName(dto.getCustodian().getFirstName());
        custodian.setLastName(dto.getCustodian().getLastName());
        custodian.setTelephone(dto.getCustodian().getTelephone());

        reservation.setCustodian(custodian);
        return reservation;

    }


}
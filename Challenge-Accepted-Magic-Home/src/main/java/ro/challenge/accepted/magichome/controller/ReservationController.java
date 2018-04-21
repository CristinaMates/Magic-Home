package ro.challenge.accepted.magichome.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.challenge.accepted.magichome.domain.Doctor;
import ro.challenge.accepted.magichome.domain.Patient;
import ro.challenge.accepted.magichome.domain.Reservation;
import ro.challenge.accepted.magichome.dto.AcceptRequest;

import ro.challenge.accepted.magichome.dto.CreatePatientReservation;
import ro.challenge.accepted.magichome.service.ReservationService;
import ro.challenge.accepted.magichome.service.SMSService;

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
    public String create(@PathVariable CreatePatientReservation dto) {
        Reservation reservation = getReservation(dto);
        reservationService.createReservation(reservation);
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
    private Reservation getReservation (CreatePatientReservation dto){
        Reservation reservation = new Reservation();
        reservation.setDays(dto.getPeriod());

        Patient patient = new Patient();
        patient.setFirstName(dto.getPacient().getFirstName());
        patient.setPatientLastName(dto.getPacient().getPatientLastName());
        patient.setDiagnosis(dto.getDiagnosis());
        patient.setAge(dto.getPacient().getAge());
        patient.setDisability(dto.isDisability());

        Doctor doctor = new Doctor();

        reservation.setPatient(patient);
        reservation.setDoctor(doctor);
        return reservation;

    }


}

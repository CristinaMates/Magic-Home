package ro.challenge.accepted.magichome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.challenge.accepted.magichome.domain.Doctor;
import ro.challenge.accepted.magichome.domain.Patient;
import ro.challenge.accepted.magichome.domain.Reservation;
import ro.challenge.accepted.magichome.dto.CreatePacientReservation;
import ro.challenge.accepted.magichome.service.ReservationService;
import ro.challenge.accepted.magichome.service.SMSService;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class RestReservationController {
    @Autowired
    private ReservationService reservationService;

    private SMSService smsService;


    @RequestMapping("")
    public List<Reservation> list() {
        return reservationService.getAll();
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String create(@PathVariable CreatePacientReservation dto, Model model) {
        Reservation reservation = getReservation(dto);
        reservationService.createReservation(reservation);
        // /reservationService.createReservation(null);///new Reservation());
        return "OK";
    }


    @RequestMapping(value = "/accept", method = RequestMethod.POST)
    public String acceptReservation(int reservationId, String text) {
       // smsService.sendSms();

        return "OK";
    }


    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    public String rejectReservation(int reservationId, String text) {

        // // smsService.sendSms();

        return "OK";
    }
    private Reservation getReservation (CreatePacientReservation dto){
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

package ro.challenge.accepted.magichome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.challenge.accepted.magichome.domain.Reservation;
import ro.challenge.accepted.magichome.dto.CreatePacientReservation;
import ro.challenge.accepted.magichome.service.ReservationService;
import ro.challenge.accepted.magichome.service.SMSService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class RestPatientController {
    @Autowired
    private ReservationService reservationService;

    private SMSService smsService;


    @RequestMapping("")
    public List<Reservation> list(Model model, HttpServletRequest request) {
        List<Reservation> reservations = reservationService.getAll();
        model.addAttribute("reservations", reservations);
        model.addAttribute("createPatientReservation", new CreatePacientReservation());

        return reservationService.getAll();
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String create(@PathVariable CreatePacientReservation dto) {
        //from dto to reservation
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
}

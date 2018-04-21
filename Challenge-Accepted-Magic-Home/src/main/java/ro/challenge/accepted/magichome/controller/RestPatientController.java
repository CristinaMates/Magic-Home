package ro.challenge.accepted.magichome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.challenge.accepted.magichome.domain.Patient;

import java.util.List;
@RestController
@RequestMapping("/api/reservation")
public class RestPatientController {
        @Autowired
        private ResarvationService resarvationService;



        @RequestMapping("")
        public List<Reservation> list() {
            return reservationService.getAll();
        }


        @RequestMapping(value = "", method = RequestMethod.POST)
        public void create(@PathVariable String model) {
            reservationService.createReservation(model);
        }
}

package ro.challenge.accepted.magichome.service;

import org.springframework.stereotype.Service;
import ro.challenge.accepted.magichome.domain.Custodian;
import ro.challenge.accepted.magichome.domain.Doctor;
import ro.challenge.accepted.magichome.domain.Reservation;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sebi on 4/21/18.
 */
@Service
public class DefaultReservationService implements ReservationService {

    @Override
    public void createReservation(Reservation reservation) {

    }

    @Override
    public List<Reservation> getAll() {
        Reservation r1 = new Reservation();
        r1.setDays(12);
        r1.setCustodian(new Custodian());
        r1.setDoctor(new Doctor());
        r1.setId(1);


        Reservation r2 = new Reservation();
        r2.setDays(13);
        r2.setCustodian(new Custodian());
        r2.setDoctor(new Doctor());
        r2.setId(3);


        return Arrays.asList(new Reservation[]{r1, r2});
    }
}

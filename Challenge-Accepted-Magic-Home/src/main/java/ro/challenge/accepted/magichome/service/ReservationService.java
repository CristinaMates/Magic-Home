package ro.challenge.accepted.magichome.service;

import ro.challenge.accepted.magichome.domain.Reservation;

import java.util.List;

public interface ReservationService {

    void createReservation(Reservation reservation);

    List<Reservation> getAll();


    void updateStatusReservation(long id, boolean accepted);

    Reservation findById(long id);

}

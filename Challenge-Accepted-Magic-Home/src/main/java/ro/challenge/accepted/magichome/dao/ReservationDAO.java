package ro.challenge.accepted.magichome.dao;

import ro.challenge.accepted.magichome.domain.Reservation;

public interface ReservationDAO extends AbstractDAO<Reservation> {
    Reservation findById (long id);

    void update(Reservation reservation);
}

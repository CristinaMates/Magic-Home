package ro.challenge.accepted.magichome.service;


import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.challenge.accepted.magichome.dao.CustodianDAO;
import ro.challenge.accepted.magichome.dao.DoctorDAO;
import ro.challenge.accepted.magichome.dao.PatientDAO;
import ro.challenge.accepted.magichome.dao.ReservationDAO;
import ro.challenge.accepted.magichome.domain.*;

import java.util.List;

/**
 * Created by sebi on 4/21/18.
 */
@Service
@Transactional
public class DefaultReservationService implements ReservationService {

    @Autowired
    private ReservationDAO reservationDAO;

    @Autowired
    private DoctorDAO doctorDAO;

    @Autowired
    private CustodianDAO custodianDAO;

    @Autowired
    private PatientDAO patientDAO;


    @Override
    public void createReservation(Reservation reservation) {

        Doctor doctor = doctorDAO.create(reservation.getDoctor());
        reservation.setDoctor(doctor);

        Patient patient = patientDAO.create(reservation.getPatient());
        patient.setDoctor(doctor);
        reservation.setPatient(patient);

        Custodian custodian = custodianDAO.create(reservation.getCustodian());
        reservation.setCustodian(custodian);

        reservationDAO.create(reservation);

    }

    @Override
    public List<Reservation> getAll() {

        List<Reservation> result = reservationDAO.getAll();

        for (Reservation re: result) {
            solve(re);
        }
        return result;
    }
    private void solve(Reservation reservation) {
        reservation.setDoctor(doctorDAO.findById(reservation.getDoctorID()));
        reservation.setPatient(patientDAO.findById(reservation.getPatientID()));
        reservation.setCustodian(custodianDAO.findById(reservation.getCustodianID()));
    }

    @Override
    public void updateStatusReservation(long id, boolean accepted) {
        Reservation reservation = reservationDAO.findById(id);
        reservation.setStatus(accepted ? Status.ACCEPTED : Status.REJECTED);

    }

    @Override
    public Reservation findById(long id) {
        Reservation r =  reservationDAO.findById(id);
        solve(r);
        return r;
    }
}

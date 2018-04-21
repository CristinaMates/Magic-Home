package ro.challenge.accepted.magichome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.challenge.accepted.magichome.dao.CustodianDAO;
import ro.challenge.accepted.magichome.dao.DoctorDAO;
import ro.challenge.accepted.magichome.dao.PatientDAO;
import ro.challenge.accepted.magichome.dao.ReservationDAO;
import ro.challenge.accepted.magichome.domain.Custodian;
import ro.challenge.accepted.magichome.domain.Doctor;
import ro.challenge.accepted.magichome.domain.Patient;
import ro.challenge.accepted.magichome.domain.Reservation;

import javax.print.Doc;
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
        reservation.setPatient(patient);

        Custodian custodian = custodianDAO.create(reservation.getCustodian());
        reservation.setCustodian(custodian);

        reservationDAO.create(reservation);

    }

    @Override
    public List<Reservation> getAll() {

        List<Reservation> result = reservationDAO.getAll();
        for (Reservation re : result) {
            solve(re);
        }
        return result;
    }

    private void solve(Reservation reservation) {
//        Doctor doctor = new Doctor();
//        reservation.setDoctor(doctorDAO.findById(doctor.getId()));
//        Patient patient = new Patient();
//        reservation.setPatient(custodianDAO.;

    }
}

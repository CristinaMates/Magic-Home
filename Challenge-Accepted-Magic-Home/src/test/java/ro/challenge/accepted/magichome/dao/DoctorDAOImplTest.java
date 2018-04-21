package ro.challenge.accepted.magichome.dao;

import org.junit.Test;
import ro.challenge.accepted.magichome.domain.Doctor;

import java.util.List;

import static org.junit.Assert.*;


public class DoctorDAOImplTest {

    @Test
    public void createOneDoctor() {
        DoctorDAOImpl doctorDAO = new DoctorDAOImpl();

        doctorDAO.create(new Doctor("George", "Popescu", 32L));

        List<Doctor> doctors = doctorDAO.getAll();

        assertEquals(1, doctors.size());
    }

    @Test
    public void updateDoctor() {
        DoctorDAOImpl doctorDAO = new DoctorDAOImpl();

        doctorDAO.create(new Doctor("George", "Popescu", 32L));
        doctorDAO.update(new Doctor("George-Ioan", "Popescu", 32L));

        Doctor updatedDoctor = doctorDAO.getDoctors().get(0);
        assertEquals(updatedDoctor.getFirstName(), "George-Ioan");
    }
}
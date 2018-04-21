package ro.challenge.accepted.magichome.dao;

import org.junit.Test;
import ro.challenge.accepted.magichome.domain.Doctor;

import java.util.Set;

import static org.junit.Assert.*;


public class DoctorDAOImplTest {

    @Test
    public void createOneDoctor() {
        DoctorDAOImpl doctorDAO = new DoctorDAOImpl();

        Doctor doctor = doctorDAO.create(new Doctor("George", "Popescu", 32L));
        Set<Doctor> doctors = doctorDAO.getAll();

        assertEquals(1, doctors.size());
    }
}
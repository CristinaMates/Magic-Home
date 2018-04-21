package ro.challenge.accepted.magichome.dao;

import org.junit.Test;
import ro.challenge.accepted.magichome.domain.Doctor;


import static org.junit.Assert.*;


public class DoctorDAOImplTest {

    @Test
    public void createOneDoctor() {
        DoctorDAOImpl doctorDAO = new DoctorDAOImpl();

        doctorDAO.create(new Doctor("George", "Popescu", 32L));

        assertEquals(1, doctorDAO.getAll().size());
        assertEquals("George", doctorDAO.getAll().get(0).getFirstName());
    }

    @Test
    public void createDuplicateDoctor() {
        DoctorDAOImpl doctorDAO = new DoctorDAOImpl();

        doctorDAO.create(new Doctor("George", "Popescu", 32L));
        doctorDAO.create(new Doctor("George", "Popescu", 32L));

        assertEquals(1, doctorDAO.getAll().size());
    }

    @Test
    public void updateDoctor() {
        DoctorDAOImpl doctorDAO = new DoctorDAOImpl();

        doctorDAO.create(new Doctor("George", "Popescu", 32L));
        doctorDAO.update(new Doctor("George-Ioan", "Popescu", 32L));

        Doctor updatedDoctor = doctorDAO.getAll().get(0);
        assertEquals(updatedDoctor.getFirstName(), "George-Ioan");
    }

    @Test
    public void deleteDoctor() {
        DoctorDAOImpl doctorDAO = new DoctorDAOImpl();

        Doctor doctor = new Doctor("George", "Popescu", 32L);

        doctorDAO.create(doctor);
        doctorDAO.delete(doctor);

        assertEquals(0, doctorDAO.getAll().size());
    }

    @Test
    public void findDoctorByID() {
        DoctorDAOImpl doctorDAO = new DoctorDAOImpl();

        doctorDAO.create(new Doctor("George", "Popescu", 32L));
        doctorDAO.create(new Doctor("Ioan", "Lunca", 46L));
        doctorDAO.create(new Doctor("Mircea", "Tanase", 60L));

        assertEquals("George", doctorDAO.findById(32L));
        assertEquals("Ioan", doctorDAO.findById(46L));
        assertEquals("Mircea", doctorDAO.findById(60L));
    }
}
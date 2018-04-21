package ro.challenge.accepted.magichome.dao;

import ro.challenge.accepted.magichome.domain.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {
    List<Doctor> doctors = new ArrayList<>();

    @Override
    public Doctor create(Doctor doctor) {
        doctors.add(doctor);
        return doctor;
    }

    @Override
    public void update(Doctor doctor) {
        for (Doctor doctor1 : doctors) {
            if (doctor1.getId() == doctor.getId()) {
                doctor1.setFirstName(doctor.getFirstName());
                doctor1.setLastName(doctor.getLastName());
            }
        }
    }

    @Override
    public void delete(Doctor doctor) {
        for (Doctor doctor1 : doctors) {
            if (doctor1.equals(doctor)) {
                doctors.remove(doctor1);
            }
        }
    }

    @Override
    public List<Doctor> getAll() {
        return new ArrayList<>(doctors);
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }
}

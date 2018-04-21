package ro.challenge.accepted.magichome.dao;

import ro.challenge.accepted.magichome.domain.Doctor;

import java.util.HashSet;
import java.util.Set;

public class DoctorDAOImpl implements DoctorDAO {
    Set<Doctor> doctors = new HashSet<>();

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
    public Set<Doctor> getAll() {
        return new HashSet<>(doctors);
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }
}

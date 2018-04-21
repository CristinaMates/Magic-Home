package ro.challenge.accepted.magichome.dao;

import ro.challenge.accepted.magichome.domain.Doctor;

import java.util.Set;

public interface DoctorDAO {
    // takes Doctor from UI and sends it to database
    Doctor create(Doctor doctor);

    void update(Doctor doctor);

    void delete(Doctor doctor);

    Set<Doctor> getAll();
}

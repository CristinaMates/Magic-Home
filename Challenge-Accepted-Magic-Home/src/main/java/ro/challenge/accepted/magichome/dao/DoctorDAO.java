package ro.challenge.accepted.magichome.dao;

import ro.challenge.accepted.magichome.domain.Doctor;

import java.util.List;

public interface DoctorDAO extends AbstractDAO<Doctor>{
    void update(Doctor doctor);

    void delete(Doctor doctor);
}

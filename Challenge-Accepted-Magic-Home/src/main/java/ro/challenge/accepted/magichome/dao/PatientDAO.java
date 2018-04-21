package ro.challenge.accepted.magichome.dao;

import ro.challenge.accepted.magichome.domain.Patient;

import java.util.List;

public interface PatientDAO extends AbstractDAO<Patient> {
    Patient findById(long id);
}

package ro.challenge.accepted.magichome.dao;

import ro.challenge.accepted.magichome.domain.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {
    private List<Doctor> doctors = new ArrayList<>();

    @Override
    public Doctor create(Doctor doctor) {
        for (Doctor doctor1 : doctors) {
            if (doctor1.getId() == doctor.getId()) {
                return null; // duplicate
            }
        }
        doctors.add(doctor);
        return doctor;
    }

  //  @Override
    public void update(Doctor doctor) {
        for (Doctor doctor1 : doctors) {
            if (doctor1.getId() == doctor.getId()) {
                doctor1.setFirstName(doctor.getFirstName());
                doctor1.setLastName(doctor.getLastName());
            }
        }
    }

   // @Override
    public void delete(Doctor doctor) {
        doctors.remove(doctor);
    }

    @Override
    public List<Doctor> getAll() {
        return new ArrayList<>(doctors);
    }

    @Override
    public Doctor findById(long id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null; // not found
    }
}

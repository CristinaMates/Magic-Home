package ro.challenge.accepted.magichome.domain;

public class Doctor {

    private String firstNameDoctor;
    private String lastNameDoctor;
    private long idDoctor;

    public Doctor(String firstNameDoctor, String lastNameDoctor, long idDoctor) {
        this.firstNameDoctor = firstNameDoctor;
        this.lastNameDoctor = lastNameDoctor;
        this.idDoctor = idDoctor;
    }

    public Doctor() {
    }

    public long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(long idDoctor) {
        this.idDoctor = idDoctor;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "firstName='" + firstNameDoctor + '\'' +
                ", lastName='" + lastNameDoctor + '\'' +
                ", idDoctor=" + idDoctor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;

        if (idDoctor != doctor.idDoctor) return false;
        if (firstNameDoctor != null ? !firstNameDoctor.equals(doctor.firstNameDoctor) : doctor.firstNameDoctor != null)
            return false;
        return lastNameDoctor != null ? lastNameDoctor.equals(doctor.lastNameDoctor) : doctor.lastNameDoctor == null;
    }

    @Override
    public int hashCode() {
        int result = firstNameDoctor != null ? firstNameDoctor.hashCode() : 0;
        result = 31 * result + (lastNameDoctor != null ? lastNameDoctor.hashCode() : 0);
        result = 31 * result + (int) (idDoctor ^ (idDoctor >>> 32));
        return result;
    }
}

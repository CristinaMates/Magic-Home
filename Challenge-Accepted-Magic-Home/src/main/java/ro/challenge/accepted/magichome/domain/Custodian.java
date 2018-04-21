package ro.challenge.accepted.magichome.domain;

public class Custodian {
    private String firstNameCustodian;
    private String lastNameCustodian;
    private long telephone;
    private long idCustodian;
    private Pacient pacient;

    public Custodian() {
    }

    public Custodian(String firstNameCustodian, String lastNameCustodian, long telephone, long idCustodian, Pacient pacient) {
        this.firstNameCustodian = firstNameCustodian;
        this.lastNameCustodian = lastNameCustodian;
        this.telephone = telephone;
        this.idCustodian = idCustodian;
        this.pacient = pacient;
    }

    public String getFirstNameCustodian() {
        return firstNameCustodian;
    }

    public void setFirstNameCustodian(String firstNameCustodian) {
        this.firstNameCustodian = firstNameCustodian;
    }

    public String getLastNameCustodian() {
        return lastNameCustodian;
    }

    public void setLastNameCustodian(String lastNameCustodian) {
        this.lastNameCustodian = lastNameCustodian;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public long getIdCustodian() {
        return idCustodian;
    }

    public void setIdCustodian(long idCustodian) {
        this.idCustodian = idCustodian;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Custodian custodian = (Custodian) o;

        if (telephone != custodian.telephone) return false;
        if (idCustodian != custodian.idCustodian) return false;
        if (firstNameCustodian != null ? !firstNameCustodian.equals(custodian.firstNameCustodian) : custodian.firstNameCustodian != null)
            return false;
        if (lastNameCustodian != null ? !lastNameCustodian.equals(custodian.lastNameCustodian) : custodian.lastNameCustodian != null)
            return false;
        return pacient != null ? pacient.equals(custodian.pacient) : custodian.pacient == null;
    }

    @Override
    public int hashCode() {
        int result = firstNameCustodian != null ? firstNameCustodian.hashCode() : 0;
        result = 31 * result + (lastNameCustodian != null ? lastNameCustodian.hashCode() : 0);
        result = 31 * result + (int) (telephone ^ (telephone >>> 32));
        result = 31 * result + (int) (idCustodian ^ (idCustodian >>> 32));
        result = 31 * result + (pacient != null ? pacient.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Custodian{" +
                "firstNameCustodian='" + firstNameCustodian + '\'' +
                ", lastNameCustodian='" + lastNameCustodian + '\'' +
                ", telephone=" + telephone +
                ", idCustodian=" + idCustodian +
                ", pacient=" + pacient +
                '}';
    }
}

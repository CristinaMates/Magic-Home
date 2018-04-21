package ro.challenge.accepted.magichome.domain;

public class Custodian {
    private String firstName;
    private String lastName;
    private long telephone;
    private long id;


    public Custodian() {
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Custodian custodian = (Custodian) o;

        if (telephone != custodian.telephone) return false;
        if (id != custodian.id) return false;
        if (firstName != null ? !firstName.equals(custodian.firstName) : custodian.firstName != null)
            return false;
        return lastName != null ? lastName.equals(custodian.lastName) : custodian.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (int) (telephone ^ (telephone >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }
}

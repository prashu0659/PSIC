public abstract class Person {
    protected int id;
    protected String fullName;
    protected String address;
    protected String telephone;

    protected Person(int id, String fullName, String address, String telephone) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.telephone = telephone;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}

// Concrete subclass for testing
class PersonImpl extends Person {
    public PersonImpl(int id, String fullName, String address, String telephone) {
        super(id, fullName, address, telephone);
    }
}

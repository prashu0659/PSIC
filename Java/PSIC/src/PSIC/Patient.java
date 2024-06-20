import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private List<String> medicalConditions; // List to store medical conditions

    // Constructor
    public Patient(int id, String fullName, String address, String telephone) {
        super(id, fullName, address, telephone);
        this.medicalConditions = new ArrayList<>(); // Initialize the list of medical conditions
        this.fullName = fullName;
        this.id = id;
    }

    // Method to add a medical condition
    public void addMedicalCondition(String condition) {
        medicalConditions.add(condition);
    }

    // Getter for medical conditions
    public List<String> getMedicalConditions() {
        return medicalConditions;
    }

    // Override the toString method to include medical conditions
    @Override
    public String toString() {
        return "Patient{" +
               "id=" + id +
               ", fullName='" + fullName + '\'' +
               ", address='" + address + '\'' +
               ", telephone='" + telephone + '\'' +
               ", medicalConditions=" + medicalConditions +
               '}';
    }
    
}

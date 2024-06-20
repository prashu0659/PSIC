import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Physician extends Person {
    private List<String> expertise;
    private List<DayOfWeek> workingDays;  // Ensure this field is correctly initialized

    public Physician(int id, String fullName, String address, String telephone, List<String> expertise, List<DayOfWeek> workingDays) {
        super(id, fullName, address, telephone);
        this.expertise = expertise;
        this.workingDays = workingDays;
    }

    // Overloaded constructor without working days
    public Physician(int id, String fullName, String address, String telephone, List<String> expertise) {
        super(id, fullName, address, telephone);
        this.expertise = expertise;
        this.workingDays = new ArrayList<>();  // Initialize with empty or default list
    }

    public List<String> getExpertise() {
        return expertise;
    }

    public void setExpertise(List<String> expertise) {
        this.expertise = expertise;
    }

    public List<DayOfWeek> getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(List<DayOfWeek> workingDays) {
        this.workingDays = workingDays;
    }

    public String getName() {
        return this.fullName;  // Assuming 'fullName' is the property storing the name in Person class
    }

}

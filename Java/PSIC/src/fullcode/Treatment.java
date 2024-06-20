import java.util.List;

public class Treatment {
    private String name;
    private Physician responsiblePhysician;
    private Room room;
    private List<String> scheduleTimes; // Times at which the treatment is scheduled
    private List<String> availableTimes; // Available times for booking
    private String expertise; // Area of expertise

    // Constructor to initialize all fields properly
    public Treatment(String name, Physician responsiblePhysician, Room room, List<String> scheduleTimes, List<String> availableTimes, String expertise) {
        this.name = name;
        this.responsiblePhysician = responsiblePhysician;
        this.room = room;
        this.scheduleTimes = scheduleTimes;
        this.availableTimes = availableTimes;
        this.expertise = expertise;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Physician getResponsiblePhysician() {
        return responsiblePhysician;
    }

    public void setResponsiblePhysician(Physician responsiblePhysician) {
        this.responsiblePhysician = responsiblePhysician;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<String> getScheduleTimes() {
        return scheduleTimes;
    }

    public void setScheduleTimes(List<String> scheduleTimes) {
        this.scheduleTimes = scheduleTimes;
    }

    public List<String> getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(List<String> availableTimes) {
        this.availableTimes = availableTimes;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }
}

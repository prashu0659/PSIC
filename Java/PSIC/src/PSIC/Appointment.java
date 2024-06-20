import java.time.LocalDateTime;

public class Appointment {
    private Patient patient;
    private Treatment treatment;
    private LocalDateTime startDateTime;  // Start time of the appointment
    private LocalDateTime endDateTime;    // End time of the appointment
    private Room room;
    private String status;

    // Constructor
    public Appointment(Patient patient, Treatment treatment, LocalDateTime startDateTime, LocalDateTime endDateTime, Room room, String status) {
        this.patient = patient;
        this.treatment = treatment;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.room = room;
        this.status = status;
    }

    // Getters and Setters
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    // Method to get the start date and time of the appointment
    public LocalDateTime getDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{" +
               "patient=" + patient.getFullName() +
               ", treatment=" + treatment.getName() +
               ", startDateTime=" + startDateTime +
               ", endDateTime=" + endDateTime +
               ", room=" + room.getRoomName() +
               ", status='" + status + '\'' +
               '}';
    }
}

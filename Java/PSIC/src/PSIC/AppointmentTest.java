import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentTest {

    private Appointment appointment;
    private Patient patient;
    private Treatment treatment;
    private Room room;

    @BeforeEach
    public void setUp() {
        patient = new Patient(1, "John Doe", "123 Main St", "123456789");
        treatment = new Treatment("Physical Therapy", null, null, null, null, "PT123");
        room = new Room("Room 101", "Consulting Suite");
        LocalDateTime startDateTime = LocalDateTime.of(2024, 6, 17, 10, 0);
        LocalDateTime endDateTime = LocalDateTime.of(2024, 6, 17, 11, 0);
        appointment = new Appointment(patient, treatment, startDateTime, endDateTime, room, "Scheduled");
    }

    @Test
    public void testGetPatient() {
        assertEquals(patient, appointment.getPatient());
    }

    @Test
    public void testSetPatient() {
        Patient newPatient = new Patient(2, "Jane Doe", "456 Elm St", "987654321");
        appointment.setPatient(newPatient);
        assertEquals(newPatient, appointment.getPatient());
    }

    @Test
    public void testGetTreatment() {
        assertEquals(treatment, appointment.getTreatment());
    }

    @Test
    public void testSetTreatment() {
        Treatment newTreatment = new Treatment("Massage Therapy", null, null, null, null, "MT456");
        appointment.setTreatment(newTreatment);
        assertEquals(newTreatment, appointment.getTreatment());
    }

    @Test
    public void testGetDateTime() {
        LocalDateTime startDateTime = LocalDateTime.of(2024, 6, 17, 10, 0);
        assertEquals(startDateTime, appointment.getDateTime());
    }

    @Test
    public void testSetDateTime() {
        LocalDateTime newStartDateTime = LocalDateTime.of(2024, 6, 18, 10, 0);
        appointment.setStartDateTime(newStartDateTime);
        assertEquals(newStartDateTime, appointment.getDateTime());
    }

    @Test
    public void testGetEndDateTime() {
        LocalDateTime endDateTime = LocalDateTime.of(2024, 6, 17, 11, 0);
        assertEquals(endDateTime, appointment.getEndDateTime());
    }

    @Test
    public void testSetEndDateTime() {
        LocalDateTime newEndDateTime = LocalDateTime.of(2024, 6, 18, 11, 0);
        appointment.setEndDateTime(newEndDateTime);
        assertEquals(newEndDateTime, appointment.getEndDateTime());
    }

    @Test
    public void testGetRoom() {
        assertEquals(room, appointment.getRoom());
    }

    @Test
    public void testSetRoom() {
        Room newRoom = new Room("Room 102", "Consulting Suite");
        appointment.setRoom(newRoom);
        assertEquals(newRoom, appointment.getRoom());
    }

    @Test
    public void testGetStatus() {
        assertEquals("Scheduled", appointment.getStatus());
    }

    @Test
    public void testSetStatus() {
        appointment.setStatus("Completed");
        assertEquals("Completed", appointment.getStatus());
    }

    @Test
    public void testToString() {
        String expected = "Appointment{patient=John Doe, treatment=Physical Therapy, startDateTime=2024-06-17T10:00, endDateTime=2024-06-17T11:00, room=Room 101, status='Scheduled'}";
        assertEquals(expected, appointment.toString());
    }
}

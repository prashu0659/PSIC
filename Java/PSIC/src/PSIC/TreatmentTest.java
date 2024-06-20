import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TreatmentTest {

    private Treatment treatment;
    private Physician physician;
    private Room room;

    @BeforeEach
    public void setUp() {
        physician = new Physician(1, "Dr. John Doe", "123 Main St", "555-1234", Arrays.asList("Cardiology", "Neurology"));
        room = new Room("Medical Consulting Suite A", "Consulting Suite");

        List<String> scheduleTimes = Arrays.asList("10:00 AM", "2:00 PM");
        List<String> availableTimes = Arrays.asList("9:00 AM", "11:00 AM", "1:00 PM", "3:00 PM");

        treatment = new Treatment("Cardiac Checkup", physician, room, scheduleTimes, availableTimes, "Cardiology");
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Cardiac Checkup", treatment.getName());
        assertEquals(physician, treatment.getResponsiblePhysician());
        assertEquals(room, treatment.getRoom());
        assertEquals(Arrays.asList("10:00 AM", "2:00 PM"), treatment.getScheduleTimes());
        assertEquals(Arrays.asList("9:00 AM", "11:00 AM", "1:00 PM", "3:00 PM"), treatment.getAvailableTimes());
        assertEquals("Cardiology", treatment.getExpertise());
    }

    @Test
    public void testSetters() {
        Physician newPhysician = new Physician(2, "Dr. Jane Smith", "456 Elm St", "555-5678", Arrays.asList("Orthopedics"));
        Room newRoom = new Room("Surgery Room B", "Operating Room");

        List<String> newScheduleTimes = Arrays.asList("9:00 AM", "1:00 PM");
        List<String> newAvailableTimes = Arrays.asList("8:00 AM", "10:00 AM", "12:00 PM", "2:00 PM");

        treatment.setName("Orthopedic Surgery");
        treatment.setResponsiblePhysician(newPhysician);
        treatment.setRoom(newRoom);
        treatment.setScheduleTimes(newScheduleTimes);
        treatment.setAvailableTimes(newAvailableTimes);
        treatment.setExpertise("Orthopedics");

        assertEquals("Orthopedic Surgery", treatment.getName());
        assertEquals(newPhysician, treatment.getResponsiblePhysician());
        assertEquals(newRoom, treatment.getRoom());
        assertEquals(newScheduleTimes, treatment.getScheduleTimes());
        assertEquals(newAvailableTimes, treatment.getAvailableTimes());
        assertEquals("Orthopedics", treatment.getExpertise());
    }
}

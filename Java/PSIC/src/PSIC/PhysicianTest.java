import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PhysicianTest {

    private Physician physician;

    @BeforeEach
    public void setUp() {
        List<String> expertise = Arrays.asList("Cardiology", "Neurology");
        List<DayOfWeek> workingDays = Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY);
        physician = new Physician(1, "Dr. John Doe", "123 Main St", "555-1234", expertise, workingDays);
    }

    @Test
    public void testConstructorWithWorkingDays() {
        assertEquals(1, physician.getId());
        assertEquals("Dr. John Doe", physician.getFullName());
        assertEquals("123 Main St", physician.getAddress());
        assertEquals("555-1234", physician.getTelephone());

        List<String> expectedExpertise = Arrays.asList("Cardiology", "Neurology");
        assertEquals(expectedExpertise, physician.getExpertise());

        List<DayOfWeek> expectedWorkingDays = Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY);
        assertEquals(expectedWorkingDays, physician.getWorkingDays());
    }

    @Test
    public void testConstructorWithoutWorkingDays() {
        List<String> expertise = Arrays.asList("Orthopedics", "Dermatology");
        physician = new Physician(2, "Dr. Jane Smith", "456 Elm St", "555-5678", expertise);

        assertEquals(2, physician.getId());
        assertEquals("Dr. Jane Smith", physician.getFullName());
        assertEquals("456 Elm St", physician.getAddress());
        assertEquals("555-5678", physician.getTelephone());

        List<String> expectedExpertise = Arrays.asList("Orthopedics", "Dermatology");
        assertEquals(expectedExpertise, physician.getExpertise());

        assertTrue(physician.getWorkingDays().isEmpty());
    }

    @Test
    public void testGetExpertise() {
        List<String> expertise = Arrays.asList("Pediatrics", "Internal Medicine");
        physician.setExpertise(expertise);

        assertEquals(expertise, physician.getExpertise());
    }

    @Test
    public void testSetWorkingDays() {
        List<DayOfWeek> workingDays = Arrays.asList(DayOfWeek.TUESDAY, DayOfWeek.THURSDAY);
        physician.setWorkingDays(workingDays);

        assertEquals(workingDays, physician.getWorkingDays());
    }

    @Test
    public void testGetName() {
        assertEquals("Dr. John Doe", physician.getName());
    }
}
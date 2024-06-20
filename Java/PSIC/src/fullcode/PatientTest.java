import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PatientTest {

    private Patient patient;

    @BeforeEach
    public void setUp() {
        patient = new Patient(1, "John Doe", "123 Main St", "555-1234");
    }

    @Test
    public void testAddMedicalCondition() {
        patient.addMedicalCondition("Diabetes");
        List<String> conditions = patient.getMedicalConditions();
        assertEquals(1, conditions.size());
        assertTrue(conditions.contains("Diabetes"));
    }

    @Test
    public void testGetMedicalConditions() {
        patient.addMedicalCondition("Diabetes");
        patient.addMedicalCondition("Hypertension");
        List<String> conditions = patient.getMedicalConditions();
        assertEquals(2, conditions.size());
        assertTrue(conditions.contains("Diabetes"));
        assertTrue(conditions.contains("Hypertension"));
    }

    @Test
    public void testToString() {
        patient.addMedicalCondition("Diabetes");
        String expected = "Patient{id=1, fullName='John Doe', address='123 Main St', telephone='555-1234', medicalConditions=[Diabetes]}";
        assertEquals(expected, patient.toString());
    }
}

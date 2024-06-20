import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {

    private PersonImpl person;

    @BeforeEach
    public void setUp() {
        person = new PersonImpl(1, "Jane Doe", "456 Elm St", "555-6789");
    }

    @Test
    public void testGetId() {
        assertEquals(1, person.getId());
    }

    @Test
    public void testGetFullName() {
        assertEquals("Jane Doe", person.getFullName());
    }

    @Test
    public void testGetAddress() {
        assertEquals("456 Elm St", person.getAddress());
    }

    @Test
    public void testGetTelephone() {
        assertEquals("555-6789", person.getTelephone());
    }

    @Test
    public void testSetId() {
        person.setId(2);
        assertEquals(2, person.getId());
    }

    @Test
    public void testSetFullName() {
        person.setFullName("John Smith");
        assertEquals("John Smith", person.getFullName());
    }

    @Test
    public void testSetAddress() {
        person.setAddress("789 Maple Ave");
        assertEquals("789 Maple Ave", person.getAddress());
    }

    @Test
    public void testSetTelephone() {
        person.setTelephone("555-9876");
        assertEquals("555-9876", person.getTelephone());
    }
}

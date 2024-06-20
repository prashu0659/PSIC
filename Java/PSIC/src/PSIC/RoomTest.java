import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoomTest {

    private Room room;

    @BeforeEach
    public void setUp() {
        room = new Room("Medical Consulting Suite A", "Consulting Suite");
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Medical Consulting Suite A", room.getRoomName());
        assertEquals("Consulting Suite", room.getRoomType());
    }

    @Test
    public void testSetters() {
        room.setRoomName("Surgery Room B");
        room.setRoomType("Operating Room");

        assertEquals("Surgery Room B", room.getRoomName());
        assertEquals("Operating Room", room.getRoomType());
    }

    @Test
    public void testToString() {
        String expectedToString = "Room{roomName='Medical Consulting Suite A', roomType='Consulting Suite'}";
        assertEquals(expectedToString, room.toString());
    }
}

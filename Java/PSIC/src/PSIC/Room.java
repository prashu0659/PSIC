public class Room {
    private String roomName; // Name of the room, e.g., "201", "204"
    private String roomType; // Type of room, e.g., "Consulting Suite A", "Swimming Pool", "Gym"

    // Constructor to initialize the Room object with both roomName and roomType
    public Room(String roomName, String roomType) {
        this.roomName = roomName;
        this.roomType = roomType;
    }

    // Getter and Setter methods for roomName and roomType
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    // Optional: Override the toString method to return room details in a readable format
    @Override
    public String toString() {
        return "Room{" +
               "roomName='" + roomName + '\'' +
               ", roomType='" + roomType + '\'' +
               '}';
    }
}

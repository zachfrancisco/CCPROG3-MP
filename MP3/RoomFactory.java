package MP3;

public class RoomFactory {
    public static RoomInterface createRoom(String type, String name, Hotel hotel) {
        return switch (type.toLowerCase()) {
            case "Standard" -> new StandardRoom(name, hotel);
            case "Deluxe" -> new DeluxeRoom(name, hotel);
            case "Luxury" -> new LuxuryRoom(name, hotel);
            default -> throw new IllegalArgumentException("Unknown room type: " + type);
        };
    }
}

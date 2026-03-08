package MP3;

/**
 * The Hotel class represents a hotel with a name, rooms, and reservations.
 *
 */
import java.util.*;

public class Hotel {
    private String name;
    private double[] dateRate = new double[31];
    private double basePrice;
    private ArrayList<RoomInterface> rooms = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();

    /**
     * Constructor for the Hotel class
     * 
     * @param name the name of the hotel
     */

    public Hotel(String name) {
        this.name = name;
        this.basePrice = 1299.0;
        for (int i = 0; i < 31; i++) {
            dateRate[i] = 1;
        }
        for (int i = 0; i < 5; i++) {
            this.rooms.add(RoomFactory.createRoom("Standard", "Standard" + (i + 1), this));
        }
        for (int i = 0; i < 5; i++) {
            this.rooms.add(RoomFactory.createRoom("Deluxe", "Deluxe" + (i + 1), this));
        }
        for (int i = 0; i < 5; i++) {
            this.rooms.add(RoomFactory.createRoom("Luxury", "Luxury" + (i + 1), this));
        }
    }

    /**
     * Returns the price of the room
     * 
     * @return the price of the room
     */
    public double getPrice() {
        return basePrice;
    }

    /**
     * Sets the price of the room
     * 
     * @param price the new price of the room
     * @return true if the price was successfully set, false otherwise
     */
    public boolean setPrice(double price) {
        if (price < 100) {
            return false;
        }
        this.basePrice = price;
        return true;
    }

    public double getDateRate(int date) {
        return dateRate[date - 1];
    }

    public void setDateRate(int date, double rate) {
        dateRate[date - 1] = rate;
    }

    public void setDateRateRange(int start, int end, double rate) {
        for (int i = start; i <= end; i++) {
            dateRate[i - 1] = rate;
        }
    }

    public double[] getDateRateList() {
        return dateRate;
    }

    /**
     * Checks if the room name is available
     * 
     * @param name the name to check
     * @return true if the name is available, false otherwise
     */
    public boolean isRoomNameAvailable(String name) {
        for (RoomInterface r : rooms) {
            if (r.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the name of the hotel
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the hotel
     * 
     * @param name       the new name of the hotel
     * @param HotelModel the list of hotels
     * @return true if the name was successfully set, false otherwise
     */
    public boolean setName(String name, HRSModel HotelModel) {
        if (!HotelModel.isNameAvailable(name)) {
            return false;
        }
        this.name = name;
        return true;
    }

    /**
     * Returns the rooms of the hotel
     * 
     * @return
     */
    public ArrayList<RoomInterface> getRooms() {
        return rooms;
    }

    /**
     * Adds a room to the hotel
     * 
     * @param name the name of the room to add
     * @return true if the room was added, false otherwise
     */
    public boolean addRoom(String name, int type) {
        if (rooms.size() == 50) {
            return false;
        }
        if (!isRoomNameAvailable(name)) {
            return false;
        }

        String typeRoom = switch (type) {
            case 1 -> "Standard";
            case 2 -> "Deluxe";
            case 3 -> "Luxury";
            default -> null;
        };

        if (typeRoom != null) {
            rooms.add(RoomFactory.createRoom(typeRoom, name, this));
            return true;
        }
        return false;
    }

    /**
     * Removes a room from the hotel
     * 
     * @param name the name of the room to remove
     * @return true if the room was removed, false otherwise
     */
    public boolean removeRoom(String name) {
        for (RoomInterface r : rooms) {
            if (r.getName().equals(name)) {
                if (!r.getReservations().isEmpty()) {
                    return false;
                }
                rooms.remove(r);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public ArrayList<String> getReservationCodes() {
        ArrayList<String> codes = new ArrayList<>();
        for (Reservation r : reservations) {
            codes.add(r.getCode());
        }
        return codes;
    }

    /**
     * Adds a reservation to the hotel
     * 
     * @param r the reservation to add
     * @return true if the reservation was added, false otherwise
     */
    public boolean addReservation(Reservation r) {
        reservations.add(r);
        return true;
    }

    /**
     * Removes a reservation from the hotel
     * 
     * @param code the code of the reservation to remove
     * @return true if the reservation was removed, false otherwise
     */
    public boolean removeReservation(String code) {
        for (Reservation r : reservations) {
            if (r.getCode().equals(code)) {
                reservations.remove(r);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the estimated earnings of the hotel
     * 
     * @return the estimated earnings of the hotel
     */
    public double getEarnings() {
        double total = 0;
        for (Reservation r : reservations) {
            total += r.calculateTotal();
        }
        return total;
    }

    /**
     * Returns the available rooms of the hotel
     * 
     * @param checkIn  the check-in date
     * @param checkOut the check-out date
     * @return the available rooms of the hotel
     */
    public ArrayList<RoomInterface> getAvailableRooms(int checkIn, int checkOut) {
        ArrayList<RoomInterface> availableRooms = new ArrayList<>();
        for (RoomInterface r : rooms) {
            boolean available = true;
            for (Reservation res : r.getReservations()) {
                if (checkIn < res.getCheckOut() && checkOut > res.getCheckIn()) {
                    available = false;
                    break;
                }
            }
            if (available) {
                availableRooms.add(r);
            }
        }
        return availableRooms;
    }

    public ArrayList<String> getAvailableRoomsStrings(int checkIn, int checkOut) {
        ArrayList<String> availableRooms = new ArrayList<>();
        for (RoomInterface r : rooms) {
            boolean available = true;
            for (Reservation res : r.getReservations()) {
                if (checkIn < res.getCheckOut() && checkOut > res.getCheckIn()) {
                    available = false;
                    break;
                }
            }
            if (available) {
                availableRooms.add(r.getName());
            }
        }
        return availableRooms;
    }

    /**
     * Finds a room by name
     * 
     * @param roomName
     * @return
     */
    public RoomInterface findRoom(String roomName) {
        for (RoomInterface r : rooms) {
            if (r.getName().equals(roomName)) {
                return r;
            }
        }
        return null;
    }

    /**
     * Finds a reservation by code
     * 
     * @param code
     * @return
     */
    public Reservation findReservation(String code) {
        for (Reservation r : reservations) {
            if (r.getCode().equals(code)) {
                return r;
            }
        }
        return null;
    }

    public ArrayList<String> getRoomNames() {
        ArrayList<String> names = new ArrayList<>();
        for (RoomInterface r : rooms) {
            names.add(r.getName());
        }
        return names;
    }

}
package MP3;

/**
 * HotelList class
 *
 * This class is responsible for managing the list of hotels.
 * It provides methods to create, remove, and find hotels.
 * It also provides methods to add and remove reservations.
 *
 */
import java.util.*;

public class HRSModel {
    private ArrayList<Hotel> hotels = new ArrayList<>();

    public HRSModel() {
    }

    /**
     * Checks if the name is available
     * @param name the name to check
     * @return true if the name is available, false otherwise
     */
    public boolean isNameAvailable(String name) {
        for (Hotel h : hotels) {
            if (h.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Creates a hotel
     * @param name the name of the hotel
     * @return true if the hotel was successfully created, false otherwise
     */
    public boolean createHotel(String name) {
        if (!isNameAvailable(name)) {
            return false;
        }
        hotels.add(new Hotel(name));
        return true;
    }

    /**
     * Removes a hotel
     * @param name the name of the hotel to remove
     * @return true if the hotel was successfully removed, false otherwise
     */
    public boolean removeHotel(String name) {
        for (Hotel h : hotels) {
            if (h.getName().equals(name)) {
                hotels.remove(h);
                return true;
            }
        }
        return false;
    }

    /**
     * Finds a hotel
     * @param name the name of the hotel to find
     * @return the hotel if found, null otherwise
     */
    public Hotel findHotel(String name) {
        for (Hotel h : hotels) {
            if (h.getName().equals(name)) {
                return h;
            }
        }
        return null;
    }

    /**
     * Returns the list of hotels
     * @return the list of hotels
     */
    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public ArrayList<String> getHotelNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Hotel h : hotels) {
            names.add(h.getName());
        }
        return names;
    }   

    /**
     * Adds a reservation
     * @param hotelName the name of the hotel
     * @param roomName the name of the room
     * @param guest the guest
     * @param checkIn the check-in date
     * @param checkOut the check-out date
     * @return true if the reservation was added, false otherwise
     */
    public boolean addReservation(String hotelName, String roomName, String name, int checkIn, int checkOut) {
        if (checkIn <= 0 || checkOut <= 0 || checkIn >= checkOut || checkOut > 31) {
            return false;
        }
        Hotel hotel = findHotel(hotelName);
        if (hotel == null) {
            return false;
        }
        RoomInterface room = hotel.findRoom(roomName);
        if (room == null) {
            return false;
        }
        if (!room.isAvailable(checkIn, checkOut)) {
            return false;
        }
        // Create the reservation once and add it to both hotel and room
        Reservation reservation = new Reservation(name, hotel, room, checkIn, checkOut);
        hotel.addReservation(reservation);
        room.addReservation(reservation);
        return true;
    }

    public boolean addReservation(Reservation reservation)
    {
        Hotel hotel = reservation.getHotel();
        RoomInterface room = reservation.getRoom();
        if (!room.isAvailable(reservation.getCheckIn(), reservation.getCheckOut())) {
            return false;
        }
        hotel.addReservation(reservation);
        room.addReservation(reservation);
        return true;
    }

    /**
     * Removes a reservation
     * @param code the code of the reservation to remove
     * @return true if the reservation was removed, false otherwise
     */
    public boolean removeReservation(String code) {
        for (Hotel h : hotels) {
            Reservation reservation = h.findReservation(code);
            if (reservation != null) {
                String roomName = reservation.getRoom().getName();
                h.removeReservation(code);
                h.findRoom(roomName).removeReservation(code);
                return true;
            }
        }
        return false;
    }
}
package Original;

import java.util.ArrayList;

/**
 * Room class for the Hotel Reservation System
 */
public class Room {
    private String name;
    private ArrayList<Reservation> rsrvtn = new ArrayList<>();
    private String type;
    private Hotel hotel;

    /**
     * Constructor for the Room class
     * @param name the name of the room
     * @param type the type of the room (1=Standard, 2=Deluxe, 3=Executive)
     */
    public Room(String name, int type, Hotel hotel) {
        this.name = name;
        this.hotel = hotel;
        switch (type) {
            case 1:
                this.type = "Standard";
                break;
            case 2:
                this.type = "Deluxe";
                break;
            case 3:
                this.type = "Executive";
                break;
            default:
                break;
        }

    }
    /**
     * Adds a reservation to the room
     * @param r the reservation to add
     * @return true if the reservation was added, false otherwise
     */
    public boolean addReservation(Reservation r) {
        rsrvtn.add(r);
        return true;
    }

    /**
     * Removes a reservation from the room
     * @param code the code of the reservation to remove
     * @return true if the reservation was removed, false otherwise
     */
    public boolean removeReservation(String code) {
        for (Reservation r : this.rsrvtn) {
            if (r.getCode().equals(code)) {
                rsrvtn.remove(r);
                return true;
            }
        }
        return false;
    }

    public double getPrice() {
        return switch (type) {
            case "Standard" -> hotel.getPrice() * 1.0;
            case "Deluxe" -> hotel.getPrice() * 1.2;
            case "Executive" -> hotel.getPrice() * 1.35;
            default -> hotel.getPrice();
        };
    }

    /**
     * Returns the name of the room
     * @return the name of the room
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the room
     * @param name the new name of the room
     * @return true if the name was successfully set, false otherwise
     */
    public boolean setName(String name) {
        this.name = name.trim();
        return true;
    }

    /**
     * Returns the reservations of the room
     * @return the reservations of the room
     */
    public ArrayList<Reservation> getReservations() {
        return rsrvtn;
    }

    /**
     * Checks if the room is available for the given dates
     * @param checkIn the check-in date
     * @param checkOut the check-out date
     * @return true if the room is available, false otherwise
     */
    public boolean isAvailable(int checkIn, int checkOut) {
        for (Reservation r : rsrvtn) {
            if (checkIn < r.getCheckOut() && checkOut > r.getCheckIn()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the available dates of the room
     * @return the available dates of the room
     */
    public ArrayList<Integer> getAvailableDates() {
        ArrayList<Integer> availableDates = new ArrayList<>();
        availableDates.clear();
        for (int i = 1; i <= 31; i++) {
            if (isAvailable(i, i + 1)) {
                availableDates.add(i);
            }
        }
        return availableDates;
    }

    public ArrayList<String> getAvailableDatesString() {
        ArrayList<String> availableDates = new ArrayList<>();
        availableDates.clear();
        for (int i = 1; i <= 31; i++) {
            if (isAvailable(i, i + 1)) {
                availableDates.add(i + "/" + (i + 1));
            }
        }
        return availableDates;
    }

    public Hotel getHotel() {
        return hotel;
    }

}
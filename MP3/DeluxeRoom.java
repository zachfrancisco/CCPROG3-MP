package MP3;

import java.util.*;

/**
 * DeluxeRoom class — implements RoomInterface.
 * Price multiplier: 1.2x the hotel base price.
 */
public class DeluxeRoom implements RoomInterface {
    private final ArrayList<Reservation> rsrvtn = new ArrayList<>();
    private String name;
    private final Hotel hotel;

    private static final double PRICE_MULTIPLIER = 1.2;

    public DeluxeRoom(String name, Hotel hotel) {
        this.name = name;
        this.hotel = hotel;
    }

    @Override
    public boolean addReservation(Reservation r) {
        rsrvtn.add(r);
        return true;
    }

    @Override
    public boolean removeReservation(String code) {
        for (Reservation r : rsrvtn) {
            if (r.getCode().equals(code)) {
                rsrvtn.remove(r);
                return true;
            }
        }
        return false;
    }

    @Override
    public double getPrice() {
        return hotel.getPrice() * PRICE_MULTIPLIER;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean setName(String name) {
        this.name = name.trim();
        return true;
    }

    @Override
    public ArrayList<Reservation> getReservations() {
        return rsrvtn;
    }

    @Override
    public boolean isAvailable(int checkIn, int checkOut) {
        for (Reservation r : rsrvtn) {
            if (checkIn < r.getCheckOut() && checkOut > r.getCheckIn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ArrayList<Integer> getAvailableDates() {
        ArrayList<Integer> dates = new ArrayList<>();
        for (int i = 1; i <= 31; i++) {
            if (isAvailable(i, i + 1)) dates.add(i);
        }
        return dates;
    }

    @Override
    public ArrayList<String> getAvailableDatesString() {
        ArrayList<String> dates = new ArrayList<>();
        for (int i = 1; i <= 31; i++) {
            if (isAvailable(i, i + 1)) dates.add(i + "/" + (i + 1));
        }
        return dates;
    }

    @Override
    public Hotel getHotel() {
        return hotel;
    }
}

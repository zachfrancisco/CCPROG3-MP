package MP3;

import java.util.*;

public abstract class BaseRoom implements RoomInterface {
    protected final ArrayList<Reservation> rsrvtn = new ArrayList<>();
    protected String name;
    protected final Hotel hotel;

    public BaseRoom(String name, Hotel hotel) {
        this.name = name;
        this.hotel = hotel;
    }

    protected abstract double getPriceMultiplier();

    @Override
    public double getPrice() {
        return hotel.getPrice() * getPriceMultiplier();
    }

    // Shared logic for adding and removing reservations, checking availability, etc.
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

    @Override public String getName() { return name; }
    @Override public boolean setName(String name) { this.name = name.trim(); return true; }
    @Override public ArrayList<Reservation> getReservations() { return rsrvtn; }
    @Override public Hotel getHotel() { return hotel; }

    @Override
    public boolean isAvailable(int checkIn, int checkOut) {
        for (Reservation r : rsrvtn) {
            if (checkIn < r.getCheckOut() && checkOut > r.getCheckIn()) return false;
        }
        return true;
    }

    @Override
    public ArrayList<Integer> getAvailableDates() {
        ArrayList<Integer> dates = new ArrayList<>();
        for (int i = 1; i <= 31; i++) if (isAvailable(i, i + 1)) dates.add(i);
        return dates;
    }

    @Override
    public ArrayList<String> getAvailableDatesString() {
        ArrayList<String> dates = new ArrayList<>();
        for (int i = 1; i <= 31; i++) if (isAvailable(i, i + 1)) dates.add(i + "/" + (i + 1));
        return dates;
    }
}
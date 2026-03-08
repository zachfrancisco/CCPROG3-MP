package MP3;

import java.util.*;

/**
 * Room interface for the Hotel Reservation System
 */
public interface RoomInterface {

    boolean addReservation(Reservation r);

    boolean removeReservation(String code);

    double getPrice();

    String getName();

    boolean setName(String name);

    ArrayList<Reservation> getReservations();

    boolean isAvailable(int checkIn, int checkOut);

    ArrayList<Integer> getAvailableDates();

    ArrayList<String> getAvailableDatesString();

    Hotel getHotel();
}
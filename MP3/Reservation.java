package MP3;

/**
 * Reservation Class
 *
 */
public class Reservation {
    private final String code;
    private String guestName;
    private Hotel hotel;
    private RoomInterface room;
    private int checkIn;
    private int checkOut;
    private double discountRate;
    private boolean freeday;

    /**
     * Constructor for the Reservation class
     * @param guest
     * @param hotel
     * @param room
     * @param checkIn
     * @param checkOut
     */
    public Reservation(String guestName, Hotel hotel, RoomInterface room, int checkIn, int checkOut) {
        this.freeday = false;
        this.guestName = guestName;
        this.code = "RS" + hotel.getReservations().size();
        this.hotel = hotel;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    /**
     * Returns the total cost of the reservation
     * @return
     */
    public double calculateTotalDateRate() {
        double total = 0;
    
        int startDay;

        if (freeday == true) {
            startDay = checkIn + 1;
        } else {
            startDay = checkIn;
        }

        for (int i = startDay; i < checkOut; i++) {
            total += room.getPrice() * hotel.getDateRate(i);
        }
        return total;
    }

    public double calculateTotal() {
        return calculateTotalDateRate() * (1 - discountRate);
    }



    static public boolean isValidDiscountCode(String code) {
        return code.equals("I_WORK_HERE") || code.equals("STAY4_GET1") || code.equals("PAYDAY");
    }

    public boolean applyDiscountCode(String code) {
        if (!isValidDiscountCode(code)) {
            return false;
        }

        int stayDuration = checkOut - checkIn;

        switch (code) {
            case "I_WORK_HERE":
                discountRate = 0.10;
                return true;
            case "STAY4_GET1":
                if (stayDuration >= 5) {
                    freeday = true;
                    return true;
                }
                break;
            case "PAYDAY":
                if ((checkIn <= 15 && checkOut > 15) || (checkIn <= 30 && checkOut > 30)) {
                    discountRate = 0.07;
                    return true;
                }
                break;
        }
        return false;
    }
    /**
     * Returns the hotel of the reservation
     * @return
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Sets the hotel of the reservation
     * @param hotel
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * Returns the room of the reservation
     * @return
     */
    public RoomInterface getRoom() {
        return room;
    }

    /**
     * Sets the room of the reservation
     * @param room
     */
    public void setRoom(RoomInterface room) {
        this.room = room;
    }

    /**
     * Returns the check in date of the reservation
     * @return
     */
    public int getCheckIn() {
        return checkIn;
    }

    /**
     * Sets the check in date of the reservation
     * @param checkIn
     */
    public void setCheckIn(int checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * Returns the check out date of the reservation
     * @return
     */
    public int getCheckOut() {
        return checkOut;
    }

    /**
     * Sets the check out date of the reservation
     * @param checkOut
     */
    public void setCheckOut(int checkOut) {
        this.checkOut = checkOut;
    }


    /**
     * Returns the code of the reservation
     * @return
     */
    public String getCode() {
        return code;
    }

    public String getGuestName() {
        return guestName;
    }
}
package Original;

import java.util.ArrayList;

public class Controller {
    private hrsView hrsView;
    private CreateHotelView createHotelView;
    private ViewHotelView viewHotelView;
    private ManageHotelView manageHotelView;
    private BookRoomView bookRoomView;
    private HRSModel hrsModel;

    public Controller() {
        hrsView = new hrsView();
        createHotelView = new CreateHotelView();
        viewHotelView = new ViewHotelView();
        manageHotelView = new ManageHotelView();
        bookRoomView = new BookRoomView();
        hrsModel = new HRSModel();

    }

    public void mainDisplay() {
        hrsView.displayHRSView();
        hrsView.getCreateButton().addActionListener(e -> {
            createHotel();

        });

        hrsView.getViewButton().addActionListener(e -> {

            viewHotel();
        });
        hrsView.getManageButton().addActionListener(e -> {
            manageHotel();
        });
        hrsView.getBookButton().addActionListener(e -> {
            bookRoom();
        });

    }
    
    public void createHotel() {
        createHotelView.displayCreateView();
        String createHotel = createHotelView.getHotelNameField().getText();

        if (hrsModel.isNameAvailable(createHotel) && createHotel.trim().isEmpty() == false && createHotelView.getIsClose() == false) {
            hrsModel.createHotel(createHotel);
            hrsView.successfulMessage(createHotel + " has been created");

            double earn = hrsModel.findHotel(createHotel).getEarnings();

        } else if (!hrsModel.isNameAvailable(createHotel)) {
            hrsView.displayErrorMessage("Hotel name already exists");
        }
        else
        {
           
        }

    }

    public void viewHotel() {
        boolean isContinuing = true;
        ArrayList<String> rooms = new ArrayList<>();
        hrsView.displayHotelList(hrsModel.getHotelNames());
        String hotelName = viewHotelView.askHotelName();
        if(hrsModel.findHotel(hotelName) == null){
            hrsView.displayErrorMessage("Hotel does not exist");
            isContinuing = false;
        }

        
        if (isContinuing) {
            int nRooms = hrsModel.findHotel(hotelName).getRooms().size();
            int nReservation = hrsModel.findHotel(hotelName).getReservations().size();
            double earnings = hrsModel.findHotel(hotelName).getEarnings();
            viewHotelView.displayMenu();
            int options = viewHotelView.getOptions();
            switch (options) {
                case 1 -> {
                    viewHotelView.displayHighLevel(hotelName, earnings, nRooms, nReservation);
                }
                case 2 -> {
                    viewHotelView.displayLowLevel();
                    int checkIn = 0;
                    int checkOut = 0;
                    int lowLevelOption = viewHotelView.getLowLevelOption();
                    switch (lowLevelOption) {
                        case 1 -> {
                            viewHotelView.askRoomDates();
                            String scheckIn = viewHotelView.getCheckIn();
                            String scheckOut = viewHotelView.getCheckOut();
                            try {
                                checkIn = Integer.parseInt(scheckIn);
                                checkOut = Integer.parseInt(scheckOut);
                            } catch (NumberFormatException e) {
                                hrsView.displayErrorMessage("Invalid input");
                                isContinuing = false;
                            }


                            if (checkIn != 0 && checkOut != 0) {
                                //Edited

                                ArrayList<String> availableRooms = hrsModel.findHotel(hotelName).getAvailableRoomsStrings(checkIn, checkOut);
                                viewHotelView.displayRoomList(availableRooms);
                            }
                        }
                        case 2 -> {
                            viewHotelView.displayRoomList(hrsModel.findHotel(hotelName).getRoomNames());
                            viewHotelView.askRoomName();
                            String roomName = viewHotelView.getRoomName();
                            if (hrsModel.findHotel(hotelName).findRoom(roomName) != null && viewHotelView.isClose() == false) {
                                double price = hrsModel.findHotel(hotelName).findRoom(roomName).getPrice();
                                ArrayList<Integer> dates = hrsModel.findHotel(hotelName).findRoom(roomName).getAvailableDates();
                                viewHotelView.displayRoomInfo(roomName, price, dates);
                            }
                            else if (hrsModel.findHotel(hotelName).findRoom(roomName) == null){
                                hrsView.displayErrorMessage("Room does not exist");
                            }
                            else if(viewHotelView.isClose()){
                            }
                            else{
                                hrsView.displayErrorMessage("Invalid input");
                            }
                        }
                        case 3 -> {
                            ArrayList<String> reservations = hrsModel.findHotel(hotelName).getReservationCodes();
                            viewHotelView.displayReservationList(reservations);
                            viewHotelView.askReservation();
                            String reservation = viewHotelView.getReservation();
                            if (hrsModel.findHotel(hotelName).findReservation(reservation) != null) {
                                String guestName = hrsModel.findHotel(hotelName).findReservation(reservation).getGuestName();
                                String roomName = hrsModel.findHotel(hotelName).findReservation(reservation).getRoom().getName();
                                int checkIn1 = hrsModel.findHotel(hotelName).findReservation(reservation).getCheckIn();
                                int checkOut1 = hrsModel.findHotel(hotelName).findReservation(reservation).getCheckOut();
                                double price = hrsModel.findHotel(hotelName).getPrice();
                                double total = hrsModel.findHotel(hotelName).findReservation(reservation).calculateTotal();
                                viewHotelView.displayReservation(guestName, roomName, price, checkIn1, checkOut1, total);
                            }
                            else{
                                hrsView.displayErrorMessage("Reservation does not exist");
                            }
                        }
                    }
                }
            }
        }
    }

    public void manageHotel(){
        boolean isContinuing = true;
        manageHotelView.askHotelName();
        String hotelName = manageHotelView.getHotelName();
        if(hrsModel.findHotel(hotelName) == null){
            hrsView.displayErrorMessage("Hotel does not exist");
            isContinuing = false;
        }
    

        if(isContinuing)
        {
            manageHotelView.displayManageHotelView();
            int options = manageHotelView.getOptions();
            switch (options)
            { 
                case 1->{
                    String newHotelName = manageHotelView.changeName();
                    if(hrsModel.isNameAvailable(newHotelName) && manageHotelView.isClose() == false)
                    {
                        hrsModel.findHotel(hotelName).setName(newHotelName, hrsModel);
                        hrsView.successfulMessage("Hotel name has been updated");
                    }
                    else{
                        hrsView.displayErrorMessage("Hotel name already exists");
                    }
                }
                case 2->{
                    String addRoomName = manageHotelView.addRoom();
                    int addRoomOptions = manageHotelView.getAddRoomOptions();
                    if(addRoomOptions > 0 && addRoomOptions < 4 && hrsModel.findHotel(hotelName).findRoom(addRoomName) == null && addRoomName.trim().isEmpty() == false)
                    {
                        hrsModel.findHotel(hotelName).addRoom(addRoomName, addRoomOptions);
                        hrsView.successfulMessage("Room has been added");
                    }
                    else{
                        hrsView.displayErrorMessage("Room name not available");
                    }
                }
                case 3->{
                    boolean isContinuing3 = true;
                    String removeRoomName = manageHotelView.removeRoom();
                    if(hrsModel.findHotel(hotelName).findRoom(removeRoomName) == null)
                    {
                        hrsView.displayErrorMessage("Room does not exist");
                        isContinuing3 = false;
                    }
                
                    if(hrsModel.findHotel(hotelName).findRoom(removeRoomName).getReservations().isEmpty() && isContinuing3) 
                    {
                        hrsModel.findHotel(hotelName).removeRoom(removeRoomName);
                        hrsView.successfulMessage("Room has been removed");
                    }
                    else{
                        hrsView.displayErrorMessage("Hotel has reservations");
                    }
                }
                case 4->{
                    String roomName = manageHotelView.changeRoomPrice();
                    double newPrice = manageHotelView.getNewPrice();
                    if(newPrice < 100){
                        hrsView.displayErrorMessage("Invalid price");
                    }
                    else if (hrsModel.findHotel(hotelName).getReservations().isEmpty()){
                    hrsModel.findHotel(hotelName).setPrice(newPrice);
                    hrsView.successfulMessage("Price has been updated");
                    }
                    else{
                        hrsView.displayErrorMessage("Hotel has reservations");
                    }
                }
                case 5->{
                    String reservationCode = manageHotelView.removeReservation();
                    if(hrsModel.findHotel(hotelName).findReservation(reservationCode) != null)
                    {
                        hrsModel.findHotel(hotelName).removeReservation(reservationCode);
                        hrsView.successfulMessage("Reservation has been removed");
                    }
                    else{
                        hrsView.displayErrorMessage("Reservation does not exist");
                    }
                }
                case 6->{
                    String removeHotelName = manageHotelView.removeHotel();
                    if(hrsModel.findHotel(removeHotelName) != null)
                    {
                        hrsModel.removeHotel(removeHotelName);
                        hrsView.successfulMessage("Hotel has been removed");
                    }
                    else{
                        hrsView.displayErrorMessage("Hotel does not exist");
                    }
                }
                case 7->{
                    boolean isContinuing2 = true;
                    int start = 0;
                    int end = 0;
                    double newRate = 0;
                    double[] newRates = hrsModel.findHotel(hotelName).getDateRateList();
                    manageHotelView.displayPriceRateList(newRates);
                    manageHotelView.promptmodifyDatePrice();
                    String sStart = manageHotelView.getStartNewPrice(); 
                    String sEnd = manageHotelView.getEndNewPrice();
                    String sNewRate = manageHotelView.getNewPriceRate();

                    try {
                        start = Integer.parseInt(sStart);
                        end = Integer.parseInt(sEnd);
                        newRate = Double.parseDouble(sNewRate);
                    
                    } catch (Exception e) {
                        isContinuing2 = false;
                        hrsView.displayErrorMessage("Invalid input");
                    }
                    if(start > 0 && end < 32 && start < end && newRate > 0 && isContinuing2){
                        hrsModel.findHotel(hotelName).setDateRateRange(start, end, newRate);
                        hrsView.successfulMessage("Price rates have been updated");
                    }
                    else if(manageHotelView.isClose()){

                    }
                    
                }

            }
        }
    }

    public void bookRoom() {
        boolean isContinuing = true;
        String hotelname = bookRoomView.askHotelName();
        ArrayList<String> rooms;
        String roomName;
        if (hrsModel.findHotel(hotelname) == null) {
            hrsView.displayErrorMessage("Hotel does not exist");
            isContinuing = false;
        }
        else{
            rooms = hrsModel.findHotel(hotelname).getRoomNames();
        }
        if (isContinuing) {
            int[] bookingDates = bookRoomView.askRoomDates();

            if (bookingDates[0] > bookingDates[1] || bookingDates[0] < 1 || bookingDates[1] > 31
                    || bookingDates[0] == bookingDates[1]) {
                hrsView.displayErrorMessage("Invalid Dates");
                isContinuing = false;
            }

            // Arraylist of available rooms
            ArrayList<String> availableRooms = hrsModel.findHotel(hotelname).getAvailableRoomsStrings(bookingDates[0],
                    bookingDates[1]);
            
            if (isContinuing) {
                
                bookRoomView.displayRoomList(availableRooms);
                roomName = bookRoomView.askRoomName();
                
                if (hrsModel.findHotel(hotelname).findRoom(roomName) == null) {
                    hrsView.displayErrorMessage("Room does not exist");
                    isContinuing = false;
                } else if (!hrsModel.findHotel(hotelname).findRoom(roomName).isAvailable(bookingDates[0], bookingDates[1])) {
                    hrsView.displayErrorMessage("Room is not available");
                    isContinuing = false;
                }

                if (isContinuing) {
                    String guestName = bookRoomView.askGuestName();
                    if (guestName != null) {
                        Reservation reservation = new Reservation(guestName, hrsModel.findHotel(hotelname), hrsModel.findHotel(hotelname).findRoom(roomName), bookingDates[0], bookingDates[1]);
                        String discountCode = bookRoomView.askDiscountCode();
                        if(bookRoomView.isClose()){
                            isContinuing = false;
                        }
                        else{
                            if (Reservation.isValidDiscountCode(discountCode) && isContinuing) {
                                reservation.applyDiscountCode(discountCode);
                                hrsModel.addReservation(reservation);
                                hrsView.successfulMessage("Valid discount code\nRoom has been booked");
                            } else {
                                hrsModel.addReservation(reservation);
                                hrsView.displayErrorMessage("Invalid discount code\nRoom Booked");
                            }
                        }

                    }
                }
            }
        }
    }
}

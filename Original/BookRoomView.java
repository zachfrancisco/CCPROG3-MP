package Original;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * The type Book room view.
 */
public class BookRoomView extends JFrame {
    private JTextField guestName;
    private JTextField roomName;
    private JTextField checkInDate;
    private JTextField checkOutDate;
    private JTextField discountCode;
    private JButton roomButton;
    private JButton bookRoomButton;
    private String title;
    private JTextField hotelNameField;
    private JButton hotelButton;
    private JButton checkDate;
    private boolean isClose;

    /**
     * Instantiates a new Book room view.
     */
    public BookRoomView() {
        guestName = new JTextField(20);
        roomName = new JTextField(20);
        checkInDate = new JTextField(20);
        checkOutDate = new JTextField(20);
        discountCode = new JTextField(20);
        hotelNameField = new JTextField(20);
        bookRoomButton = new JButton("Book Room");
        hotelButton = new JButton("Find Hotel");
        roomButton = new JButton("Find Room");
        roomButton = new JButton("Check Dates");
        title = "Book Room";
    }

    /**
     * Ask hotel name.
     * @return the string
     */
    public String askHotelName() {
        isClose = false;
        final String[] hotelName = new String[1]; // Array to hold the value from the dialog

        JDialog dialog = new JDialog(this, "Enter Hotel Name", true);
        dialog.setSize(400, 200);
        dialog.setLayout(new GridLayout(2, 2));

        dialog.add(new JLabel("Hotel Name:"));
        dialog.add(hotelNameField);
        JButton submitButton = new JButton("Submit");
        dialog.add(new JPanel());
        dialog.add(submitButton);
       

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hotelName[0] = hotelNameField.getText(); // Capture the text
                dispose(); // Close the dialog
              }
        });

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                isClose = true;
            }
        });
        dialog.setVisible(true); // Block until dialog is disposed

        return hotelName[0]; // Return the captured text
    }
    /**
     * Ask room dates int [ ].
     * @return the dates
     */
    public int[] askRoomDates(){

        final int[] roomDates = new int[2];
          JDialog dialog = new JDialog(this, "Enter Room Dates", true);
        dialog.setSize(400, 200);
        dialog.setLayout(new GridLayout(3, 2));
        
        JTextField checkInField = new JTextField();
        JTextField checkOutField = new JTextField();
        JButton submitButton = new JButton("Submit");

        dialog.add(new JLabel("Check In Date:"));
        dialog.add(checkInField);
        dialog.add(new JLabel("Check Out Date:"));
        dialog.add(checkOutField);
        dialog.add(new JPanel());
        dialog.add(submitButton);
        
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    try {
                        roomDates[0] = Integer.parseInt(checkInField.getText());
                        roomDates[1] = Integer.parseInt(checkOutField.getText());
                    } catch (NumberFormatException ex) {
                        roomDates[0] = 0;
                        roomDates[1] = 0;
                    }
                    // Parse dates from text fields; assuming dates are provided as integers
               
                dialog.dispose(); // Close the dialog
            }
        });

        dialog.setVisible(true); // Block until the dialog is disposed

        return roomDates;
    }
    /**
     * Display book room view.
     * @return the guest name
     */
    public String askGuestName() // display the options for booking a room
    {
        isClose = false;
        // Step 2: Implement the User Interface
        JDialog dialog = new JDialog(this, title, true); // Use 'this' to make it modal to the MainView window
        dialog.setLayout(new GridLayout(2, 2));
        dialog.setSize(300, 200); // Set size or pack() after adding components
    
        String[] guestName = new String[1]; // Array to hold the value from the dialog
        dialog.add(new JLabel("Guest Name:"));
        JTextField guestNameField = new JTextField();
        dialog.add(guestNameField);
        dialog.add(new JPanel());
        dialog.add(bookRoomButton);
    
        bookRoomButton.addActionListener(e -> {
            guestName[0] = guestNameField.getText(); // Capture the text
            dialog.dispose(); // Close the dialog
        });

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                isClose = true;
            }
        });

        // Display the dialog
        dialog.setVisible(true);
        
        return guestName[0]; // Return the captured text
    }
    /**
     * Ask discount code string.
     */
    public String askDiscountCode()
    {
        isClose = false;
        // Step 2: Implement the User Interface
        JDialog dialog = new JDialog(this, title, true); // Use 'this' to make it modal to the MainView window
        dialog.setLayout(new GridLayout(2, 2));
        dialog.setSize(300, 200); // Set size or pack() after adding components
    
        String[] discountCode = new String[1]; // Array to hold the value from the dialog
        dialog.add(new JLabel("Discount Code:"));
        JTextField discountCodeField = new JTextField();
        dialog.add(discountCodeField);
        dialog.add(new JPanel());
        dialog.add(bookRoomButton);
    
        bookRoomButton.addActionListener(e -> {
            discountCode[0] = discountCodeField.getText(); // Capture the text
            dialog.dispose(); // Close the dialog
        });
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                isClose = true;
            }
        });
        // Display the dialog
        dialog.setVisible(true);
        
        return discountCode[0]; // Return the captured text
    }
    /**
     * Display check room dates.
     * 
     * @return the roomName
     */
    public String askRoomName(){
        isClose = false;
        final String[] roomName = new String[1]; // Array to hold the value from the dialog
        JDialog dialog = new JDialog(this, "Enter Hotel Name", true);
        dialog.setSize(400, 200);
        dialog.setLayout(new GridLayout(2, 2));

        JTextField roomField = new JTextField();
        dialog.add(new JLabel("Room Name:"));
        dialog.add(roomField);
        JButton submitButton = new JButton("Submit");
        dialog.add(new JPanel());
        dialog.add(submitButton);
       

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roomName[0] = roomField.getText(); // Capture the text
                dispose(); // Close the dialog
              }
        });
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                isClose = true;
            }
        });

        dialog.setVisible(true); // Block until dialog is disposed
        return roomName[0]; // Return the captured text
    }
    /**
     * Display room list.
     * 
     * @param rooms the rooms
     */
    public void displayRoomList(ArrayList<String> rooms) {
        // Create a JDialog to display room details
        JDialog dialog = new JDialog(this, "Room List", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new BorderLayout());

        // Create a DefaultListModel to hold room descriptions
        DefaultListModel<String> listModel = new DefaultListModel<>();

        // Populate the list model with room details
        for (String room : rooms) {
            listModel.addElement(room);
        }

        // Create a JList and set its model
        JList<String> roomList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(roomList);

        // Add the scroll pane to the dialog
        dialog.add(scrollPane, BorderLayout.CENTER);

        

        // Display the dialog
        dialog.setVisible(true);
    }
    /**
     * Gets room button.
     *
     * @return the room button
     */
    public JButton getbookRoomButton() {
        return bookRoomButton;
    }

    /**
     * Gets guest name.
     *
     * @return the guest name
     */
    public JTextField getGuestName() {
        return guestName;
    }

    /**
     * Gets room name.
     *
     * @return the room name
     */
    public JTextField getRoomName() {
        return roomName;
    }

    /**
     * Gets check in date.
     *
     * @return the check in date
     */
    public JTextField getCheckInDate() {
        return checkInDate;
    }

    /**
     * Gets check out date.
     *
     * @return the check out date
     */
    public JTextField getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Gets discount code.
     *
     * @return the discount code
     */
    public JTextField getDiscountCode() {
        return discountCode;
    }

    /**
     * Gets check dates button.
     *
     * @return the check dates button
     */
    public JButton getRButton() {
        return roomButton;
    }

    /**
     * Gets hotel name field.
     *
     * @return the hotel name field
     */
    public JTextField getHotelNameField() {
        return hotelNameField;
    }
    /**
     * Gets hotel button.
     * @return
     */
    public JButton getHotelButton() {
        return hotelButton;
    }
    /**
     * Gets check date.
     *
     * @return the check date
     */
    public JButton getCheckDate() {
        return checkDate;
    }
    /**
     * Is close boolean.
     *
     * @return the boolean
     */
    public boolean isClose() {
        return isClose;
    }

}

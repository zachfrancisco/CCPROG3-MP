package Original;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ViewHotelView extends JFrame {

    private boolean isClose;

    String checkIn;
    String checkOut;
    String roomName;
    String reservation;
    int lowLevelOption;
    int options;
    public ViewHotelView() {

    }

    /**
     * Asks the user to enter a hotel name and returns the entered value.
     *
    **/
    public String askHotelName() {
        isClose = false;
        final String[] hotelName = new String[1]; // Array to hold the value from the dialog

        JDialog dialog = new JDialog(this, "Enter Hotel Name", true);
        JTextField hotelNameField = new JTextField();
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

    public void displayMenu() {
        JButton highLevelButton = new JButton("High Level");
        JButton lowLevelButton = new JButton("Low Level");

        JDialog dialog = new JDialog(this, "View Hotel", true);
        dialog.setSize(400, 400);
        dialog.setLayout(new GridLayout(2, 1));

        dialog.add(highLevelButton);
        dialog.add(lowLevelButton);

        highLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                options = 1;
                dispose();
            }
        });
        lowLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                options = 2;
                dispose();
            }
        });

        dialog.setVisible(true);
        
    }

    public void displayHighLevel(String hotelName, double estimatedEarnings, int nRooms, int nReservation) {
        JDialog highLevelDialog = new JDialog(this, "High Level Hotel Information", true);
        highLevelDialog.setLayout(new GridLayout(4, 2));
        highLevelDialog.setSize(400, 200);

        highLevelDialog.add(new JLabel("Hotel Name:"));
        highLevelDialog.add(new JLabel(hotelName));
        highLevelDialog.add(new JLabel("Estimated Earnings:"));
        highLevelDialog.add(new JLabel(String.valueOf(estimatedEarnings)));
        highLevelDialog.add(new JLabel("Number of Rooms:"));
        highLevelDialog.add(new JLabel(String.valueOf(nRooms)));
        highLevelDialog.add(new JLabel("Number of Reservations:"));
        highLevelDialog.add(new JLabel(String.valueOf(nReservation)));

        highLevelDialog.setVisible(true);
    }

    public void displayLowLevel() {
        JDialog hotelCreationDialog = new JDialog(this, "Low Level Menu", true);
        hotelCreationDialog.setLayout(new GridLayout(2, 3));
        hotelCreationDialog.setSize(300, 200);

        JButton checkRoomDatesButton = new JButton("Check Room Dates");
        JButton roomInfoButton = new JButton("Room Info");
        JButton reservationInfoButton = new JButton("Reservation Info");

        hotelCreationDialog.add(checkRoomDatesButton);
        hotelCreationDialog.add(roomInfoButton);
        hotelCreationDialog.add(reservationInfoButton);

        checkRoomDatesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowLevelOption = 1;
                dispose();
            }
        });
        roomInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               lowLevelOption = 2;
               dispose();
            }
        });
        reservationInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowLevelOption = 3;
                dispose();
            }
        });
        hotelCreationDialog.setVisible(true);
    }
    
    public void askRoomDates() {
        isClose = false;
        
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

                // Parse dates from text fields; assuming dates are provided as integers
                checkIn = checkInField.getText();
                checkOut = checkOutField.getText();
                // Close the dialog
                
                dialog.dispose();
            }
        });
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                isClose = true;
            }
        });
        dialog.setVisible(true); // Block until the dialog is disposed

        
    }

    public void askRoomName() {
        isClose = false;
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
                roomName = roomField.getText(); // Capture the text
                
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
        
    }

    public void askReservation() {
        
        isClose = false;
        JDialog dialog = new JDialog(this, "Enter Reservation", true);
        dialog.setSize(400, 200);
        dialog.setLayout(new GridLayout(2, 2));

        JTextField reservationField = new JTextField();
        dialog.add(new JLabel("Reservation:"));
        dialog.add(reservationField);
        JButton submitButton = new JButton("Submit");
        dialog.add(new JPanel());
        dialog.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reservation = reservationField.getText(); // Capture the text
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
        
    }

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

    public void displayRoomInfo(String roomName, double price, ArrayList<Integer> dates) {
        // Create a JDialog to display room information
        JDialog dialog = new JDialog((Frame) null, "Room Information", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new BorderLayout());

        // Create a JPanel for the main content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 1)); // Vertical layout

        // Add room name
        JLabel roomNameLabel = new JLabel("Room Name: " + roomName);
        contentPanel.add(roomNameLabel);

        // Add price
        JLabel priceLabel = new JLabel("Price: $" + String.format("%.2f", price));
        contentPanel.add(priceLabel);

        // Add available dates
        JLabel datesLabel = new JLabel("Available Dates:");
        contentPanel.add(datesLabel);

        // Create a JTextArea to display dates
        JTextArea datesArea = new JTextArea();
        datesArea.setEditable(false); // Make it read-only
        datesArea.setRows(5); // Set number of rows visible
        datesArea.setText(formatDates(dates)); // Format dates and set text

        // Add datesArea to the panel
        contentPanel.add(new JScrollPane(datesArea));

        // Add the content panel to the dialog
        dialog.add(contentPanel, BorderLayout.CENTER);

        // Display the dialog
        dialog.setVisible(true);
    }

    public void displayReservation(String guestName, String roomName, double price, int checkIn, int checkOut,
            double total) {
        // Create a JDialog to display reservation details
        JDialog dialog = new JDialog((Frame) null, "Reservation Details", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new BorderLayout());

        // Create a JPanel for the main content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(6, 2, 5, 5)); // GridLayout with 6 rows, 2 columns and padding

        // Add guest name
        contentPanel.add(new JLabel("Guest Name:"));
        contentPanel.add(new JLabel(guestName));

        // Add room name
        contentPanel.add(new JLabel("Room Name:"));
        contentPanel.add(new JLabel(roomName));

        // Add price
        contentPanel.add(new JLabel("Price per Night:"));
        contentPanel.add(new JLabel("$" + String.format("%.2f", price)));

        // Add check-in date
        contentPanel.add(new JLabel("Check-In Date:"));
        contentPanel.add(new JLabel(Integer.toString(checkIn)));

        // Add check-out date
        contentPanel.add(new JLabel("Check-Out Date:"));
        contentPanel.add(new JLabel(Integer.toString(checkOut)));

        // Add total cost
        contentPanel.add(new JLabel("Total Cost:"));
        contentPanel.add(new JLabel("$" + String.format("%.2f", total)));

        // Add the content panel to the dialog
        dialog.add(contentPanel, BorderLayout.CENTER);

        // Display the dialog
        dialog.setVisible(true);
    }

    public void displayReservationList(ArrayList<String> reservations) {
        // Create a JDialog to display reservation details
        JDialog dialog = new JDialog(this, "Reservation List", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new BorderLayout());

        // Create a DefaultListModel to hold reservation descriptions
        DefaultListModel<String> listModel = new DefaultListModel<>();

        // Populate the list model with reservation details
        for (String reservation : reservations) {
            listModel.addElement(reservation);
        }

        // Create a JList and set its model
        JList<String> reservationList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(reservationList);

        // Add the scroll pane to the dialog
        dialog.add(scrollPane, BorderLayout.CENTER);

        // Display the dialog
        dialog.setVisible(true);
    }
    // Helper method to format dates into a string
    private String formatDates(ArrayList<Integer> dates) {
        if (dates == null || dates.isEmpty()) {
            return "No available dates.";
        }

        StringBuilder sb = new StringBuilder();
        for (Integer date : dates) {
            // Ensure the date is between 1 and 31
            if (date >= 1 && date <= 31) {
                sb.append("Date: ").append(date).append("\n");
            }
        }
        return sb.length() > 0 ? sb.toString() : "No available dates.";
    }

    private String formatDates(int day) {
        if (day < 1 || day > 31) {
            return "Invalid Date"; // Handles any out-of-bound values
        }
        return String.format("%d", day);
    }

    public String getCheckIn() {
        return checkIn;
    }
    public String getCheckOut() {
        return checkOut;
    }
    public String getRoomName() {
        return roomName;
    }
    public String getReservation() {
        return reservation;
    }
    public int getOptions() {
        return options;
    }
    public int getLowLevelOption() {
        return lowLevelOption;
    }
    public boolean isClose() {
        return isClose;
    }
  
}
package Original;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The ManageHotelView class provides a graphical user interface for managing hotel operations.
 * It extends JFrame and includes various components for interacting with hotel data.
 */
public class ManageHotelView extends JFrame {
    
    private int options;
    private int addRoomOptions;
    private double newPrice;
    private String hotelName;
    private String startNewPrice;
    private String endNewPrice;
    private String newPriceRate;
    private boolean isClose;

    /**
     * Constructs a new ManageHotelView object and initializes the components.
     */
    public ManageHotelView() {
        // Initialize components

    }
    /**
     * Displays a dialog to ask for the hotel name.
     */
    public void askHotelName() {
        

        JDialog dialog = new JDialog(this, "Enter Hotel Name", true);
        dialog.setSize(400, 200);
        dialog.setLayout(new GridLayout(2, 2));
        JTextField hotelNameField = new JTextField();

        dialog.add(new JLabel("Hotel Name:"));
        dialog.add(hotelNameField);
        JButton submitButton = new JButton("Submit");
        dialog.add(new JPanel());
        dialog.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hotelName= hotelNameField.getText(); // Capture the text
                dispose(); // Close the dialog
            }
        });
        dialog.setVisible(true);
    }
    /**
     * Displays the options for managing the hotel.
     */
    public void displayManageHotelView() {
        JDialog hotelCreationDialog = new JDialog(this, "Manage Hotel", true);
        hotelCreationDialog.setLayout(new GridLayout(4, 2));
        hotelCreationDialog.setSize(500, 200);
        
        JButton changNameButton = new JButton("Change Name");
        JButton addRoomButton = new JButton("Add Room");
        JButton removeRoomButton = new JButton("Remove Room");
        JButton changeRoomPriceButton = new JButton("Change Room Price");
        JButton removeReservationButton = new JButton("Remove Reservation");
        JButton removeHotelButton = new JButton("Remove Hotel");
        JButton modifyDatePriceButton = new JButton("Modify Date Price");


        hotelCreationDialog.add(changNameButton);
        hotelCreationDialog.add(addRoomButton);
        hotelCreationDialog.add(removeRoomButton);
        hotelCreationDialog.add(changeRoomPriceButton);
        hotelCreationDialog.add(removeReservationButton);
        hotelCreationDialog.add(removeHotelButton);
        hotelCreationDialog.add(modifyDatePriceButton);

        changNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                options = 1;
                dispose();
            }
        });
        addRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                options = 2;
                dispose();
            }
        });
        removeRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                options = 3;
                dispose();
            }
        });
        changeRoomPriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                options = 4;
                dispose();
            }
        });
        removeReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                options = 5;
                dispose();
            }
        });
        removeHotelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                options = 6;
                dispose();
            }
        });
        modifyDatePriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                options = 7;
                dispose();
            }
        });


        hotelCreationDialog.setVisible(true);
    }

    /**
     * Displays a dialog to change the name of the hotel.
     */
    public String changeName() {
        isClose = false;
        JButton changeName = new JButton("Change Name");
        JTextField newHotelNameField = new JTextField();
        String[] newHotelName = new String[1];
        JDialog hotelCreationDialog = new JDialog(this, "Change Hotel Name", true);
        hotelCreationDialog.setLayout(new GridLayout(2, 1)); // Set GridLayout with 3 rows and 1 column
        hotelCreationDialog.setSize(300, 200);

        hotelCreationDialog.add(new JLabel("New Hotel Name:"));
        hotelCreationDialog.add(newHotelNameField);
        hotelCreationDialog.add(changeName);
        
        changeName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newHotelName[0] = newHotelNameField.getText(); // Capture the text
                
                dispose(); // Close the dialog
            }
        });

        hotelCreationDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                isClose = true;
            }
        });

        hotelCreationDialog.setVisible(true);
        return newHotelName[0];
    }

    /**
     * Displays a dialog to add a new room.
     */
    public String addRoom() {
        isClose = false;
        JButton addSButtton = new JButton("Add Standard Room");
        JButton addDButton = new JButton("Add Deluxe Room");
        JButton addEButton = new JButton("Add Executive Room");
        JDialog dialog = new JDialog(this, "Add Room", true);
        String[] newRoomName = new String[1];
        JTextField newRoomNameField = new JTextField();
        dialog.setLayout(new GridLayout(4, 2)); // Set GridLayout with 3 rows and 1 column
        dialog.setSize(400, 200);

        dialog.add(new JLabel("New Room Name:"));
        dialog.add(newRoomNameField);
        dialog.add(new JPanel());
        dialog.add(addSButtton);
        dialog.add(new JPanel());
        dialog.add(addDButton);
        dialog.add(new JPanel());
        dialog.add(addEButton);

        addSButtton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                newRoomName[0] = newRoomNameField.getText(); // Capture the text
                addRoomOptions = 1;
                dispose(); // Close the dialog
            }
        });
        addDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                newRoomName[0] = newRoomNameField.getText(); // Capture the text
                addRoomOptions = 2;
                dispose(); // Close the dialog
            }
        });
        addEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                newRoomName[0] = newRoomNameField.getText(); // Capture the text
                addRoomOptions = 3;
                dispose(); // Close the dialog
            }
        });
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                isClose = true;
            }
        });
        dialog.setVisible(true);
        return newRoomName[0];
    }

    /**
     * Displays a dialog to remove a room.
     */
    public String removeRoom() {
        isClose = false;
        String[] roomName = new String[1];
        JButton removeRoomButton = new JButton("Remove Room");
        JTextField removeRoomField = new JTextField();  
        JDialog dialog = new JDialog(this, "Remove Room", true);
        dialog.setLayout(new GridLayout(2,2));
        dialog.setSize(300, 200);

        dialog.add(new JLabel("Room Name:"));
        dialog.add(removeRoomField);
        dialog.add(new JPanel());
        dialog.add(removeRoomButton);

        removeRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roomName[0] = removeRoomField.getText(); // Capture the text
                dispose(); // Close the dialog
            }
        });
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                isClose = true;
            }
        });

        dialog.setVisible(true);
        return roomName[0];
    }

    /**
     * Displays a dialog to change the price of a room.
     */
    public String changeRoomPrice() {
        isClose = false;
        String[] roomName = new String[1];
        JButton changePriceButton = new JButton("Change Room Price");
        JTextField roomNameField = new JTextField();
        JTextField roomPrice = new JTextField();
        JDialog dialog = new JDialog(this, "Change Price", true);
        dialog.setLayout(new GridLayout(3,2));
        dialog.setSize(300, 200);

        dialog.add(new JLabel("New Price:"));
        dialog.add(roomPrice);
        dialog.add(changePriceButton);

        changePriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    newPrice = Double.parseDouble(roomPrice.getText());
                } catch (NumberFormatException ex) {
                    newPrice = 0.0;
                }

                dispose(); // Close the dialog
            }
        });
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                isClose = true;
            }
        });
        dialog.setVisible(true);
        return roomName[0];
    }

    /**
     * Displays a dialog to remove a reservation.
     */
    public String removeReservation() {
        isClose = false;
        String[] reservationCode = new String[1];
        JButton removeReservationButtton = new JButton("Remove Reservation");
        JTextField removeRes = new JTextField();
        JDialog dialog = new JDialog(this, "Remove Reservation", true);
        dialog.setLayout(new GridLayout(2,2));
        dialog.setSize(300, 200);

        dialog.add(new JLabel("Reservation Code:"));
        dialog.add(removeRes);
        dialog.add(new JPanel());
        dialog.add(removeReservationButtton);

        removeReservationButtton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reservationCode[0] = removeRes.getText(); // Capture the text
                dispose(); // Close the dialog
            }
        });
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                isClose = true;
            }
        });
        dialog.setVisible(true);
        return reservationCode[0];
    }

    /**
     * Displays a dialog to remove a hotel.
     */
    public String removeHotel() {
        isClose = false;
        String[] hotelName = new String[1];
        JButton removeHotelButton = new JButton("Remove Hotel");
        JTextField hotelNameField = new JTextField();
        JDialog dialog = new JDialog(this, "Remove Hotel", true);
        dialog.setLayout(new GridLayout(2,2));
        dialog.setSize(300, 200);

        dialog.add(new JLabel("Hotel Name:"));
        dialog.add(hotelNameField);
        dialog.add(new JPanel());
        dialog.add(removeHotelButton);

        removeHotelButton.addActionListener(new ActionListener() {
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
        dialog.setVisible(true);
        return hotelName[0];
    }

    /**
     * Displays a dialog to modify the date price.
     *
     */
    public void promptmodifyDatePrice() {
        isClose = false;
        JButton modifyDatePriceButton = new JButton("Modify Date Price");
        JTextField percentageField = new JTextField();
        JTextField startField = new JTextField();
        JTextField endField = new JTextField();
        JDialog dialog = new JDialog((Frame) null, "Modify Date Price", true);
        dialog.setLayout(new GridLayout(4, 2));
        dialog.setSize(300, 200);

        dialog.add(new JLabel("New Rate:"));
        dialog.add(percentageField);

        dialog.add(new JLabel("Start Date:"));
        dialog.add(startField);

        dialog.add(new JLabel("End Date:"));
        dialog.add(endField);

        dialog.add(new JLabel());
        dialog.add(modifyDatePriceButton);

        modifyDatePriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPriceRate = percentageField.getText();
                startNewPrice = startField.getText();
                endNewPrice = endField.getText();
                dialog.dispose();
            }
        });
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                isClose = true;
            }
        });
        dialog.setVisible(true);
    }

    /**
     * Displays a dialog to show the breakdown of room data.
     *
     * @param newRates the new rates
     */
    public void displayPriceRateList(double[] newRates) {
        JDialog dialog = new JDialog(this, "Date Price List", true);
        dialog.setLayout(new GridLayout(32, 2));
        dialog.setSize(500, 800);
        dialog.add(new JLabel("Date"));
        dialog.add(new JLabel("Price Multiplier"));
        for (int i = 0; i < 31; i++) {
            dialog.add(new JLabel(String.valueOf(i + 1)));
            dialog.add(new JLabel(String.valueOf(newRates[i])));
        }
        dialog.setVisible(true);
    }
    public int getOptions() {
        return options;
    }
    public int getAddRoomOptions() {
        return addRoomOptions;
    }
    public double getNewPrice() {
        return newPrice;
    }
    
    public String getHotelName() {
        return hotelName;
    }
    public String getStartNewPrice() {
        return startNewPrice;
    }
    public String getEndNewPrice() {
        return endNewPrice;
    }
    public String getNewPriceRate() {
        return newPriceRate;
    }
    public boolean isClose() {
        return isClose;
    }

}

package Original;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The CreateHotelView class represents a GUI window for creating a hotel.
 * It extends JFrame and provides a dialog for entering the hotel name.
 */
public class CreateHotelView extends JFrame {
    private JButton hotelButton;
    private JTextField hotelNameField;
    private String title;
    private boolean isClose;

    /**
     * Constructs a new CreateHotelView.
     * Initializes the components and sets the title.
     */
    public CreateHotelView() {
        // Initialize components
        hotelButton = new JButton("Create Hotel");
        hotelNameField = new JTextField(20);
        title = "Create Hotel";
    }

    /**
     * Displays the create hotel view dialog.
     * The dialog contains a text field for the hotel name and a button to create the hotel.
     */
    public void displayCreateView() {
        // Step 2: Implement the User Interface
        isClose = false;
        JDialog hotelCreationDialog = new JDialog(this, title, true); // Use 'this' to make it modal to the MainView window
        hotelCreationDialog.setLayout(new FlowLayout());
        hotelCreationDialog.setSize(300, 200); // Set size or pack() after adding components

        // Example form field for hotel name
        hotelCreationDialog.add(new JLabel("Hotel Name:"));
        hotelCreationDialog.add(hotelNameField);
        hotelCreationDialog.add(hotelButton);
        
        hotelButton.addActionListener(e -> hotelCreationDialog.dispose());

        hotelCreationDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                isClose = true;
            }
        });
        // Display the dialog
        hotelCreationDialog.setVisible(true);
    }

    /**
     * Returns the hotel button.
     * 
     * @return the hotel button
     */
    public JButton gethotelButton() {
        return hotelButton;
    }

    /**
     * Returns the hotel name text field.
     * 
     * @return the hotel name text field
     */
    public JTextField getHotelNameField() {
        return hotelNameField;
    }
    
    /**
     * Returns the value indicating whether the hotel is closed.
     *
     * @return true if the hotel is closed, false otherwise.
     */
    public boolean getIsClose() {
        return isClose;
    }
}
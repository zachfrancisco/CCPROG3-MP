package Original;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * The type Hrs view.
 */
public final class hrsView extends JFrame {
 
    private JPanel buttonPanel;
    private JPanel mainPanel;
    private JButton createHotelButton;
    private JButton viewHotelButton;
    private JButton manageHotelButton;
    private JButton bookRoomButton;


    /**
     * Instantiates a new Hrs view.
     */
    public hrsView() {
        // Initialize buttons
        createHotelButton = new JButton("Create Hotel");
        viewHotelButton = new JButton("View Hotel");
        manageHotelButton = new JButton("Manage Hotel");
        bookRoomButton = new JButton("Book Room");
    }

    /**
     * Display hrs view.
     */
    public void displayHRSView()
    {
        // Initialize panels
        buttonPanel = new JPanel(new GridLayout(2, 2)); // Set layout to 2 by 2 grid
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(400, 400));

        // Add buttons to buttonPanel
        buttonPanel.add(createHotelButton);
        buttonPanel.add(viewHotelButton);
        buttonPanel.add(manageHotelButton);
        buttonPanel.add(bookRoomButton);

        // Add buttonPanel to mainPanel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add panels to JFrame in appropriate regions
        this.add(mainPanel, BorderLayout.CENTER);

        // Set frame properties
        this.setTitle("Hotel Reservation System"); // Set the title of the JFrame
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); // Ensure the frame is visible
    }

    /**
     * Display error message.
     *
     * @param message the message
     */
    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Successful message.
     *
     * @param message the message
     */
    public void successfulMessage(String message) {
    JOptionPane.showMessageDialog(this,  message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Gets create button.
     *
     * @return the create button
     */
    public JButton getCreateButton(){
        return createHotelButton;
    }
    public JButton getViewButton(){
        return viewHotelButton;
    }
    public JButton getManageButton(){
        return manageHotelButton;
    }
    public JButton getBookButton(){
        return bookRoomButton;
    }

    public void displayHotelList(ArrayList<String> hotelNames) {
        // Create a new JDialog
        JDialog dialog = new JDialog(this, "Hotel List", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new BorderLayout());
    
        // Create a DefaultListModel to hold the hotel names
        DefaultListModel<String> listModel = new DefaultListModel<>();
    
        // Populate the list model with hotel names
        for (String hotelName : hotelNames) {
            listModel.addElement(hotelName);
        }
    
        // Create a JList with the list model and add it to a JScrollPane
        JList<String> hotelList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(hotelList);
    
        // Add the scroll pane to the dialog
        dialog.add(scrollPane, BorderLayout.CENTER);
    
        // Set the dialog to be visible
        dialog.setVisible(true);
    }
    
    

}
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TEST1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Cursor Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Use absolute layout

        JTextField textField1 = new JTextField();
        JTextField textField2 = new JTextField();
        
        // Set the bounds of the text fields
        textField1.setBounds(50, 50, 150, 20);
        textField2.setBounds(50, 100, 150, 20);
        
        // Add the text fields to the frame
        frame.add(textField1);
        frame.add(textField2);

        // Make the first text field focusable and request focus
        textField1.setFocusable(true);
        textField1.requestFocusInWindow();

        // Set the size of the frame
        frame.setSize(400, 300);

        // Set the frame visible
        frame.setVisible(true);
    }
}

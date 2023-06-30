import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.border.LineBorder;

public class MainFrame {

	private JFrame frame;
	 BufferedWriter writer = null;
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("HSN");
		frame.setForeground(new Color(255, 255, 255));
		frame.setBackground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 560, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(171, 11, 71, 34);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel mainlabel = new JLabel("Welcome");
		panel.add(mainlabel, BorderLayout.CENTER);
		mainlabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mainlabel.setForeground(new Color(255, 255, 255));
		mainlabel.setBackground(new Color(0, 0, 0));
		mainlabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel mainlabel2 = new JLabel("Enter file name here:");
		mainlabel2.setForeground(new Color(255, 255, 255));
		mainlabel2.setBackground(new Color(0, 0, 0));
		mainlabel2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mainlabel2.setHorizontalAlignment(SwingConstants.CENTER);
		mainlabel2.setBounds(120, 116, 122, 20);
		frame.getContentPane().add(mainlabel2);
		
		JTextField maintext = new JTextField();
		maintext.setHorizontalAlignment(SwingConstants.CENTER);
		maintext.setForeground(new Color(255, 255, 255));
		maintext.setFont(new Font("Tahoma", Font.PLAIN, 12));
		maintext.setBackground(new Color(0, 0, 0));
		maintext.setBounds(252, 116, 170, 20);
		maintext.setText(null);
		maintext.setBorder(new LineBorder(new Color(255, 255, 255)));
		maintext.setBorder(BorderFactory.createCompoundBorder(maintext.getBorder(),BorderFactory.createEmptyBorder(2, 5, 2, 2)));
		//maintext.setMargin(new Insets(2, 5, 2, 2));
		maintext.setCaretColor(Color.WHITE);
		frame.getContentPane().add(maintext);
		maintext.setColumns(10);
		
		JButton mainbutton = new JButton("Submit");
		mainbutton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mainbutton.setForeground(new Color(255, 255, 255));
		mainbutton.setBackground(new Color(0, 0, 0));
		mainbutton.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		JButton btnNewButton = new JButton("Reset");
		mainbutton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==mainbutton) 
				{
					
						if(maintext.getText().trim().isEmpty())
						{  
							System.out.println("Invalid name");
							
							
						}
						else
						{
								
			                try {
			                    @SuppressWarnings("resource")
								XSSFWorkbook workbook = new XSSFWorkbook();
			                    @SuppressWarnings("unused")
								Sheet sheet = workbook.createSheet("Data");
			                    FileOutputStream fileOutputStream = new FileOutputStream(maintext.getText() + ".xlsx");
			                    workbook.write(fileOutputStream);
			                    fileOutputStream.close();
			                    // System.out.println("Workbook saved to file: " + maintext + ".xlsx");
			                    maintext.setEditable(false);
			                    mainbutton.setEnabled(false);
			                    btnNewButton.setEnabled(false);	
			                    new Frame2();
			                    frame.dispose();
			                    try {
			                        writer = new BufferedWriter(new FileWriter("temporary.txt"));
			                        writer.write(maintext.getText() + ".xlsx");
			                       
			                    	} 
			                    catch (IOException e1) 
			                    	{
			                    	e1.printStackTrace();
			                    	} 
			                    finally 
			                    {
			                        try 
			                        {
			                            if (writer != null) 
			                            {
			                                writer.close();
			                            }
			                        } 
			                        catch (IOException e1) 
			                        {
			                            e1.printStackTrace();
			                        }
			                    }
			                	}
			                catch (IOException ex) 
			                {
			                    ex.printStackTrace();
			                }
					
					
						}
				}
			}
		}
											
														
															
		
																);
		
		
		
		mainbutton.setBounds(120, 151, 61, 23);
		frame.getContentPane().add(mainbutton);
		
		
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				maintext.setText(null);
				 
			}
		}								);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(252, 152, 61, 23);
		btnNewButton.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(252, 11, 35, 34);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUser.setBackground(Color.BLACK);
		panel_1.add(lblUser, BorderLayout.CENTER);
	}
}
	

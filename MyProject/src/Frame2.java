import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Frame2 extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea txtrFrom;
	private JTextArea txtrTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame2 window = new Frame2();
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
	public Frame2() {
		
		initialize();
		
	}

	

	/**
	 * Initialize the contents of the frame.
	 * @param s 
	 */
	private void initialize() {
		frame = new JFrame("HSN");
		frame.setBounds(100, 100, 560, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(142, 42, 183, 32);
		frame.getContentPane().add(panel);
		
		JTextArea txtrEnterTheCell = new JTextArea();
		txtrEnterTheCell.setText("Enter the cell range :");
		txtrEnterTheCell.setEditable(false);
		panel.add(txtrEnterTheCell);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(239, 128, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField_1.setSelectionColor(new Color(0, 0, 0));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(239, 85, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		txtrFrom = new JTextArea();
		txtrFrom.setText("FROM:");
		txtrFrom.setEditable(false);
		txtrFrom.setBounds(142, 83, 87, 22);
		frame.getContentPane().add(txtrFrom);
		
		txtrTo = new JTextArea();
		txtrTo.setText("To:");
		txtrTo.setEditable(false);
		txtrTo.setBounds(142, 126, 87, 22);
		frame.getContentPane().add(txtrTo);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource()==submit) 
				{
					
						if(textField.getText().trim().isEmpty() || textField_1.getText().trim().isEmpty() ||textField.getText().contentEquals(textField_1.getText())
								)
						{  
							System.out.println("Invalid name");
							
							
						}
						else
						{
							try 
							{
					            BufferedReader reader = new BufferedReader(new FileReader("temporary.txt"));
					            String line;
					            
					            line = reader.readLine();
					            reader.close();
					                System.out.println(line);
					                {
					                try (FileInputStream inputStream = new FileInputStream(line);
					                        Workbook workbook = new XSSFWorkbook(inputStream)) 
					                {

					                       @SuppressWarnings("unused")
										Sheet sheet = workbook.getSheet("Data");
					                       
										
					                          /* 
					                           * Change this with the curretn values
					                           * 
					                           * Row row = sheet.createRow(1);
					                           String rowValues="A,B,C,D,E";
					                          

					                           String[] values = rowValues.split(",");
					                           for (int j = 0; j < values.length; j++) 
					                           {
					                               Cell cell = row.createCell(j);
					                               cell.setCellValue(values[j].trim());
					                               
					                           
					                           }*/
					                           FileOutputStream outputStream = new FileOutputStream(line);
					                           workbook.write(outputStream);
					                           outputStream.close();
					                }catch (IOException e2) 
					                {
					                    e2.printStackTrace();
					                }
					                
					           
					                }
					             }  
					         
							catch (IOException e1) {
					            System.out.println("An error occurred while reading the file: " + e1.getMessage());
					        }
							
						}
				}           		
			}
		 }
								);
			
		
		
		
		submit.setBackground(new Color(255, 255, 255));
		submit.setBorder(new LineBorder(new Color(0, 0, 0)));
		submit.setBounds(142, 178, 89, 23);
		frame.getContentPane().add(submit);
		
		JButton reset = new JButton("Reset");
		reset.setBackground(new Color(255, 255, 255));
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
			}
		});
		reset.setBorder(new LineBorder(new Color(0, 0, 0)));
		reset.setBounds(239, 178, 89, 23);
		frame.getContentPane().add(reset);
		
	}
}
		

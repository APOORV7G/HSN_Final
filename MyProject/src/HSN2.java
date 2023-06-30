

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HSN2 
{

	public static void main(String args[]) throws IOException 
	{
		
		JFrame mainframe=new JFrame("HSN");
		JLabel mainlabelheading=new JLabel();
		JLabel mainlabelheading2=new JLabel();			//	width=1360
		JLabel mainlabelheadingempty=new JLabel();		//	height=728
		 @SuppressWarnings("resource")

		JButton mainbutton=new JButton();
		JTextField maintext=new JTextField();
		GridBagConstraints gbc=new GridBagConstraints();
		JLabel mainlabelheading2sublabel1=new JLabel("Enter file name :",JLabel.LEFT);
		
		
		//main frame
				{
		mainframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.setResizable(false);
		mainframe.getContentPane().setBackground(new Color(0xe1c699));		
		mainframe.setVisible(true);
		mainframe.setLayout(new BorderLayout());
				}
				
	
		//border
				{
		Border border_mainlabelheading=BorderFactory.createEmptyBorder();
		mainlabelheading.setBorder(border_mainlabelheading);
		mainlabelheading2.setBorder(border_mainlabelheading);
		mainlabelheadingempty.setBorder(border_mainlabelheading);
		mainlabelheading2sublabel1.setBorder(border_mainlabelheading);
				}
				
		//main label heading 1	
				{
		mainlabelheading.setText("Welcome!!");
		mainlabelheading.setPreferredSize(new Dimension(500,100));
		mainlabelheading.setHorizontalAlignment(JLabel.CENTER);
		mainlabelheading.setFont(new Font("Times New Roman",Font.PLAIN,25));
				}
		
		//main label heading 2
				{
		
		mainlabelheading2.setPreferredSize(new Dimension(500,100));
		mainlabelheading2.setFont(new Font("Times New Roman",Font.PLAIN,20));
		mainlabelheading2.setLayout(new GridBagLayout());		
		
				}
				
				//main label heading 2 sub label 1
				{
		
		
		
		mainlabelheading2sublabel1.setFont(new Font("Times New Roman",Font.PLAIN,25));
	
		
				}
				
		//main label heading empty
				{
		mainlabelheadingempty.setText("");
		mainlabelheadingempty.setPreferredSize(new Dimension(500,300));
		mainlabelheadingempty.setHorizontalAlignment(JLabel.CENTER);
		mainlabelheadingempty.setFont(new Font("Times New Roman",Font.PLAIN,25));
				}
				
		//button +text field +action listener
					
	
		mainbutton.setText("SUBMIT");
		mainbutton.setPreferredSize(new Dimension(100,25));
		maintext.setPreferredSize(new Dimension(100,25));
		mainbutton.addActionListener(new ActionListener()
				{
						public void actionPerformed(ActionEvent e) 
							{
								if(e.getSource()==mainbutton) {
									{ 
										

							                try {
							                    XSSFWorkbook workbook = new XSSFWorkbook();
							                    Sheet sheet = workbook.createSheet("Data");
							                    FileOutputStream fileOutputStream = new FileOutputStream(maintext.getText() + ".xlsx");
							                    workbook.write(fileOutputStream);
							                    fileOutputStream.close();
							                    System.out.println("Workbook saved to file: " + maintext + ".xlsx");
							                    maintext.setEditable(false);
							                    mainbutton.setEnabled(false);
							                } catch (IOException ex) {
							                    ex.printStackTrace();
							                }
									
									
									}
								}
							
							}
						}
									);
		
	
				
			
				
				
		//adding stuff to the main frame	
				{
		mainframe.add(mainlabelheading,BorderLayout.NORTH);
		mainframe.add(mainlabelheading2,BorderLayout.CENTER);
		mainframe.add(mainlabelheadingempty,BorderLayout.SOUTH);
		
		mainlabelheading2.add(mainlabelheading2sublabel1);
	
		mainlabelheading2.add(mainbutton);
		
		mainlabelheading2.add(maintext);
				}
	}

	

}



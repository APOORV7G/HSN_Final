import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Frame3 {

	private JFrame frame;
	private JTextField txtNos;
	private JTextField txtAmt;
	private JTextField txtNos_1;
	private JTextField txtAmt_1;
	private JTextField txtNos_2;
	private JTextField txtAmt_2;
	private JTextField txtNos_3;
	private JTextField txtAmt_3;
	private JTextField txtNos_4;
	private JTextField txtAmt_4;
	private JTextField txtInvoice;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField invoice_1;
	private JButton submit;
	private String temp,temp1,temp2,temp3,temp4,temp5,temp6,temp7,temp8,temp9;
	private JTextField txtTotal;
	private JTextField textField_10;
	private Sheet sheet;
	private int rowIndex;
	 private Workbook workbook;
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame3 window = new Frame3();
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
	public Frame3() {
		initialize();
		try 
		{
            BufferedReader reader = new BufferedReader(new FileReader("temporary.txt"));
            String line;
            
            line = reader.readLine();
            reader.close();
                
                {
                	try (FileInputStream fis = new FileInputStream(line)) 
                	{
                        workbook = WorkbookFactory.create(fis);
                	
                		sheet = workbook.getSheetAt(0);
                		rowIndex = 4;
                		Row firstRow = sheet.getRow(4);
                        if (firstRow != null) {
                            Cell firstCell = firstRow.getCell(0);
                            if (firstCell != null && firstCell.getCellType() == CellType.NUMERIC) {
                                int intValue = (int) firstCell.getNumericCellValue();
                                String stringValue = String.valueOf(intValue);
                                invoice_1.setText(stringValue);
                            }
                        }
                         
                		
                	
                	}
                	catch (IOException e2) 
	                {
	                    e2.printStackTrace();
	                }
	                
                }
		}
		catch (IOException e1) 
		{
            System.out.println("An error occurred while reading the file: " + e1.getMessage());
        }
	}
	private int evaluateExpression(String expression) {
        expression = expression.replace(" ", ""); // Remove spaces

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();

        int i = 0;
        while (i < expression.length()) {
            char currentChar = expression.charAt(i);
            if (Character.isDigit(currentChar)) {
                StringBuilder numBuilder = new StringBuilder();
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    numBuilder.append(expression.charAt(i));
                    i++;
                }
                int num = Integer.parseInt(numBuilder.toString());
                numStack.push(num);
            } else if (currentChar == '+' || currentChar == '*') {
                while (!opStack.isEmpty() && hasPrecedence(currentChar, opStack.peek())) {
                    performOperation(numStack, opStack);
                }
                opStack.push(currentChar);
                i++;
            } else {
                throw new IllegalArgumentException("Invalid character: " + currentChar);
            }
        }

        while (!opStack.isEmpty()) {
            performOperation(numStack, opStack);
        }

        return numStack.pop();
    }

    private boolean hasPrecedence(char op1, char op2) {
        return (op2 == '*') || (op1 == '+' && op2 == '+');
    }

    private void performOperation(Stack<Integer> numStack, Stack<Character> opStack) {
        int num2 = numStack.pop();
        int num1 = numStack.pop();
        char operator = opStack.pop();

        int result = 0;
        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '*') {
            result = num1 * num2;
        }
        numStack.push(result);
    }
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame("HSN");
		frame.setBounds(100, 100, 560, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 524, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Border mainborder=BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black), BorderFactory.createEmptyBorder(2, 5, 2, 2));
		
		
		txtNos = new JTextField();
		txtNos.setText("8532 NOS");
		txtNos.setBounds(10, 92, 77, 20);
		txtNos.setBorder(mainborder);
		txtNos.setEditable(false);
		panel.add(txtNos);
		txtNos.setColumns(10);
		
		txtAmt = new JTextField();
		txtAmt.setText("8532 AMT");
		txtAmt.setColumns(10);
		txtAmt.setBounds(10, 121, 77, 20);
		txtAmt.setBorder(mainborder);
		txtAmt.setEditable(false);
		panel.add(txtAmt);
		
		txtNos_1 = new JTextField();
		txtNos_1.setText("8533 NOS");
		txtNos_1.setColumns(10);
		txtNos_1.setBounds(10, 152, 77, 20);
		txtNos_1.setBorder(mainborder);
		txtNos_1.setEditable(false);
		panel.add(txtNos_1);
		
		txtAmt_1 = new JTextField();
		txtAmt_1.setText("8533 AMT");
		txtAmt_1.setColumns(10);
		txtAmt_1.setBounds(10, 183, 77, 20);
		txtAmt_1.setBorder(mainborder);
		txtAmt_1.setEditable(false);
		panel.add(txtAmt_1);
		
		txtNos_2 = new JTextField();
		txtNos_2.setText("8536 NOS");
		txtNos_2.setColumns(10);
		txtNos_2.setBounds(10, 214, 77, 20);
		txtNos_2.setBorder(mainborder);
		txtNos_2.setEditable(false);
		panel.add(txtNos_2);
		
		txtAmt_2 = new JTextField();
		txtAmt_2.setText("8536 AMT");
		txtAmt_2.setColumns(10);
		txtAmt_2.setBounds(10, 245, 77, 20);
		txtAmt_2.setBorder(mainborder);
		txtAmt_2.setEditable(false);
		panel.add(txtAmt_2);
		
		txtNos_3 = new JTextField();
		txtNos_3.setText("8541 NOS");
		txtNos_3.setColumns(10);
		txtNos_3.setBounds(10, 276, 77, 20);
		txtNos_3.setBorder(mainborder);
		txtNos_3.setEditable(false);
		panel.add(txtNos_3);
		
		txtAmt_3 = new JTextField();
		txtAmt_3.setText("8541 AMT");
		txtAmt_3.setColumns(10);
		txtAmt_3.setBounds(10, 307, 77, 20);
		txtAmt_3.setBorder(mainborder);
		txtAmt_3.setEditable(false);
		panel.add(txtAmt_3);
		
		txtNos_4 = new JTextField();
		txtNos_4.setText("8542 NOS");
		txtNos_4.setColumns(10);
		txtNos_4.setBounds(10, 338, 77, 20);
		txtNos_4.setBorder(mainborder);
		txtNos_4.setEditable(false);
		panel.add(txtNos_4);
		
		txtAmt_4 = new JTextField();
		txtAmt_4.setText("8542 AMT");
		txtAmt_4.setColumns(10);
		txtAmt_4.setBounds(10, 369, 77, 20);
		txtAmt_4.setBorder(mainborder);
		txtAmt_4.setEditable(false);
		panel.add(txtAmt_4);
		
		txtInvoice = new JTextField();
		txtInvoice.setText("INVOICE");
		txtInvoice.setBounds(10, 11, 77, 20);
		txtInvoice.setBorder(mainborder);
		txtInvoice.setEditable(false);
		panel.add(txtInvoice);
		txtInvoice.setColumns(10);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				 if (e.getKeyCode() == KeyEvent.VK_ENTER)
				 {
					 temp=textField.getText();
					 System.out.println(temp);
					 try {
		                    int result = evaluateExpression(temp);
		                    textField.setText(String.valueOf(result));
		                } catch (NumberFormatException ex) {
		                	textField.setText("Invalid input");
		                } catch (IllegalArgumentException ex) {
		                	textField.setText("Invalid expression: " + ex.getMessage());
		                }
					 temp=textField.getText();
					 
					 textField_1.setFocusable(true);
					 textField_1.requestFocusInWindow();
				 }
			}
		});
		textField.setCaretColor(new Color(0, 0, 0));
		textField.setBounds(97, 92, 86, 20);
		textField.setBorder(mainborder);
		panel.add(textField);
		textField.setFocusable(true);
		textField.requestFocusInWindow();
		
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				 if (e.getKeyCode() == KeyEvent.VK_ENTER)
				 {
					 temp1=textField_1.getText();
					 System.out.println(temp1);
					 try {
		                    int result = evaluateExpression(temp1);
		                    textField_1.setText(String.valueOf(result));
		                } catch (NumberFormatException ex) {
		                	textField_1.setText("Invalid input");
		                } catch (IllegalArgumentException ex) {
		                	textField_1.setText("Invalid expression: " + ex.getMessage());
		                }
					 temp1=textField_1.getText();
					 textField_2.setFocusable(true);
					 textField_2.requestFocusInWindow();
					 
				 }
			}

			
		});
		textField_1.setColumns(10);
		textField_1.setBounds(97, 121, 86, 20);
		textField_1.setBorder(mainborder);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				 if (e.getKeyCode() == KeyEvent.VK_ENTER)
				 {
					 temp2=textField_2.getText();
					 System.out.println(temp2);
					 textField_3.setFocusable(true);
					 textField_3.requestFocusInWindow();
					 try {
		                    int result = evaluateExpression(temp2);
		                    textField_2.setText(String.valueOf(result));
		                } catch (NumberFormatException ex) {
		                	textField_2.setText("Invalid input");
		                } catch (IllegalArgumentException ex) {
		                	textField_2.setText("Invalid expression: " + ex.getMessage());
		                }
					 temp2=textField_2.getText();
				 }
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(97, 152, 86, 20);
		textField_2.setBorder(mainborder);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				 if (e.getKeyCode() == KeyEvent.VK_ENTER)
				 {
					  temp3=textField_3.getText();
					 System.out.println(temp3);
					 try {
		                    int result = evaluateExpression(temp3);
		                    textField_3.setText(String.valueOf(result));
		                } catch (NumberFormatException ex) {
		                	textField_3.setText("Invalid input");
		                } catch (IllegalArgumentException ex) {
		                	textField_3.setText("Invalid expression: " + ex.getMessage());
		                }
					 temp3=textField_3.getText();
					 textField_4.setFocusable(true);
					 textField_4.requestFocusInWindow();
				 }
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(97, 183, 86, 20);
		textField_3.setBorder(mainborder);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				 if (e.getKeyCode() == KeyEvent.VK_ENTER)
				 {
					 temp4=textField_4.getText();
					 System.out.println(temp4);
					 try {
		                    int result = evaluateExpression(temp4);
		                    textField_4.setText(String.valueOf(result));
		                } catch (NumberFormatException ex) {
		                	textField_4.setText("Invalid input");
		                } catch (IllegalArgumentException ex) {
		                	textField_4.setText("Invalid expression: " + ex.getMessage());
		                }
					 temp4=textField_4.getText();
					 textField_5.setFocusable(true);
					 textField_5.requestFocusInWindow();
				 }
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(97, 214, 86, 20);
		textField_4.setBorder(mainborder);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				 if (e.getKeyCode() == KeyEvent.VK_ENTER)
				 {
					 temp5=textField_5.getText();
					 System.out.println(temp5);
					 try {
		                    int result = evaluateExpression(temp5);
		                    textField_5.setText(String.valueOf(result));
		                } catch (NumberFormatException ex) {
		                	textField_5.setText("Invalid input");
		                } catch (IllegalArgumentException ex) {
		                	textField_5.setText("Invalid expression: " + ex.getMessage());
		                }
					 temp5=textField_5.getText();
					 textField_6.setFocusable(true);
					 textField_6.requestFocusInWindow();
				 }
			}
		});
		textField_5.setColumns(10);
		textField_5.setBounds(97, 245, 86, 20);
		textField_5.setBorder(mainborder);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				 if (e.getKeyCode() == KeyEvent.VK_ENTER)
				 {
					 temp6=textField_6.getText();
					 System.out.println(temp6);
					 try {
		                    int result = evaluateExpression(temp6);
		                    textField_6.setText(String.valueOf(result));
		                } catch (NumberFormatException ex) {
		                	textField_6.setText("Invalid input");
		                } catch (IllegalArgumentException ex) {
		                	textField_6.setText("Invalid expression: " + ex.getMessage());
		                }
					 temp6=textField_6.getText();
					 textField_7.setFocusable(true);
					 textField_7.requestFocusInWindow();
				 }
			}
		});
		textField_6.setColumns(10);
		textField_6.setBounds(97, 276, 86, 20);
		textField_6.setBorder(mainborder);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				 if (e.getKeyCode() == KeyEvent.VK_ENTER)
				 {
					 temp7=textField_7.getText();
					 System.out.println(temp7);
					 try {
		                    int result = evaluateExpression(temp7);
		                    textField_7.setText(String.valueOf(result));
		                } catch (NumberFormatException ex) {
		                	textField_7.setText("Invalid input");
		                } catch (IllegalArgumentException ex) {
		                	textField_7.setText("Invalid expression: " + ex.getMessage());
		                }
					 temp7=textField_7.getText();
					 textField_8.setFocusable(true);
					 textField_8.requestFocusInWindow();
				 }
			}
		});
		textField_7.setColumns(10);
		textField_7.setBounds(97, 307, 86, 20);
		textField_7.setBorder(mainborder);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				 if (e.getKeyCode() == KeyEvent.VK_ENTER)
				 {
					 temp8=textField_8.getText();
					 System.out.println(temp8);
					 try {
		                    int result = evaluateExpression(temp8);
		                    textField_8.setText(String.valueOf(result));
		                } catch (NumberFormatException ex) {
		                	textField_8.setText("Invalid input");
		                } catch (IllegalArgumentException ex) {
		                	textField_8.setText("Invalid expression: " + ex.getMessage());
		                }
					 temp8=textField_8.getText();
					 textField_9.setFocusable(true);
					 textField_9.requestFocusInWindow();
				 }
			}
		});
		textField_8.setColumns(10);
		textField_8.setBounds(97, 338, 86, 20);
		textField_8.setBorder(mainborder);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				 if (e.getKeyCode() == KeyEvent.VK_ENTER)
				 {
					 temp9=textField_9.getText();
					 System.out.println(temp9);
					 try {
		                    int result = evaluateExpression(temp9);
		                    textField_9.setText(String.valueOf(result));
		                } catch (NumberFormatException ex) {
		                	textField_9.setText("Invalid input");
		                } catch (IllegalArgumentException ex) {
		                	textField_9.setText("Invalid expression: " + ex.getMessage());
		                }
					 temp9=textField_9.getText();
					 textField_10.setFocusable(true);
					 textField_10.requestFocusInWindow();
				 }
			}
		});
		textField_9.setColumns(10);
		textField_9.setBounds(97, 369, 86, 20);
		textField_9.setBorder(mainborder);
		panel.add(textField_9);
		
		invoice_1 = new JTextField();
		
		invoice_1.setBounds(97, 11, 86, 20);
		invoice_1.setBorder(mainborder);
		invoice_1.setEditable(false);
		panel.add(invoice_1);
		invoice_1.setColumns(10);
		
		
		
		submit=new JButton("Submit");
		submit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e)
			{
				 if (e.getKeyCode() == KeyEvent.VK_ENTER)
				 {
					 writeValue();
					 readNextValue();
				
				
				textField.setFocusable(true);
				textField.requestFocusInWindow();
				 }
			}
			private void writeValue() {
				
				Row row = sheet.createRow(rowIndex);
				row.createCell(0).setCellValue(Integer.parseInt(invoice_1.getText()));
		        row.createCell(1).setCellValue(Integer.parseInt(textField.getText()));
		        row.createCell(2).setCellValue(Integer.parseInt(textField_1.getText()));
		        row.createCell(3).setCellValue(Integer.parseInt(textField_2.getText()));
		        row.createCell(4).setCellValue(Integer.parseInt(textField_3.getText()));
		        row.createCell(5).setCellValue(Integer.parseInt(textField_4.getText()));
		        row.createCell(6).setCellValue(Integer.parseInt(textField_5.getText()));
		        row.createCell(7).setCellValue(Integer.parseInt(textField_6.getText()));
		        row.createCell(8).setCellValue(Integer.parseInt(textField_7.getText()));
		        row.createCell(9).setCellValue(Integer.parseInt(textField_8.getText()));
		        row.createCell(10).setCellValue(Integer.parseInt(textField_9.getText()));
		        row.createCell(11).setCellValue(Integer.parseInt(textField_10.getText()));		        
		        

		        
		        try 
				{
		            BufferedReader reader = new BufferedReader(new FileReader("temporary.txt"));
		            String line;
		            
		            line = reader.readLine();
		            reader.close();
		                
		                {
		                	
		                		
		                		try (FileOutputStream fos = new FileOutputStream(line)) 
		                		{
		                            workbook.write(fos);
		                            fos.close();
		                            System.out.println("File writeen");
		                        } catch (IOException e) 
		                		{
		                            e.printStackTrace();
		                        }
		                   
			                
		                }
				}
				catch (IOException e1) 
				{
		            System.out.println("An error occurred while reading the file: " + e1.getMessage());
		        }
		        clearAllTextFields();
			}
				
			
			private void clearAllTextFields() {
				
				textField.setText("");
		        textField_1.setText("");
		        textField_2.setText("");
		        textField_3.setText("");
		        textField_4.setText("");
		        textField_5.setText("");
		        textField_6.setText("");
		        textField_7.setText("");
		        textField_8.setText("");
		        textField_9.setText("");
		        textField_10.setText("");
				
			}
			private void readNextValue() {
				
				if (rowIndex+1 < sheet.getLastRowNum() + 1) 
				{
		            Row row = sheet.getRow(rowIndex+1);
		            Cell cell = row.getCell(0);

		            if (cell != null && cell.getCellType() == CellType.NUMERIC)
		            {
		            	int intValue = (int) cell.getNumericCellValue();
		                String stringValue = String.valueOf(intValue);
		                invoice_1.setText(stringValue);
		                
		            } 
		            else 
		            {
		                invoice_1.setText("");
		            }

		            rowIndex++;
		        } 
				else 
		        {
		            invoice_1.setText("No more values");
		            frame.dispose();
		            new Frame4();
		        }
				
			}
			
		});
		
		/*submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				writeValue();
				readNextValue();
				
				
				textField.setFocusable(true);
				textField.requestFocusInWindow();
			}

			private void writeValue() 
			{
				
				Row row = sheet.createRow(rowIndex);
				row.createCell(0).setCellValue(Integer.parseInt(invoice_1.getText()));
				row.createCell(1).setCellValue(Integer.parseInt(textField.getText()));
		        row.createCell(2).setCellValue(Integer.parseInt(textField_1.getText()));
		        row.createCell(3).setCellValue(Integer.parseInt(textField_2.getText()));
		        row.createCell(4).setCellValue(Integer.parseInt(textField_3.getText()));
		        row.createCell(5).setCellValue(Integer.parseInt(textField_4.getText()));
		        row.createCell(6).setCellValue(Integer.parseInt(textField_5.getText()));
		        row.createCell(7).setCellValue(Integer.parseInt(textField_6.getText()));
		        row.createCell(8).setCellValue(Integer.parseInt(textField_7.getText()));
		        row.createCell(9).setCellValue(Integer.parseInt(textField_8.getText()));
		        row.createCell(10).setCellValue(Integer.parseInt(textField_9.getText()));
		        

		        
		        try 
				{
		            BufferedReader reader = new BufferedReader(new FileReader("temporary.txt"));
		            String line;
		            
		            line = reader.readLine();
		            reader.close();
		                
		                {
		                	
		                		
		                		try (FileOutputStream fos = new FileOutputStream(line)) 
		                		{
		                            workbook.write(fos);
		                            fos.close();
		                            System.out.println("File writeen");
		                        } 
		                		catch (IOException e) 
		                		{
		                            e.printStackTrace();
		                        }
		                    
		                   
		                }
				}
				catch (IOException e1) 
				{
		            System.out.println("An error occurred while reading the file: " + e1.getMessage());
		        }
		        clearAllTextFields();
			}

			private void clearAllTextFields()
	{
        textField.setText("");
        textField_1.setText("");
        textField_2.setText("");
        textField_3.setText("");
        textField_4.setText("");
        textField_5.setText("");
        textField_6.setText("");
        textField_7.setText("");
        textField_8.setText("");
        textField_9.setText("");
    }

			private void readNextValue() 
			{
				
				if (rowIndex+1 < sheet.getLastRowNum() + 1)
				{
		            Row row = sheet.getRow(rowIndex+1);
		            Cell cell = row.getCell(0);

		            if (cell != null && cell.getCellType() == CellType.NUMERIC) 
		            {
		            	int intValue = (int) cell.getNumericCellValue();
		                String stringValue = String.valueOf(intValue);
		                invoice_1.setText(stringValue);
		                
		            } 
		            else 
		            {
		                invoice_1.setText("");
		            }

		            rowIndex++;
		        } 
				else 
		        {
		            invoice_1.setText("No more values");
		        }
				
			}
		});
		*/
		submit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		submit.setForeground(new Color(0, 0, 0));
		submit.setBackground(new Color(255, 255, 255));
		submit.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		submit.setBounds(294, 199, 61, 23);
		panel.add(submit);
		
		txtTotal = new JTextField();
		txtTotal.setText("TOTAL");
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(294, 152, 77, 20);
		txtTotal.setBorder(mainborder);
		panel.add(txtTotal);
		
		textField_10 = new JTextField();
		textField_10.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e) 
			{
				
				int total=Integer.parseInt(temp1)+Integer.parseInt(temp3)+Integer.parseInt(temp5)+Integer.parseInt(temp7)+Integer.parseInt(temp9);
				textField_10.setText(String.valueOf(total));
				submit.setFocusable(true);
				submit.requestFocusInWindow();
			}
		});
		
		textField_10.setColumns(10);
		textField_10.setBounds(382, 152, 77, 20);
		textField_10.setBorder(mainborder);
		panel.add(textField_10);
	}
}
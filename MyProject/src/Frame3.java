import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

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
	private JButton reset;
	private String temp,temp1,temp2,temp3,temp4,temp5,temp6,temp7,temp8,temp9;

	

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
					 submit.setFocusable(true);
					 submit.requestFocusInWindow();
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
		submit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		submit.setForeground(new Color(0, 0, 0));
		submit.setBackground(new Color(255, 255, 255));
		submit.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		submit.setBounds(382, 367, 61, 23);
		panel.add(submit);
		reset = new JButton("Reset");
		reset.setFont(new Font("Tahoma", Font.PLAIN, 12));
		reset.setForeground(new Color(0, 0, 0));
		reset.setBackground(new Color(255, 255, 255));
		reset.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		reset.setBounds(453, 367, 61, 23);
		panel.add(reset);
	}
}

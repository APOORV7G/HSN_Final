import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFFont;

public class Frame4 {

	private JFrame frame;
	String sheetName = "Data";
	Sheet sheet;
	Workbook workbook;
	Row EmptyRow , newRow,total,cgst,sgst ;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame4 window = new Frame4();
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
	public Frame4() {
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
		
		
        int colNums[] = {1,2,3,4,5,6,7,8,9,10,11}; // Row number (starting from 0)
        int[] firstCellNum_1=new int[11];
        int[] lastCellNum_1=new int[11];
        try 
		{
            BufferedReader reader = new BufferedReader(new FileReader("temporary.txt"));
            String line;
            
            line = reader.readLine();
            reader.close();
                
                {
                	 try (FileInputStream fis = new FileInputStream(line);)
                              
                	 {		 workbook = WorkbookFactory.create(fis);
                           	sheet = workbook.getSheet(sheetName);

                            int firstRowNum = sheet.getFirstRowNum();
                            int lastRowNum = sheet.getLastRowNum();

                            for (int colNum : colNums)
                            {
                                int firstCellNum = -1;
                                int lastCellNum = -1;

                                for (int rowNum = firstRowNum; rowNum <= lastRowNum; rowNum++) 
                                {
                                    Row row = sheet.getRow(rowNum);
                                    if (row != null) {
                                        Cell cell = row.getCell(colNum);
                                        if (cell != null && cell.getCellType() == CellType.NUMERIC) 
                                        {
                                            if (firstCellNum == -1) 
                                            {
                                                firstCellNum = rowNum;
                                            }
                                            lastCellNum = rowNum;
                                        }
                                    }
                                }

                                if (firstCellNum != -1 && lastCellNum != -1) 
                                {
                                  
                                    
                                     
                                      firstCellNum_1[colNum-1]=firstCellNum;
                                      lastCellNum_1[colNum-1]=lastCellNum;
                                     
                                } else 
                                {
                                    System.out.println("No numeric cells found in column " + colNum);
                                }

                               
                            }
                        } catch (IOException e) 
                	 {
                            e.printStackTrace();
                        }
                    }
                int lastRowIndex = sheet.getLastRowNum();
                int newRowIndex = lastRowIndex + 1;
                EmptyRow = sheet.createRow(newRowIndex);
                newRow = sheet.createRow(newRowIndex+1);
                CellStyle borderedCellStyle = workbook.createCellStyle();
                XSSFFont boldFont = (XSSFFont) workbook.createFont();
                boldFont.setBold(true);
                borderedCellStyle.setFont(boldFont);
                borderedCellStyle.setBorderTop(BorderStyle.THIN);
                borderedCellStyle.setBorderBottom(BorderStyle.THIN);
                borderedCellStyle.setBorderLeft(BorderStyle.THIN);
                borderedCellStyle.setBorderRight(BorderStyle.THIN);

                Cell[] cells = new Cell[12];
                String[] cellValues = {" ", "8532 nos", "8532 amt", "8533 nos", "8533 amt",
                        "8536 nos", "8535 amt", "8541 nos", "8541 amt", "8542 nos", "8542 amt", "Total"};

                for (int i = 0; i < cellValues.length; i++) 
                {
                    cells[i] = newRow.createCell(i);
                    cells[i].setCellValue(cellValues[i]);
                   
                    cells[i].setCellStyle( borderedCellStyle);
                    
                }
                total=sheet.createRow(newRowIndex+2);	total.createCell(0).setCellValue("TOTAL");  total.getCell(0).setCellStyle(borderedCellStyle);
                cgst=sheet.createRow(newRowIndex+3); 	cgst.createCell(0).setCellValue("CGST");	cgst.getCell(0).setCellStyle(borderedCellStyle);
                sgst=sheet.createRow(newRowIndex+4);	sgst.createCell(0).setCellValue("SGST");	sgst.getCell(0).setCellStyle(borderedCellStyle);
                
                
                try 
        		{
                    
					@SuppressWarnings("resource")
					BufferedReader reader2 = new BufferedReader(new FileReader("temporary.txt"));
                    String line2;
                    
                    line2 = reader2.readLine();
                    reader.close();
                FileOutputStream fileOutputStream = new FileOutputStream(line2);
                workbook.write(fileOutputStream);
                fileOutputStream.close();
        		 } catch (IOException e) 
           	 {
                       e.printStackTrace();
                   }
        } 
        catch (IOException e1) 
		{
            System.out.println("An error occurred while reading the file: " + e1.getMessage());
        }
         
	}

}

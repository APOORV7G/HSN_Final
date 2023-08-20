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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JTextArea;
import java.awt.FlowLayout;

public class Frame4 {

	private JFrame frame;
	String sheetName = "Data";
	Sheet sheet;
	Workbook workbook;
	Row EmptyRow , newRow,total,cgst,sgst,igsttotal,igst ;
	int i,j;
	
	
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
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		frame.setResizable(false);
		
		JTextArea txtrYourFileIs = new JTextArea();
		txtrYourFileIs.setText("Your file is ready. Thank You");
		txtrYourFileIs.setEditable(false);
		frame.getContentPane().add(txtrYourFileIs);
		
		
        int colNums[] = {1,2,3,4,5,6,7,8,9,10,11}; // Row number (starting from 0)
        char[] chars = new char[colNums.length];
        for (int i = 0; i < colNums.length; i++) {
            chars[i] = (char) (colNums[i] + 65);
        }

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
                            try (FileInputStream fis1 = new FileInputStream(line);
                                    Workbook workbook1 = new XSSFWorkbook(fis1)) {

                                  
                                   for (Row row : sheet) {
                                       for (Cell cell : row) {
                                    	   if (cell != null && cell.getCellType() == CellType.STRING) {
                                               String cellValue = cell.getStringCellValue();
                                               try {
                                                   if (cellValue.contains(".")) {
                                                       double numericValue = Double.parseDouble(cellValue);
                                                       // Convert text cell to a double cell value
                                                       cell.setCellValue(numericValue);
                                                   } else {
                                                       int numericValue = Integer.parseInt(cellValue);
                                                       // Convert text cell to an integer cell value
                                                       cell.setCellValue(numericValue);
                                                   }
                                               } catch (NumberFormatException ignored) {
                                                   // Ignore non-numeric strings
                                               }
                                           }
                                       }
                                   }
                                   

                               } catch (IOException e) {
                                   e.printStackTrace();
                               }

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
                                                firstCellNum++;
                                            }
                                            lastCellNum = rowNum;
                                            lastCellNum++;
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
                CellStyle plaincell=workbook.createCellStyle();
                plaincell.setBorderTop(BorderStyle.THIN);
                plaincell.setBorderBottom(BorderStyle.THIN); 
                plaincell.setBorderLeft(BorderStyle.THIN);
                plaincell.setBorderRight(BorderStyle.THIN);

                Cell[] cells = new Cell[12];
                String[] cellValues = {" ", "8532 nos", "8532 amt", "8533 nos", "8533 amt",
                        "8536 nos", "8536 amt", "8541 nos", "8541 amt", "8542 nos", "8542 amt", "Total"};

                for (int i = 0; i < cellValues.length; i++) 
                {
                    cells[i] = newRow.createCell(i);
                    cells[i].setCellValue(cellValues[i]);
                   
                    cells[i].setCellStyle( borderedCellStyle);
                    
                }
                total=sheet.createRow(newRowIndex+2);		total.createCell(0).setCellValue("TOTAL");  		total.getCell(0).setCellStyle(borderedCellStyle);
                cgst=sheet.createRow(newRowIndex+3); 		cgst.createCell(0).setCellValue("CGST");			cgst.getCell(0).setCellStyle(borderedCellStyle);
                sgst=sheet.createRow(newRowIndex+4);		sgst.createCell(0).setCellValue("SGST");			sgst.getCell(0).setCellStyle(borderedCellStyle);
                igsttotal=sheet.createRow(newRowIndex+5);	igsttotal.createCell(0).setCellValue("IGST-TOTAl");	igsttotal.getCell(0).setCellStyle(borderedCellStyle);
                igst=sheet.createRow(newRowIndex+6);		igst.createCell(0).setCellValue("IGST");	   		igst.getCell(0).setCellStyle(borderedCellStyle);
               for( i=1;i<=11;i++)
               {
            	   String formula="SUM("+chars[i-1]+firstCellNum_1[i-1]+":"+chars[i-1]+lastCellNum_1[i-1]+")-SumYellowCells("+chars[i-1]+firstCellNum_1[i-1]+":"+chars[i-1]+lastCellNum_1[i-1]+")";
            	   
            	   Cell cell=total.createCell(i);
            	   cell.setCellFormula(formula);
            	   cell.setCellStyle(plaincell);
            	   
            	   String formula2="SumYellowCells("+chars[i-1]+firstCellNum_1[i-1]+":"+chars[i-1]+lastCellNum_1[i-1]+")";
            	  
            	   Cell cell2=igsttotal.createCell(i);
            	   cell2.setCellFormula(formula2);
            	   cell2.setCellStyle(plaincell);
            	   
            	   
            	   
               }
               for( i=2,j=2;i<12&&j<12;i+=2,j+=2) 
               {
            	   String formula="(SUM("+chars[j-1]+firstCellNum_1[j-1]+":"+chars[j-1]+lastCellNum_1[j-1]+")-SumYellowCells("+chars[j-1]+firstCellNum_1[j-1]+":"+chars[j-1]+lastCellNum_1[j-1]+"))*0.09";
            	   Cell cell3=cgst.createCell(i);
            	   cell3.setCellFormula(formula);
            	   cell3.setCellStyle(plaincell);
            	   
            	   Cell cell4=sgst.createCell(i);
            	   cell4.setCellFormula(formula);
            	   cell4.setCellStyle(plaincell);
            	   
            	   String formula2="(SumYellowCells("+chars[i-1]+firstCellNum_1[i-1]+":"+chars[i-1]+lastCellNum_1[i-1]+"))*0.18";
            	   Cell cell5=igst.createCell(i);
            	   cell5.setCellFormula(formula2);
            	   cell5.setCellStyle(plaincell);
            	   
            	  
            	   
               }
               String formula="(SUM("+chars[j-2]+firstCellNum_1[j-2]+":"+chars[j-2]+lastCellNum_1[j-2]+")-SumYellowCells("+chars[j-2]+firstCellNum_1[j-2]+":"+chars[j-2]+lastCellNum_1[j-2]+"))*0.09";
               Cell cell6=cgst.createCell(i-1);
               cell6.setCellFormula(formula);
               cell6.setCellStyle(plaincell);
               Cell cell7=sgst.createCell(i-1);
               cell7.setCellFormula(formula);
               cell7.setCellStyle(plaincell);
               
               String formula2="(SumYellowCells("+chars[j-2]+firstCellNum_1[j-2]+":"+chars[j-2]+lastCellNum_1[j-2]+"))*0.18";
        	   Cell cell8=igst.createCell(i-1);
        	   cell8.setCellFormula(formula2);
        	   cell8.setCellStyle(plaincell);
               
        	   int columnToAutoSize = 0;
        	   int lastRowIndex2 = sheet.getLastRowNum();
        	   for (int i = 0; i <= lastRowIndex2; i++) 
        	   {
        	       Row row = sheet.getRow(i);
        	       if (row != null) 
        	       {
        	           Cell cell = row.getCell(columnToAutoSize);
        	           if (cell != null)
        	           {
        	               sheet.autoSizeColumn(columnToAutoSize); // Auto-size the column
        	           }
        	       }
        	   }
               
               
        	  
                
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
         frame.pack();
	}
}

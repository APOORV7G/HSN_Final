import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class TEST1 {
    public static void main(String[] args) {
        
        String sheetName = "Data";
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
                	 try (FileInputStream fis = new FileInputStream(line);
                             Workbook workbook = new XSSFWorkbook(fis)) {
                            Sheet sheet = workbook.getSheet(sheetName);

                            int firstRowNum = sheet.getFirstRowNum();
                            int lastRowNum = sheet.getLastRowNum();

                            for (int colNum : colNums) {
                                int firstCellNum = -1;
                                int lastCellNum = -1;

                                for (int rowNum = firstRowNum; rowNum <= lastRowNum; rowNum++) {
                                    Row row = sheet.getRow(rowNum);
                                    if (row != null) {
                                        Cell cell = row.getCell(colNum);
                                        if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                                            if (firstCellNum == -1) {
                                                firstCellNum = rowNum;
                                            }
                                            lastCellNum = rowNum;
                                        }
                                    }
                                }

                                if (firstCellNum != -1 && lastCellNum != -1) {
                                  
                                    
                                     
                                      firstCellNum_1[colNum-1]=firstCellNum;
                                      lastCellNum_1[colNum-1]=lastCellNum;
                                     
                                } else {
                                    System.out.println("No numeric cells found in column " + colNum);
                                }

                               
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                
               
        } 
        catch (IOException e1) 
		{
            System.out.println("An error occurred while reading the file: " + e1.getMessage());
        }
        for (int element : colNums) {
            System.out.print(element+" ");
        }
        System.out.println();
        for (int element : firstCellNum_1) {
            System.out.print(element+" ");
        } System.out.println();
        for (int element : lastCellNum_1) {
            System.out.print(element+" ");
        }
    }
}

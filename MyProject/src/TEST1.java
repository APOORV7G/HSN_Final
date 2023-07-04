import org.apache.poi.ss.usermodel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TEST1 extends JFrame {
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

    private JButton submitButton;

    private Workbook workbook;
    private Sheet sheet;
    private int rowIndex;

    public TEST1() {
        initializeUI();

        // Assuming you want to read data from the first sheet (index 0).
        try (FileInputStream fis = new FileInputStream("temporary.xlsx")) {
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheetAt(0);
            rowIndex = 0;

            // Initialize the text fields with the first row values.
            Row firstRow = sheet.getRow(0);
            if (firstRow != null) {
                textField.setText(getStringCellValue(firstRow, 0));
                textField_1.setText(getStringCellValue(firstRow, 1));
                textField_2.setText(getStringCellValue(firstRow, 2));
                textField_3.setText(getStringCellValue(firstRow, 3));
                textField_4.setText(getStringCellValue(firstRow, 4));
                textField_5.setText(getStringCellValue(firstRow, 5));
                textField_6.setText(getStringCellValue(firstRow, 6));
                textField_7.setText(getStringCellValue(firstRow, 7));
                textField_8.setText(getStringCellValue(firstRow, 8));
                textField_9.setText(getStringCellValue(firstRow, 9));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeUI() {
        setTitle("Excel Data Reader/Writer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        textField = new JTextField(20);
        add(textField);

        textField_1 = new JTextField(20);
        add(textField_1);

        textField_2 = new JTextField(20);
        add(textField_2);

        textField_3 = new JTextField(20);
        add(textField_3);

        textField_4 = new JTextField(20);
        add(textField_4);

        textField_5 = new JTextField(20);
        add(textField_5);

        textField_6 = new JTextField(20);
        add(textField_6);

        textField_7 = new JTextField(20);
        add(textField_7);

        textField_8 = new JTextField(20);
        add(textField_8);

        textField_9 = new JTextField(20);
        add(textField_9);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeValues();
                readNextRow();
            }
        });
        add(submitButton);

        pack();
        setLocationRelativeTo(null);
    }

    private String getStringCellValue(Row row, int columnIndex) {
        Cell cell = row.getCell(columnIndex);
        return (cell != null) ? cell.getStringCellValue() : "";
    }

    private void readNextRow() {
        if (rowIndex < sheet.getLastRowNum() + 1) {
            Row row = sheet.getRow(rowIndex);
            if (row != null) {
                textField.setText(getStringCellValue(row, 0));
                textField_1.setText(getStringCellValue(row, 1));
                textField_2.setText(getStringCellValue(row, 2));
                textField_3.setText(getStringCellValue(row, 3));
                textField_4.setText(getStringCellValue(row, 4));
                textField_5.setText(getStringCellValue(row, 5));
                textField_6.setText(getStringCellValue(row, 6));
                textField_7.setText(getStringCellValue(row, 7));
                textField_8.setText(getStringCellValue(row, 8));
                textField_9.setText(getStringCellValue(row, 9));
            }

            rowIndex++;
        } else {
            clearAllTextFields();
        }
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
    }

    private void writeValues() {
        Row row = sheet.createRow(rowIndex);

        row.createCell(0).setCellValue(textField.getText());
        row.createCell(1).setCellValue(textField_1.getText());
        row.createCell(2).setCellValue(textField_2.getText());
        row.createCell(3).setCellValue(textField_3.getText());
        row.createCell(4).setCellValue(textField_4.getText());
        row.createCell(5).setCellValue(textField_5.getText());
        row.createCell(6).setCellValue(textField_6.getText());
        row.createCell(7).setCellValue(textField_7.getText());
        row.createCell(8).setCellValue(textField_8.getText());
        row.createCell(9).setCellValue(textField_9.getText());

        clearAllTextFields();

        try (FileOutputStream fos = new FileOutputStream("temporary.xlsx")) {
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TEST1().setVisible(true);
            }
        });
    }
}

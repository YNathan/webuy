package controllers; /**
 * Created by jacky on 08/05/2017.
 */

/*import Entity.Date;
import Entity.Drive;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
*/
public class ReadExcel {

 /*   private String inputFile = "C:/Users/jacky/Desktop/ReceiptsForUser.xls";

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void read() throws IOException {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        int numberOfREalRow = 0;
        Double totalAmount = 0.0;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            // Loop over first 10 column and lines
            for (int i = 0; i < sheet.getRows(); i++) {
                Cell cellPrice = sheet.getCell(4, i);
                CellType typePrice = cellPrice.getType();


                if (typePrice == CellType.NUMBER) {
                    Double dCurrentPrice = Double.parseDouble(cellPrice.getContents());
                    totalAmount += dCurrentPrice;
                    System.out.println("  \t Price :"
                            + cellPrice.getContents());
                    numberOfREalRow++;
                }
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
        System.out.println("Number Of REal Row's is: " + numberOfREalRow);
        System.out.println("Total Price Spended For Taxi's : " + totalAmount);
    }

    public void getDateAndPrice(ArrayList<Drive> drives) throws IOException {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        int numberOfREalRow = 0;
        Double totalAmount = 0.0;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            // Loop over first 10 column and lines
            for (int i = 0; i < sheet.getRows(); i++) {
                Cell cellOrderNumber = sheet.getCell(0, i);
                Cell cellDate = sheet.getCell(1, i);
                Cell cellOriginAddress = sheet.getCell(2, i);
                Cell cellDestinationAddress = sheet.getCell(3, i);
                Cell cellPrice = sheet.getCell(4, i);

                // Getting the type of cell's
                CellType typeOrderNumber = cellOrderNumber.getType();
                CellType typeDate = cellDate.getType();
                CellType typePrice = cellPrice.getType();

                if (typePrice == CellType.NUMBER) {
                    Double dCurrentPrice = Double.parseDouble(cellPrice.getContents());
                    drives.add(new Drive(Long.parseLong(cellOrderNumber.getContents().replace(",", "")), new Date(cellDate.getContents()), dCurrentPrice, cellOriginAddress.getContents(), cellDestinationAddress.getContents()));
                    totalAmount += dCurrentPrice;
                    numberOfREalRow++;
                }
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
        System.out.println("Total Price Spended For Taxi's : " + totalAmount);
    }

    public static void main(String[] args) throws IOException {
        ReadExcel test = new ReadExcel();
        test.setInputFile("C:/Users/jacky/Desktop/ReceiptsForUser.xls");
        test.read();
    }*/

}
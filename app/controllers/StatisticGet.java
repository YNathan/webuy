package controllers;

import Entity.Date;
import Entity.Drive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by jacky on 30/11/2017.
 */
public class StatisticGet {

    private String inputFile = "C:/Users/jacky/Desktop/ReceiptsForUser.xls";

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public static HashMap<Date, Double> listPricePerDateStatistic = new HashMap<>();

    public ArrayList<Drive> getStatistics() throws IOException {
        ArrayList<Drive> drivesToReturn = new ArrayList<>();
        Date date = new Date();
        /*ReadExcel test = new ReadExcel();
        test.setInputFile("C:/Users/jacky/Desktop/ReceiptsForUser.xls");
        test.getDateAndPrice(drivesToReturn);*/


        // Sorting and ordering the data
        Collections.sort(drivesToReturn, (drive1, drive2) -> {
            int nNumberToReturn = -1;
            if (drive1.getDate().isBiguer(drive2.getDate())) {
                nNumberToReturn = 1;
            }
            return nNumberToReturn;
        });

        // Output in order
        for (Drive currDrive : drivesToReturn) {
            System.out.println(currDrive);
        }

        return drivesToReturn;
    }
}

package read_data;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestData {

    File excelFile = new File("src/test/resources/TestData.xlsx");
    FileInputStream fileInputStream;

    XSSFWorkbook workbook;
    XSSFSheet sheet1;

    @Before
    public void setup() throws IOException {
        fileInputStream = new FileInputStream(excelFile);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet1 = workbook.getSheet("Sheet1");
    }


    @Test

    public void getAllRow() throws IOException, InvalidFormatException {

        for (int i = sheet1.getFirstRowNum(); i < sheet1.getLastRowNum(); i++) {

            XSSFRow rows = sheet1.getRow(i);
            System.out.print("| ");

            for (int j = rows.getFirstCellNum(); j < rows.getLastCellNum(); j++) {
                XSSFCell cell = rows.getCell(j);
                System.out.print(cell + " | ");
            }

            System.out.println();


        }


    }

    @Test
    public void businessColumn() {

        String columnName="BusinessType";
        XSSFRow row1=sheet1.getRow(0);
        int index = -1;



        for (int i = row1.getFirstCellNum(); i < row1.getLastCellNum(); i++) {

            XSSFCell tempcell = row1.getCell(i);

            if (tempcell.getStringCellValue().equalsIgnoreCase(columnName)) {
                index = i;
            }
        }


            for (int j = sheet1.getFirstRowNum(); j <sheet1.getLastRowNum(); j++) {



                    XSSFRow tempRow = sheet1.getRow(j);

                    System.out.print(tempRow.getCell(index));
                }



        }
    }


package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pojos.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelUtils {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("/Users/redcrow/Desktop/Projects/userData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

//        Row row = sheet.getRow(0);
//        Cell cell = row.getCell(0);

        //System.out.println(cell);
//        int nowNum = sheet.getPhysicalNumberOfRows();
//        int cellCount = row.getPhysicalNumberOfCells();
//        int count = 0;
//        for(int i = 0; i < 5; i++) {
//            System.out.println( sheet.getRow(0).getCell(i) + ":   " + sheet.getRow(1).getCell(i));
//            count ++;
//        }

        // Another way
//        int rowNum = sheet.getPhysicalNumberOfRows();
//        for (int i = 0; i < rowNum; i++){
//            Row row = sheet.getRow(i);
//            int cellCount = row.getPhysicalNumberOfCells();
//            for(int j = 0; j < cellCount; j++){
//                System.out.print(row.getCell(j) + " | ");
//            }
//            System.out.println();
//        }


//        Iterator<Row> rowIterator = sheet.iterator();
//        while (rowIterator.hasNext()) {
//            Row row = rowIterator.next();
//            Iterator<Cell> cellIterator = row.iterator();
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
//                System.out.print(cell + " | ");
//            }
//            System.out.println();
//        }

//        //Sheet sheet1 = workbook.createSheet("LoginUsers");
//        Sheet sheet1 = workbook.getSheet("LoginUsers");
//        Row row = sheet1.createRow(0);
//        Cell cell = row.createCell(0);
//        cell.setCellValue("First Name");
//        row.createCell(1).setCellValue("Last Name");
//        row.createCell(2).setCellValue("Phone Number");
//
//        FileOutputStream fileOutputStream = new FileOutputStream("/Users/redcrow/Desktop/Projects/userData.xlsx");
//        workbook.write(fileOutputStream);

        //Sheet sheet2 = workbook.createSheet("My Group");
       // Sheet sheet2 = workbook.getSheet("LoginUsers");
       // Row row = sheet2.createRow(0);
//        Cell cell = row.createCell(0);
//        cell.setCellValue("First Name");
//        row.createCell(1).setCellValue("Last Name");
//        row.createCell(2).setCellValue("Phone Number");



//        Sheet myGroupSheet = workbook.createSheet("My Group");
//        String[] header = {"First name", "email", "group name"};
//        Row row = myGroupSheet.createRow(0);
//        for (int i = 0; i < header.length; i++) {
//            row.createCell(i).setCellValue(header[i]);
//        }
//        Row row1 = myGroupSheet.createRow(1);
//        row1.createCell(0).setCellValue("Kuba");
//        row1.createCell(1).setCellValue("kuba@gmail.com");
//        row1.createCell(2).setCellValue("TLA");

//        String[] header = {"First name", "email", "group name"};
//        String[] names = {"erdi", "victoria", "lena", "greg", "korn", "asim"};
//        String[] emails = {"erdi@gmail.com", "victoria@gmail.com", "lena@gmail.com", "greg@gmail.com", "korn@gmail.com", "asim@gmail.com"};
//        String teamName = "dreamRunner";
//
//        Sheet myGroupSheet = workbook.createSheet("My Group");
//
//        Row row = myGroupSheet.createRow(0);
//        for (int i = 0; i < header.length; i++) {
//            row.createCell(i).setCellValue(header[i]);
//
//            for(int j = 0; j < names.length; j++) {
//                Row row1 = myGroupSheet.createRow(j + 1);
//                row1.createCell(0).setCellValue(names[j]);
//                row1.createCell(1).setCellValue(emails[j]);
//                row1.createCell(2).setCellValue(teamName);
//            }
//        }



        User user;
        String[] headers = {"First name","Last name", "Phone number", "Email", "Role"};
        String[] role = {"Student", "Instructor", "Mentor"};
        Sheet usersSheet = workbook.createSheet("users");
        Row row = usersSheet.createRow(0);
        int count = 0;
        for (int i = 0; i < headers.length; i++) {
            row.createCell(i).setCellValue(headers[i]);
            for(int j = 0; j < 20; j++) {
                if(count == 3) { count = 0; }
                user = new User();
                Row row1 = usersSheet.createRow(j + 1);
                row1.createCell(0).setCellValue(user.getFirstName());
                row1.createCell(1).setCellValue(user.getLastName());
                row1.createCell(2).setCellValue(user.getPhoneNumber());
                row1.createCell(3).setCellValue(user.getEmail());
                row1.createCell(4).setCellValue(role[count]);
                count++;
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/redcrow/Desktop/Projects/userData.xlsx");
        workbook.write(fileOutputStream);
    }
    
}

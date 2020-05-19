
package com.interview.demo.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class Main {

    public static void main(String[] args) throws Exception {
        String filepath = "/home/lin/桌面/cfg.xls";
        final File file = new File(filepath);
        System.out.println("file.canRead() = " + file.canRead());
        InputStream inputStream = new FileInputStream(file);
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row;
        for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell((short) j);//Cell
                if (cell != null) {
                    String s = getCellContent(cell);//读取单元格String内容
                    System.out.println(s);
                } else {
                    System.out.println("nullllllll");
                }
            }
        }
    }

//单元格格式不同 ，需要分开获取内容，数字 字符串，就是设置为一样的也有问题。用String获取
//如 cell.getStringCellValue() 会报这样的错：Cannot get a text value from a numeric cell。
    public static String getCellContent(Cell cell) {
        String cellValue = "null";
        if (null != cell) {
            switch (cell.getCellType()) {  // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
                case 0:
                    cellValue = String.valueOf((int) cell.getNumericCellValue());
                    break;
                case 1:
                    cellValue = cell.getStringCellValue();
                    break;
                case 2:
                    cellValue = cell.getNumericCellValue() + "";
                    break;
                case 3:
                    cellValue = "";
                    break;
                case 4:
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                case 5:
                    cellValue = String.valueOf(cell.getErrorCellValue());
                    break;
            }
        } else {
            cellValue = "";
        }
        return cellValue;

    }
}
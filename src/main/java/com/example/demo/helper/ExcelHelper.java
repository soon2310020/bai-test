package com.example.demo.helper;

import com.example.demo.model.Lic_info;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "STT","Tên doanh nghiệp","Từ năm","Đến năm","Số giấy phép","Loại giấy phép" };
    static String SHEET = "lic_info";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Lic_info> excelToLic(InputStream is,Long id) {
        SimpleDateFormat dtf= new SimpleDateFormat("dd/MM/yyyy");
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<Lic_info> lic_infos = new ArrayList<Lic_info>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Lic_info lic_info = new Lic_info();
                lic_info.setCompany_id(id);

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {


                        case 2:
                            try {
                                lic_info.setEffect_date(dtf.parse(currentCell.getStringCellValue()));
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }

                            break;

                        case 3:
                            try {
                                lic_info.setExpired_date(dtf.parse(currentCell.getStringCellValue()));
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                            break;
                        case 4:
                            lic_info.setLic_number(currentCell.getStringCellValue());
                            break;
                        default:
                            break;
                    }

                    cellIdx++;
                }
                lic_infos.add(lic_info);
            }

            workbook.close();

            return lic_infos;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}

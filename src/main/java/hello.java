import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

public class hello {
    //url https://github.com/chengjiao9295/usingGit.git
    public void readExcel() throws IOException {
        FileInputStream input = new FileInputStream("C:\\Users\\Chengjiao\\Desktop\\credit.xlsx");
        Workbook workbook = new XSSFWorkbook(input);
        Sheet sheet = workbook.getSheet("测试");
        Row row = sheet.getRow(6);
        Cell cell = row.getCell(0);
        int count = sheet.getLastRowNum() + 1;//总行数
        for (int i = 1; i < count; i++) {
            //isMergedRegion(sheet, i,0);
            Cell cl = sheet.getRow(i).getCell(0);
            int r = cl.getRowIndex();
            int c = cl.getColumnIndex();
            System.out.println(cl.toString() + r + "  " + c);
        }
        // isMergedRegion(sheet,count,0);
        System.out.println("读取单元格内容:" + sheet.getNumMergedRegions());

    }

    public String addReportByExcel()
            throws IOException {
        String message = "Import success";
//
//        boolean isE2007 = false;    //判断是否是excel2007格式
//        if(fileName.endsWith("xlsx")){
//            isE2007 = true;
//        }
        return message;
    }


}



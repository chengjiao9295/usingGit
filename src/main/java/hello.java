import java.math.BigDecimal;
import java.util.Date;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import static org.apache.poi.ss.usermodel.CellType.*;

public class hello {
    //url https://github.com/chengjiao9295/usingGit.git
   public void readExcel() throws IOException{
       FileInputStream input=new FileInputStream("C:\\Users\\Chengjiao\\Desktop\\credit.xlsx");
       Workbook workbook=new XSSFWorkbook(input);
       Sheet sheet=workbook.getSheet("测试");
       Row row=sheet.getRow(6);
       Cell cell=row.getCell(0);
       int count = sheet.getLastRowNum()+1;//总行数
       for(int i = 1; i < count;i++){
           //isMergedRegion(sheet, i,0);
           Cell cl =sheet.getRow(i).getCell(0);
           int r=cl.getRowIndex();
           int c=cl.getColumnIndex();
           System.out.println(cl.toString()+r+"  "+c);
       }
      // isMergedRegion(sheet,count,0);
       System.out.println("读取单元格内容:"+sheet.getNumMergedRegions());

   }
    public String addReportByExcel()
            throws IOException{
        String message = "Import success";
//
//        boolean isE2007 = false;    //判断是否是excel2007格式
//        if(fileName.endsWith("xlsx")){
//            isE2007 = true;
//        }

        int rowIndex = 0;
        int columnIndex = 0;
        try {
            FileInputStream input=new FileInputStream("C:\\Users\\Chengjiao\\Desktop\\credit.xlsx");
            Workbook workbook=new XSSFWorkbook(input);
            Sheet sheet=workbook.getSheet("测试");   //获得第一个表单

            //System.out.println("总行数:"+sheet.getLastRowNum());

            List<CellRangeAddress> cras = getCombineCell(sheet);
            //isMergedRegion(Sheet sheet,int row ,int column);判断是不是合并单元格\
            int count = sheet.getLastRowNum()+1;//总行数

            List<InspectionReport> irs = new ArrayList<>();
            for(int i = 1; i < count;i++){
                rowIndex = i;
                Row row = sheet.getRow(i);
                InspectionReport ir = new InspectionReport();

                ir.setReportName(getCellValue(row.getCell(0)));
                ir.setShift(Double.valueOf(getCellValue(row.getCell(1))).intValue());
                ir.setLine(getCellValue(row.getCell(2)));
                ir.setStationCode(getCellValue(row.getCell(3)));
                ir.setArea(Double.valueOf(getCellValue(row.getCell(4))).intValue());
                ir.setReportStatus(Double.valueOf(getCellValue(row.getCell(5))).intValue());

                List<InspectionItem> items = new ArrayList<>();
                if(isMergedRegion(sheet,i,0)){
                    int lastRow = getRowNum(cras,sheet.getRow(i).getCell(0),sheet);

                    for(;i<=lastRow;i++){
                        row = sheet.getRow(i);
                        InspectionItem item = new InspectionItem();
                        item.setItem(getCellValue(row.getCell(6)));
                        item.setMethod(getCellValue(row.getCell(7)));
                        item.setMode(getCellValue(row.getCell(8)));
                        item.setStandardValue(getCellValue(row.getCell(9)));
                        item.setDeviationValue(getCellValue(row.getCell(10)));
                        String pinci = getCellValue(row.getCell(11));
                        Double d = Double.valueOf(pinci);
                        item.setFrequency(d.intValue());
                        items.add(item);
                    }
                    i--;
                }else{
                    row = sheet.getRow(i);
                    InspectionItem item = new InspectionItem();
                    item.setItem(getCellValue(row.getCell(6)));
                    item.setMethod(getCellValue(row.getCell(7)));
                    item.setMode(getCellValue(row.getCell(8)));
                    item.setStandardValue(getCellValue(row.getCell(9)));
                    item.setDeviationValue(getCellValue(row.getCell(10)));
                    String pinci = getCellValue(row.getCell(11));
                    Double d = Double.valueOf(pinci);
                    item.setFrequency(d.intValue());
                    items.add(item);
                }
                ir.setItems(items);
                irs.add(ir);

            }

//            XaResult<List<InspectionReport>> saved = inspectionReportService.createByXls(1l, irs);
//            message = saved.getMessage();

           /*JSONArray js= new JSONArray();
           js.addAll(irs);
           System.out.println(js.toJSONString());*/

        } catch (Exception ex) {
            //xr.setMessage("Import failed, please check the data in "+rowIndex+" rows "+columnIndex+" columns ");
           message =  "Import failed, please check the data in "+rowIndex+" rows ";
        }
        return message;
    }
    /**
     * 获取单元格的值
     * @param cell
     * @return
     */
    public String getCellValue(Cell cell){
        if(cell == null) return "";
        if(cell.getCellType() == Cell.CELL_TYPE_STRING){
            return cell.getStringCellValue();
        }else if(cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){
            return String.valueOf(cell.getBooleanCellValue());
        }else if(cell.getCellType() == Cell.CELL_TYPE_FORMULA){
            return cell.getCellFormula() ;
        }else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
            return String.valueOf(cell.getNumericCellValue());
        }
        return "";
    }
    /**
     * 合并单元格处理,获取合并行
     * @param sheet
     * @return List<CellRangeAddress>
     */
    public List<CellRangeAddress> getCombineCell(Sheet sheet)
    {
        List<CellRangeAddress> list = new ArrayList<CellRangeAddress>();
        //获得一个 sheet 中合并单元格的数量
        int sheetmergerCount = sheet.getNumMergedRegions();
        //遍历所有的合并单元格
        for(int i = 0; i<sheetmergerCount;i++)
        {
            //获得合并单元格保存进list中
            CellRangeAddress ca = sheet.getMergedRegion(i);
            list.add(ca);
        }
        return list;
    }

    private int getRowNum(List<CellRangeAddress> listCombineCell,Cell cell,Sheet sheet){
        int xr = 0;
        int firstC = 0;
        int lastC = 0;
        int firstR = 0;
        int lastR = 0;
        for(CellRangeAddress ca:listCombineCell)
        {
            //获得合并单元格的起始行, 结束行, 起始列, 结束列
            firstC = ca.getFirstColumn();
            lastC = ca.getLastColumn();
            firstR = ca.getFirstRow();
            lastR = ca.getLastRow();
            if(cell.getRowIndex() >= firstR && cell.getRowIndex() <= lastR)
            {
                if(cell.getColumnIndex() >= firstC && cell.getColumnIndex() <= lastC)
                {
                    xr = lastR;
                }
            }

        }
        return xr;

    }
    /**
     * 判断单元格是否为合并单元格，是的话则将单元格的值返回
     * @param listCombineCell 存放合并单元格的list
     * @param cell 需要判断的单元格
     * @param sheet sheet
     * @return
     */
    public String isCombineCell(List<CellRangeAddress> listCombineCell,Cell cell,Sheet sheet)
            throws Exception{
        int firstC = 0;
        int lastC = 0;
        int firstR = 0;
        int lastR = 0;
        String cellValue = null;
        for(CellRangeAddress ca:listCombineCell)
        {
            //获得合并单元格的起始行, 结束行, 起始列, 结束列
            firstC = ca.getFirstColumn();
            lastC = ca.getLastColumn();
            firstR = ca.getFirstRow();
            lastR = ca.getLastRow();
            if(cell.getRowIndex() >= firstR && cell.getRowIndex() <= lastR)
            {
                if(cell.getColumnIndex() >= firstC && cell.getColumnIndex() <= lastC)
                {
                    Row fRow = sheet.getRow(firstR);
                    Cell fCell = fRow.getCell(firstC);
                    cellValue = getCellValue(fCell);
                    break;
                }
            }
            else
            {
                cellValue = "";
            }
        }
        return cellValue;
    }

    /**
     * 获取合并单元格的值
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    public String getMergedRegionValue(Sheet sheet ,int row , int column){
        int sheetMergeCount = sheet.getNumMergedRegions();

        for(int i = 0 ; i < sheetMergeCount ; i++){
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if(row >= firstRow && row <= lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    return getCellValue(fCell) ;
                }
            }
        }

        return null ;
    }


    /**
     * 判断指定的单元格是否是合并单元格
     * @param sheet
     * @param row 行下标
     * @param column 列下标
     * @return
     */
    private boolean isMergedRegion(Sheet sheet,int row ,int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if(row >= firstRow && row <= lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    return true;
                }
            }
        }
        return false;
    }



    public static void main(String []args) throws IOException {

        hello a = new hello();

        a.addReportByExcel();
    }


}

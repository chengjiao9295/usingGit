import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.beans.PropertyDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class exportExcel  {


//    @Resource
//    private IbaseInfoService baseInfoService;

    /**
     *
     * @Description 考核评价汇总--查询操作
     * @param rows
     * @param page
     * @param sort
     * @param order
     * @param key
     * @param start_time
     * @param end_time
     * @param id_postduty
     * @param question_type
     * @return PageResult
     * @throws Exception
     *
     */
 //   @Override
//    public PageResult listAllVassessEvaluationSummary(int rows,int page,String sort, String order,String key,String start_time, String end_time,
//                                                      String id_postduty,String question_type) throws Exception {
//        if(StringUtils.isBlank(key)) {
//            key = "";
//        }
//        List<Object> ls_param = new ArrayList<Object>();
//        String hql = "select u from VAssessEvaluation u where (del_flag is null or del_flag != '1')";
//        String hqlCount = "select count(u) from VAssessEvaluation u where (del_flag is null or del_flag != '1')";
//        if(StringUtils.isNotBlank(key)) {
//            hql+= " and ( instr(type,?) > 0 or instr(updateuser,?)>0 or instr(updatetime,?)>0 )";
//            hqlCount += " and ( instr(type,?) > 0 or instr(updateuser,?)>0 or instr(updatetime,?)>0 )";
//            ls_param.add(key);
//            ls_param.add(key);
//            ls_param.add(key);
//        }
//        if(StringUtils.isNotBlank(start_time)) {
//            hql += " and find_date >= ?";
//            hqlCount += " and find_date >= ?";
//            ls_param.add(start_time);
//        }
//        if(StringUtils.isNotBlank(end_time)) {
//            hql += " and find_date <= ?";
//            hqlCount += " and find_date <= ?";
//            ls_param.add(end_time);
//        }
//        if(StringUtils.isNotBlank(question_type)) {
//            hql += " and id_question_type = ?";
//            hqlCount += " and id_question_type = ?";
//            ls_param.add(question_type);
//        }
//        if(StringUtils.isNotBlank(id_postduty)) {
//            hql += " and id_postduty = ?";
//            hqlCount += " and id_postduty = ?";
//            ls_param.add(id_postduty);
//        }
//        if(StringUtils.isNotBlank(sort)&&StringUtils.isNotBlank(order)) {
//            hql += " order by " + sort + " " + order;
//        }
//        list = baseInfoService.listQueryByHql(hql,ls_param,rows,page);
//        Object total = baseInfoService.getObjectByHql(hqlCount,ls_param);
//        PageResult result = new PageResult();
//        if (list != null) {
//            result.setRows(list);
//            if (total != null) {
//                result.setTotal(Integer.parseInt(total.toString()));
//            } else {
//                result.setTotal(0);
//            }
//        }
//        return result;
//    }

    /**
     *
     * @Description 考核评价汇总--导出功能
     * @param key_columns
     * @param value_columns
     * @return HSSFWorkbook
     * @throws Exception
     *
     */

    public HSSFWorkbook exportExecl(List<VAssessEvaluation> list,String[] key_columns, String[] value_columns) throws Exception {
        List<List<String>> list1 = new ArrayList<>();
        for (VAssessEvaluation v : list) {
            List<String> list2 = new ArrayList<>();
            for (int i = 0; i < key_columns.length; i++) {
                String field = ExportUtil.getFiled(v, key_columns[i]);
                if("performance".equals(key_columns[i])){
                    if(v.getPerformance()!=0) {
                        list2.add("-"+field);
                    }else {
                        list2.add(field);
                    }
                }else {
                    list2.add(field);
                }
            }
            list1.add(list2);
        }
        int[] arr = {1,2,3,5}; //要合并的列，从0开始
        int judge = 10; //判断字段，没有则为-1
        return ExportUtil.exportAutoCell("考核评价汇总",key_columns,value_columns,list1,arr,judge);
    }

    public static class ExportUtil {

        /**
         *
         * @Date 2018年6月19日 下午3:46:27
         * @Description 导出自动合并单元格
         * @Fcunction exportAutoCell
         * @param sheetName
         * @param key_columns
         * @param value_columns
         * @param list
         * @param field_arr
         * @param judge
         * @return HSSFWorkbook
         *
         */
        public  static HSSFWorkbook exportAutoCell(String sheetName,String[] key_columns,String[] value_columns,List<List<String>> list,int[] field_arr,int judge){
            //创建一个Excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();
            //创建一个工作表
            HSSFSheet sheet = workbook.createSheet(sheetName);
            //添加表头行
            HSSFRow hssfRow = sheet.createRow(0);
            //设置单元格格式
            HSSFCellStyle cellStyle = workbook.createCellStyle();
            //设置单元格边框

            cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); //水平居中
            cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); //垂直居中
            for (int i = 0; i < value_columns.length; i++) {
                //添加表头内容
                HSSFCell headCell = hssfRow.createCell(i);
                headCell.setCellValue(value_columns[i]);
                headCell.setCellStyle(cellStyle);
            }
            //把数据添加到excel
            for (int i = 0; i < list.size(); i++) { //每一行
                hssfRow = sheet.createRow(i + 1);
                for (int j = 0; j < list.get(i).size(); j++) { //每一行的每一格
                    //创建单元格，并设置值
                    HSSFCell cell = hssfRow.createCell(j);
                    cell.setCellValue(list.get(i).get(j));
                    cell.setCellStyle(cellStyle);

                }
            }

            //自动合并
            for (int k = 0; k < field_arr.length; k++) {
                int field = field_arr[k]; //要排序的字段
                int d = 0; //下次要合并的行
                int n = list.size()-1; //当前合并的行
                for (int i = list.size()-1; i >= 1; i--) { //每一行
                    if(i!=(n-d)) {
                        continue;
                    }
                    if(list.get(i).get(field).equals(list.get(i-1).get(field))){ //相邻的上下两行
                        if(judge!=-1) {
                            if(!list.get(i).get(judge).equals(list.get(i-1).get(judge))){
                                break;
                            }
                        }
                        int rowspan = 2;
                        d = rowspan;
                        for (int j = 2; i-j >= 0; j++) { //判断上下多行内容一样
                            n = i;
                            if(!list.get(i).get(field).equals(list.get(i-j).get(field))){
                                break;
                            }else{
                                if(judge!=-1) {
                                    if(!list.get(i).get(judge).equals(list.get(i-j).get(judge))){
                                        break;
                                    }
                                }
                                rowspan = j+1;
                                d = rowspan;
                            }
                        }
                        sheet.addMergedRegion(new CellRangeAddress(i-rowspan+2, i+1, field, field));
                    }else {
                        d = 0;
                        n = i-1;
                    }

                }
            }
            return workbook;
        }

        /**
         *
         * @Author zhangshizhe
         * @Date 2018年6月15日 下午1:53:52
         * @Description 利用反射获取get方法
         * @Fcunction getFiled
         * @param object
         * @param field
         * @return String
         *
         */
        public  static String getFiled(Object object, String field) {
            Class<? extends Object> clazz  = object.getClass();
            PropertyDescriptor pd = null;
            Method getMethod = null;
            try {
                pd = new PropertyDescriptor(field, clazz);
                if (null != pd) {
                    // 获取  这个 field 属性 的get方法
                    getMethod = pd.getReadMethod();
                    Object invoke = getMethod.invoke(object);
                    if(invoke==null) {
                        invoke = "";
                    }
                    return invoke.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }

    }

   public static void main(String[] args) throws Exception{
       List<VAssessEvaluation> list = new ArrayList<>();
        exportExcel a=new exportExcel();
       String[] key_columns={"find_date","question_type","question_property","content"
       ,"question_evalstandard","name_org","postduty_name","soleduty_type_label","soleduty_type_label"
       ,"username","performance","createname"};
       String[] value_columns={"发现日期","问题类别","问题属性","问题描述","评价标准","单位","岗位"
               ,"专职","被考核人员","扣分值","考核组成员"
       };
       VAssessEvaluation ab=new VAssessEvaluation();
       ab.setCk("ck");
       ab.setId("id");
       ab.setFind_date(new Date());
       ab.setQuestion_evalstandard("question_type");
       ab.setQuestion_property(1);
       ab.setContent("content");
       ab.setName_org("name_org");
       ab.setPostduty_name("postduty_name");
       ab.setPerformance(1);
       ab.setUsername("username");
       ab.setCreatename("createname");
       ab.setSoleduty_type_label("aaa");
       list.add(ab);
       list.add(ab);
       list.add(ab);
       list.add(ab);
       list.add(ab);
       VAssessEvaluation a1b=new VAssessEvaluation();
       a1b.setCk("ck11");
       a1b.setId("id1");
       a1b.setFind_date(new Date());
       a1b.setQuestion_evalstandard("question_type1");
       a1b.setQuestion_property(1);
       a1b.setContent("content11");
       a1b.setName_org("name_org");
       a1b.setPostduty_name("postduty_name1");
       a1b.setPerformance(1);
       a1b.setUsername("usernam11e");
       a1b.setCreatename("createname");
       a1b.setSoleduty_type_label("a1aa");
       list.add(a1b);
        a.exportExecl(list,key_columns,value_columns);
        try{
       HSSFWorkbook workbook = a.exportExecl(list,key_columns,value_columns);
       //写入Excel文件
            FileOutputStream fout = new FileOutputStream("E:/students.xls");

            workbook.write(fout);
       fout.close();

   } catch (Exception e) {
        e.printStackTrace();

    }


   }
}


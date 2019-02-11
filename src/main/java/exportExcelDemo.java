import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

//fundsMgmtBankParternerCPExtMapper.java

//List<FundsMgmtBankPartnerCPVOExt> queryRelatedData(String bankId);
//
////fundsMgmtBankParternerCPExtMapper.xml
//
//        <select id="queryRelatedData"
//        resultMap="com.orientsec.cleam.bean.ext.FundsMgmtBankPartnerCPVOExt"
//        parameterType="java.lang.String">
//        SELECT
//        cp.bankName, cp.contactor, cp.telephone,cp.address,cp.faxNum,cp.zipCode,
//        creditLimit.maxLimit as bankMaxLimit, creditLimit.startDate, creditLimit.endDate,
//        category.categoryName, category.maxLimit as categoryMaxLimit,
//        map.trdType, map.creditRate
//        from FundsMgmtBankPartnerCP cp left join
//        FundsMgmtBankCreditLimit creditLimit on cp.id = creditLimit.bankId
//        left join FundsMgmtBankCreditCategory category on creditLimit.id=category.bankCrdId
//        LEFT join FundsMgmtTradeCreditMap map on category.id = map.cateId
//        <trim prefix="WHERE" prefixOverrides="AND">
//        <if test="bankId != null and bankId!='' ">
//        AND cp.bankId=#{bankId, jdbcType=VARCHAR}
//        </if>
//        </trim>
//        order By cp.id DESC
//        </select>


public class exportExcelDemo {
    public <T> void exportExcel()throws SecurityException, IllegalArgumentException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException {
//        String bankId = param.getId();
//        if(StringUtils.isBlank(bankId)){
//            LoggerUtil.info("导出所有银行配置信息");
//        }else{
//            this.convertBankId(param) ;
//        }
//        bankId = param.getBankId();
//        FundsMgmtBankPartnerCPExtMapper extMapper = sqlSession.getMapper(FundsMgmtBankPartnerCPExtMapper.class);
//        List<FundsMgmtBankPartnerCPVOExt> dataSource= extMapper.queryRelatedData(bankId);
        String[] title = new String[]{"银行名称","联系人","电话","地址","传真号码","邮编","银行额度",
        "开始日期","结束日期","分类别名","授信额度","交易类型","折算率"};
        String colName[] = new String[]{"bankName","contactor","telephone","address","faxNum",
        "zipCode","bankMaxLimit","startDate","endDate","categoryName","categoryMaxLimit",
        "trdType","creditRate"};
        int[] mergeIndex ={0,9};//0:0-8;9:9-10
        Map<String, String> range = new HashMap<>();
        range.put("0","0-8");
        range.put("9","9-10");
        /*得到sheet下的数据集合*/
        List<VOExt> list = new ArrayList<>();
        VOExt vo = new VOExt();
        vo.setBankName("建设银行");
        vo.setContactor("张三");
        vo.setTelephone("15800629167");
        vo.setAddress("居家桥路");
        vo.setFaxNum("021928222");
        vo.setZipCode("200100");
        vo.setBankMaxLimit(new BigDecimal("1000"));
        vo.setStartDate(new Date());
        vo.setEndDate(new Date());
        vo.setCategoryName("债券");
        vo.setCategoryMaxLimit(new BigDecimal("1200"));
        vo.setTrdType(1);
        vo.setCreditRate(new BigDecimal("1400"));
        list.add(vo);
        vo = new VOExt();
        vo.setBankName("建设银行");
        vo.setContactor("张三");
        vo.setTelephone("15800629167");
        vo.setAddress("居家桥路");
        vo.setFaxNum("021928222");
        vo.setZipCode("200100");
        vo.setBankMaxLimit(new BigDecimal("1000"));
        vo.setStartDate(new Date());
        vo.setEndDate(new Date());
        vo.setCategoryName("债券");
        vo.setCategoryMaxLimit(new BigDecimal("1200"));
        vo.setTrdType(2);
        vo.setCreditRate(new BigDecimal("1400"));
        list.add(vo);
        vo = new VOExt();
        vo.setBankName("建设银行");
        vo.setContactor("张三");
        vo.setTelephone("15800629167");
        vo.setAddress("居家桥路");
        vo.setFaxNum("021928222");
        vo.setZipCode("200100");
        vo.setBankMaxLimit(new BigDecimal("1000"));
        vo.setStartDate(new Date());
        vo.setEndDate(new Date());
        vo.setCategoryName("融宝7号");
        vo.setCategoryMaxLimit(new BigDecimal("1200"));
        vo.setTrdType(1);
        vo.setCreditRate(new BigDecimal("1400"));
        list.add(vo);
        vo = new VOExt();
        vo.setBankName("工商银行");
        vo.setContactor("张三");
        vo.setTelephone("15800629167");
        vo.setAddress("居家桥路");
        vo.setFaxNum("021928222");
        vo.setZipCode("200100");
        vo.setBankMaxLimit(new BigDecimal("1000"));
        vo.setStartDate(new Date());
        vo.setEndDate(new Date());
        vo.setCategoryName("融宝7号");
        vo.setCategoryMaxLimit(new BigDecimal("1200"));
        vo.setTrdType(1);
        vo.setCreditRate(new BigDecimal("1400"));
        list.add(vo);
        vo = new VOExt();
        vo.setBankName("工商银行");
        vo.setContactor("张三");
        vo.setTelephone("15800629167");
        vo.setAddress("居家桥路");
        vo.setFaxNum("021928222");
        vo.setZipCode("200100");
        vo.setBankMaxLimit(new BigDecimal("1000"));
        vo.setStartDate(new Date());
        vo.setEndDate(new Date());
        vo.setCategoryName("融宝7号");
        vo.setCategoryMaxLimit(new BigDecimal("1200"));
        vo.setTrdType(2);
        vo.setCreditRate(new BigDecimal("1400"));
        list.add(vo);
        vo = new VOExt();
        vo.setBankName("邮政银行");
        vo.setContactor("张三");
        vo.setTelephone("15800629167");
        vo.setAddress("居家桥路");
        vo.setFaxNum("021928222");
        vo.setZipCode("200100");
        vo.setBankMaxLimit(new BigDecimal("1000"));
        vo.setStartDate(new Date());
        vo.setEndDate(new Date());
        vo.setCategoryName("融宝7号");
        vo.setCategoryMaxLimit(new BigDecimal("1200"));
        vo.setTrdType(1);
        vo.setCreditRate(new BigDecimal("1400"));
        list.add(vo);
        vo = new VOExt();
        vo.setBankName("邮政银行");
        vo.setContactor("张三");
        vo.setTelephone("15800629167");
        vo.setAddress("居家桥路");
        vo.setFaxNum("021928222");
        vo.setZipCode("200100");
        vo.setBankMaxLimit(new BigDecimal("1000"));
        vo.setStartDate(new Date());
        vo.setEndDate(new Date());
        vo.setCategoryName("融宝7号");
        vo.setCategoryMaxLimit(new BigDecimal("1200"));
        vo.setTrdType(1);
        vo.setCreditRate(new BigDecimal("1400"));
        list.add(vo);
        vo = new VOExt();
        vo.setBankName("邮政银行");
        vo.setContactor("张三");
        vo.setTelephone("15800629167");
        vo.setAddress("居家桥路");
        vo.setFaxNum("021928222");
        vo.setZipCode("200100");
        vo.setBankMaxLimit(new BigDecimal("1000"));
        vo.setStartDate(new Date());
        vo.setEndDate(new Date());
        vo.setCategoryName("债券");
        vo.setCategoryMaxLimit(new BigDecimal("1200"));
        vo.setTrdType(1);
        vo.setCreditRate(new BigDecimal("1400"));
        list.add(vo);

        invokeMethod(vo,colName[1],null);
        createExcel(title, colName,list, mergeIndex, range);
        List<T> beanList = new ArrayList<T>();
    }

    public <T> String createExcel(String[] title, String[] colName, List<T> list, int[] mergeIndex, Map<String, String> range){

        if (title.length==0){
            return null;
        }
        /*初始化excel模板*/
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = null;

        /*实例化sheet对象并且设置sheet名称，book对象*/
        try {
            sheet = workbook.createSheet();
            workbook.setSheetName(0,"credit");
            workbook.setSelectedTab(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        /*初始化head，填值标题行（第一行）*/
        Row row0 = sheet.createRow(0);
        for(int i = 0; i<title.length; i++){
            /*创建单元格，指定类型*/
            Cell cell_1 = row0.createCell(i, CellType.STRING);
            cell_1.setCellValue(title[i]);
        }
        /*遍历该数据集合*/
        List<PoiModel> poiModels=new ArrayList<>();
        if(null!=workbook) {

            int index = 1;/*这里1是从excel的第二行开始，第一行已经塞入标题了*/
            for (T vo : list) {

                Row row = sheet.createRow(index);
                Boolean flag = false;
                for(int i =0; i< title.length; i++){
                    //判断合并区域

                    if(index == 1){
                        PoiModel poiModel = new PoiModel();
                        poiModel.setOldContent(getFiled(vo, colName[i]));
                        poiModel.setContent(getFiled(vo, colName[i]));
                        poiModel.setRowIndex(1);
                        poiModel.setCellIndex(i);
                        poiModels.add(poiModel);

                    }
                    String oldContent = "";
                    if (index > 1) {
                        oldContent = poiModels.get(i) == null ? "" : poiModels.get(i).getContent();
                    }
                    if(i ==0 && !poiModels.get(0).getContent().equals(getFiled(vo,colName[0]))){
                         /*当前行的当前列与上一行的当前列的内容不一致时，则把当前行以上的合并*/
                        int firstRowIndex = poiModels.get(0).getRowIndex();
                        int lastRowIndex = index -1;
                        int colIndex = poiModels.get(0).getCellIndex();
                        //在sheet里增加合并单元格
                        if(firstRowIndex != lastRowIndex){
                            sheet = setMergedRegion(firstRowIndex, lastRowIndex, colIndex, i, sheet, range);
                        }
                        /*重新记录该列的内容为当前内容，行标记改为当前行标记，列标记则为当前列*/
                        poiModels.get(i).setContent(getFiled(vo, colName[i]));
                        poiModels.get(i).setRowIndex(index);
                        poiModels.get(i).setCellIndex(i);
                        flag =true;
                    }

                    if((i==9 && !poiModels.get(9).getContent().equals(getFiled(vo,colName[9])) &&
                            poiModels.get(0).getContent().equals(getFiled(vo,colName[0])))){


//                        if((i==9 && !poiModels.get(9).getContent().equals(getFiled(vo,colName[9])) &&
//                                poiModels.get(0).getContent().equals(getFiled(vo,colName[0])))){
                           /*当前行的当前列与上一行的当前列的内容不一致时，则把当前行以上的合并*/
                            int firstRowIndex = poiModels.get(9).getRowIndex();
                            int lastRowIndex = index -1;
                            int colIndex = poiModels.get(9).getCellIndex();
                            //在sheet里增加合并单元格
                            if(firstRowIndex != lastRowIndex){
                                sheet = setMergedRegion(firstRowIndex, lastRowIndex, colIndex, i, sheet, range);
                            }
                        /*重新记录该列的内容为当前内容，行标记改为当前行标记，列标记则为当前列*/
                            poiModels.get(i).setContent(getFiled(vo, colName[i]));
                            poiModels.get(i).setRowIndex(index);
                            poiModels.get(i).setCellIndex(i);
                       /// }

                    }
                    if(flag && i==9 && poiModels.get(9).getContent().equals(getFiled(vo,colName[9]))){
                        int firstRowIndex = poiModels.get(9).getRowIndex();
                        int lastRowIndex = index -1;
                        int colIndex = poiModels.get(9).getCellIndex();
                        //在sheet里增加合并单元格
                        if(firstRowIndex != lastRowIndex){
                            sheet = setMergedRegion(firstRowIndex, lastRowIndex, colIndex, i, sheet, range);
                        }
                        /*重新记录该列的内容为当前内容，行标记改为当前行标记，列标记则为当前列*/
                        poiModels.get(i).setContent(getFiled(vo, colName[i]));
                        poiModels.get(i).setRowIndex(index);
                        poiModels.get(i).setCellIndex(i);
                    }
                    if((i==0 || i==9) && index==list.size()){
                        int firstRowIndex = poiModels.get(i).getRowIndex();
                        int lastRowIndex = index;
                        int colIndex = poiModels.get(i).getCellIndex();
                        //在sheet里增加合并单元格
                        if(firstRowIndex != lastRowIndex){
                            sheet = setMergedRegion(firstRowIndex, lastRowIndex, colIndex, i, sheet, range);
                        }

                    }

                    //每列插入对应值
                    Cell cell = row.createCell(i, CellType.STRING);
                    String value = getFiled(vo,colName[i]);
                    cell.setCellValue(value);

                    poiModels.get(i).setOldContent(oldContent);


                }
                index++;
            }

        }


        /*生成临时文件*/
        FileOutputStream out = null;
        String localPath = null;
        File tempFile = null;
        String fileName = String.valueOf(new Date().getTime()/1000);
        try {
            //tempFile = File.createTempFile(fileName, ".xlsx");
            tempFile = new File("E:/"+fileName+".xlsx");
            localPath = tempFile.getAbsolutePath();
            out = new FileOutputStream(tempFile);
            workbook.write(out);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                out.flush();
                out.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return localPath;
    }

    public Sheet setMergedRegion(int firstRowIndex, int lastRowIndex, int colIndex, int i, Sheet sheet, Map<String, String> range){
        String[] rangeNum = range.get(String.valueOf(i)).split("-");
        int startInt = Integer.parseInt(rangeNum[0]);
        int endInt = Integer.parseInt(rangeNum[1]);
        for(int k =startInt; k <= endInt; k++){
            sheet.addMergedRegion(new CellRangeAddress(firstRowIndex, lastRowIndex, k, k));
        }

        return sheet;
    }

    public void setCellRegionValue(Row row, int i, VOExt vo, String[] colName, Map<String,String> range){

        Cell cell = row.createCell(i, CellType.STRING);
        cell.setCellValue(getFiled(vo,colName[i]));
    }

    public String getFiled(Object object, String field) {
        Class<? extends Object> clazz  = object.getClass();
        Field[] fields=clazz.getFields();
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
    public static Object invokeMethod(Object owner, String fieldname,
                                      Object[] args) throws SecurityException, NoSuchMethodException,
            IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Class ownerClass = owner.getClass();

        Method method = null;
        method = ownerClass.getMethod(toGetter(fieldname));

        Object object = null;
        object = method.invoke(owner);

        return object;
    }

    public static String toGetter(String fieldname) {

        if (fieldname == null || fieldname.length() == 0) {
            return null;
        }

        /* If the second char is upper, make 'get' + field name as getter name. For example, eBlog -> geteBlog */
        if (fieldname.length() > 2) {
            String second = fieldname.substring(1, 2);
            if (second.equals(second.toUpperCase())) {
                return new StringBuffer("get").append(fieldname).toString();
            }
        }

        /* Common situation */
        fieldname = new StringBuffer("get").append(fieldname.substring(0, 1).toUpperCase())
                .append(fieldname.substring(1)).toString();

        return  fieldname;
    }
    public static void main (String[] args) throws SecurityException, IllegalArgumentException, NoSuchMethodException,
    IllegalAccessException, InvocationTargetException {
       exportExcelDemo demo = new exportExcelDemo();
       demo.exportExcel();
    }
}

package com.freedom.mybatisplus.controller;

import com.freedom.mybatisplus.domain.Student;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ：wujie
 * @date ：Created in 2019/12/5 10:34
 * @description：测试Excel下载
 * @version: 1.0.0
 */
@RestController
public class TestExcelWriteController {

    private  static final Logger logger= LoggerFactory.getLogger(TestExcelWriteController.class);

    private static final Integer NUM=2;
    /**
     * 导出excel
     * @param response
     * @throws Exception
     */
    @GetMapping("/excelDownload")
    public void test(HttpServletResponse response) throws Exception {
        //设置列名
        ArrayList<String> titles = new ArrayList<>();
        titles.add("姓名");
        titles.add("年龄");
        //设置主要数据
        ArrayList<ArrayList<Object>> dataBody = new ArrayList<>();
        ArrayList<Object> dataOne = new ArrayList<>();
        ArrayList<Object> dataTwo = new ArrayList<>();
        ArrayList<Object> dataThree = new ArrayList<>();
        dataOne.add("a");
        dataOne.add(20);
        dataTwo.add("b");
        dataTwo.add(25);
        dataThree.add("c");
        dataThree.add(30);
        dataBody.add(dataOne);
        dataBody.add(dataTwo);
        dataBody.add(dataThree);
        //设置sheet名
        String sheetName="花名册";
        //设置文件名
        String fileName="学生花名册.xls";
        //创建ecxel对象
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet对象
        Sheet sheet = wb.createSheet(sheetName);
        //写入第一行，且设置格式
        sheet = buildDataSheet(sheet, titles);
        //构建数据体
        int rowNum=1;
        for(ArrayList<Object> objects:dataBody){
            Row row = sheet.createRow(rowNum++);
            for (int i=0;i<objects.size();i++){
                Cell cell = row.createCell(i);
                cell.setCellValue(objects.get(i).toString());
            }
        }

        //设置响应头
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
        ServletOutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.close();
        wb.close();
    }

    /**
     * 设置表头格式与内容
     * @param sheet 表单
     * @param list 表头数据集合
     * @return Sheet
     */
    private Sheet buildDataSheet(Sheet sheet, List<String> list) {
        // 设置列头宽度
        for (int i=0; i<list.size(); i++) {
            sheet.setColumnWidth(i, 4000);
        }
        // 设置默认行高
        sheet.setDefaultRowHeight((short) 400);
        // 构建头单元格样式
        CellStyle cellStyle = buildHeadCellStyle(sheet.getWorkbook());
        // 写入第一行各列的数据
        Row head = sheet.createRow(0);
        for (int i = 0; i < list.size(); i++) {
            Cell cell = head.createCell(i);
            cell.setCellValue(list.get(i));
            cell.setCellStyle(cellStyle);
        }
        return sheet;
    }

    /**
     * 设置单元格样式
     * @param workbook excel文档对象
     * @return CellStyle
     */
    private CellStyle buildHeadCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        //对齐方式设置
        style.setAlignment(HorizontalAlignment.CENTER);
        //边框颜色和宽度设置
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex()); // 下边框
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex()); // 左边框
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex()); // 右边框
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex()); // 上边框
        //设置背景颜色
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //粗体字设置
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        return style;
    }


    /**
     * 通过指定路径读取excel文件
     * @param filePath 文件路径
     * @return Object
     * @throws Exception
     */
    @GetMapping("/excelRead")
    public Object testRead(@RequestParam("filePath")String filePath) throws Exception {
        //String filePath="D:\\用户目录\\下载\\学生花名册.xls";
        System.out.println(filePath);
        // 获取Excel后缀名
        //测试固定后缀为.xsl
        String fileType = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());
        // 获取Excel文件
        File excelFile = new File(filePath);
        if (!excelFile.exists()) {
            logger.info("指定的Excel文件不存在！");
        }
        //读取文件
        // 获取Excel工作簿
        FileInputStream  inputStream = new FileInputStream(excelFile);
        Workbook workbook =new HSSFWorkbook(inputStream);

        // 读取excel中的数据
        List<Student> resultDataList = parseExcel(workbook);
        inputStream.close();
        workbook.close();
        return resultDataList;
    }


    /**
     * 解析excel
     * @param workbook excel文档对象
     * @return List<Student>
     */
    private List<Student> parseExcel(Workbook workbook) {
        List<Student> resultDataList = new ArrayList<>();
        // 解析sheet
        //getNumberOfSheets()获取sheet的数量
        for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
            //利用workbook通过脚标获取sheet
            Sheet sheet = workbook.getSheetAt(sheetNum);

            // 校验sheet是否合法
            if (sheet == null) {
                continue;
            }

            //获取第一行数据
            //获取第一行的下标0
            int firstRowNum = sheet.getFirstRowNum();
            System.out.println("firstRowNum: "+firstRowNum);
            //获取最后一行的下标(从0开始计数)
            System.out.println("LastRowNum: "+sheet.getLastRowNum());
            Row firstRow = sheet.getRow(firstRowNum);
            if (null == firstRow) {
               logger.info("解析Excel失败，在第一行没有读取到任何数据！");
            }

            // 解析每一行的数据，构造数据对象
            int rowStart = firstRowNum + 1;
            //getPhysicalNumberOfRows()获取总行数
            int rowEnd = sheet.getPhysicalNumberOfRows();
            System.out.println("有效行数："+rowEnd);
            for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
                Row row = sheet.getRow(rowNum);
                /*//获取第一格的下标
                System.out.println("第一格："+row.getFirstCellNum());
                //注意：这里获取的是总列数
                System.out.println("最后一个："+row.getLastCellNum());
                //注意：这里获取的是不为空的总列数
                System.out.println("总格数："+row.getPhysicalNumberOfCells());*/
                if (null == row) {
                    continue;
                }

                //判断是否为空行的情况，是空行则直接跳过(注：正式读取时都会指定excel模板，所以读取列数固定)
                int rowIsNull = getRowIsNull(row, NUM);
                if (rowIsNull==NUM){
                    continue;
                }
                Student resultData = convertRowToData(row);
                if (null == resultData) {
                    logger.info("第 " + row.getRowNum() + "行数据不合法，已忽略！");
                    continue;
                }
                resultDataList.add(resultData);
            }
        }

        return resultDataList;
    }

    /**
     * 单元格数据返回String类型
     * @param cell 单元格对象
     * @return String
     */
    private String convertCellValueToString(Cell cell) {
        if(cell==null){
            return null;
        }
        String returnValue = null;
        switch (cell.getCellType()) {
            //数字
            case NUMERIC:
                Double doubleValue = cell.getNumericCellValue();

                // 格式化科学计数法，取一位整数
                DecimalFormat df = new DecimalFormat("0");
                returnValue = df.format(doubleValue);
                break;
            //字符串
            case STRING:
                returnValue = cell.getStringCellValue();
                break;
            //布尔
            case BOOLEAN:
                Boolean booleanValue = cell.getBooleanCellValue();
                returnValue = booleanValue.toString();
                break;
            // 空值
            case BLANK:
                break;
            // 公式
            case FORMULA:
                returnValue = cell.getCellFormula();
                break;
            // 故障
            case ERROR:
                break;
            default:
                break;
        }
        return returnValue;
    }

    /**
     * 行对象转换为数据
     * @param row 行对象
     * @return student
     */
    private  Student convertRowToData(Row row) {
        Student resultData = new Student();

        Cell cell;
        //初始化列的下标，从0开始
        int cellNum = 0;
        // 获取姓名
        cell = row.getCell(cellNum++);
        String name = convertCellValueToString(cell);
        resultData.setName(name);
        // 获取年龄
        cell = row.getCell(cellNum++);
        String ageStr = convertCellValueToString(cell);
        if (null == ageStr || "".equals(ageStr)) {
            // 年龄为空
            resultData.setAge(null);
        } else {
            resultData.setAge(Integer.parseInt(ageStr));
        }


        return resultData;
    }

    /**
     * 判断是否是空的行
     * @param row 行对象
     * @param rowNum 模板指定的需要读取的单元格数量
     * @return int
     */
    private  int getRowIsNull(Row row,int rowNum) {
        //初始化num
        int num = 0;
        for (int i = 0; i < rowNum; i++) {
            Cell cell = row.getCell(i);
            //判断这个行是否为空
            if (null == cell) {
                num++;
                System.out.println("cell为null");
            } else if (cell.getCellType() == CellType.BLANK) {
                //空值
                num++;
                System.out.println("cell为空值");
            }
        }
        return num;
    }

}

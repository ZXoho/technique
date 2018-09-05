import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import jxl.read.biff.BiffException;
import org.apache.poi.hssf.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by ZXoho
 * 2018/9/3 21:05
 * 导入Excel
 */

  public class ExcelUtil {

  /**
   * 将Excel文件导入数据库
   * @param request
   * @throws BiffException
   * @throws IOException
   */
    public static void insert(HttpServletRequest request) throws BiffException, IOException {

      String path = request.getServletPath(); //???
      File file = new File(path);
      DBUtil jdbc = new DBUtil();

      //创建Excel工作簿
      Workbook workbook = null;
      workbook = Workbook.getWorkbook(file);

      //获取Excel信息
      Sheet sheet = workbook.getSheet(0);//获得表索引
      int columnsNum = sheet.getColumns();//获得列数
      int rowsNum = sheet.getRows();
      String simNum = "";//每个表格中的数据

      //获取表列名
      String str = "";//拼接要插入的列
      for(int j = 0; j < columnsNum; j++) {
        Cell cell  = sheet.getCell(j, 0);
        simNum = cell.getContents();
        if(j == columnsNum - 1) {
          str += simNum;
        }else{
          str += simNum + ",";
        }
      }

      //获取内容 拼接sql
      for(int i = 1; i < rowsNum; i++) {
        String sql = "insert into xxx" + "("+str+") values(";
        //System.out.println(str);
        for(int k = 0; k<columnsNum; k++) {
          Cell cell = sheet.getCell(i,k);
          simNum = cell.getContents();
          if(k==columnsNum - 1){
            sql += "'"+ simNum + "'";
          }else{
            sql += "'"+ simNum + "',";
          }
        }
        sql += " )";
        jdbc.executeUpdate(sql);
      }

      //断开连接
      jdbc.closeStmt();
      jdbc.closeConnection();
    }

    /**
     * 数据库表转成Excel
     * @param list
     * @return
     */
    public static HSSFWorkbook tableToExcel(List<InsertData> list) {

        String[] excelHeader = {"姓名", "年级", "成绩"};//excel列名
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("学生表");//TODO 此处表名需再处理
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle cellStyle = wb.createCellStyle();//表格样式
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        //表头赋值
        for(int i = 0; i < excelHeader.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(excelHeader[i]);
            sheet.autoSizeColumn(i);
            sheet.setColumnWidth(cell.getColumnIndex(), 100 * 50);
        }

        //表赋值
        for(int i = 0; i < list.size(); i++) {
            InsertData student = list.get(i);
            row = sheet.createRow(i + 1);
            row.createCell(1).setCellValue(student.getName());
            row.createCell(2).setCellValue(student.getGrade());
            row.createCell(3).setCellValue(student.getScore());
        }
        return wb;
    }
}

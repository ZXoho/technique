package main.java;

import jxl.Sheet;
import jxl.Workbook;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

/**
 * Created by ZXoho
 * 2018/9/3 21:05
 * 导入Excel
 * https://blog.csdn.net/lulin27861/article/details/19070001
 */

  public class ExcelUtil {

    public static void insert(HttpServletRequest request) throws BiffException, IOException {

      String path = request.getServletPath(); //???
      File file = new File(path);

      //创建Excel工作簿
      Workbook workbook = null;
      workbook = Workbook.getWorkbook(file);

      //获取Excel信息
      Sheet sheet = workbook.getSheet(0);//获得表索引
      int columnsNum = sheet.getColumns();//获得列数
      int rowsNum = sheet.getRows();
      String simNum = "";//每个表格中的数据

    }
}

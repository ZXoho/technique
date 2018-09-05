import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DownloadUtil {

    public static void downloadFile(HttpServletRequest request, HttpServletResponse response)
                                    throws IOException {
        List<InsertData> list = new ArrayList<InsertData>();
        //TODO 此处未写获取list方法
        HSSFWorkbook wb = ExcelUtil.tableToExcel(list);
        OutputStream outputStream = response.getOutputStream();
        response.addHeader("文件名", new SimpleDateFormat("yyyyMMDD_HHmm").format(new Date()) + ".xls");
        response.setContentType("download/excel");
        wb.write(outputStream);
        outputStream.close();
    }
}

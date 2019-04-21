package com.jfone.mall.base.controller;


import com.jfone.mall.base.constant.ExportHeadData;
import com.jfone.mall.base.entity.work.ext.ExportCustOrdItem;
import com.jfone.mall.base.service.ExportService;
import com.jfone.mall.base.utils.ExcelUtil;
import com.jfone.mall.base.utils.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class ExportController {

    @Autowired
    private ExportService exportService;

    @RequestMapping(value = "export")
    @ResponseBody
    public void export(HttpServletRequest request,HttpServletResponse response)throws Exception{

        List<ExportCustOrdItem> export = exportService.getExport();
        String sheetName = "订单报表";
        String fileName = "订单信息表"+System.currentTimeMillis()+".xls";
        String[] title=ExportHeadData.order;
        String agent = request.getHeader("user-agent");
        fileName=FileUtils.encodeDownloadFilename(fileName,agent);
        String[][] content=new String[export.size()][title.length];
        for (int i = 0; i < export.size(); i++) {
            ExportCustOrdItem ex = export.get(i);
            content[i][0] = ex.getOrderNo();
            content[i][1] = ex.getcNickName();
            content[i][2] = ex.getpName();
            content[i][3] = ex.getTotalPrice();
            content[i][4] = ex.getQuantity();
            content[i][5] = ex.getPayMent();
            content[i][6] = ex.getStock();
            content[i][7] = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒").format(ex.getCreateTime());
            content[i][8] = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒").format(ex.getUpdateTime());
        }
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
             os.flush();
              os.close();
         } catch (Exception e) {
         e.printStackTrace();
          }
    }
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

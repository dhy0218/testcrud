package com.example.demo.Controller;

import org.apache.poi.hssf.usermodel.*;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class testexcel {
    public static void main(String[] args) {
        java.util.List<java.util.List<String>> myList = new ArrayList<>();
        List<String> x = new ArrayList<>();
        x.add("日期");
        x.add("天气状况");
        x.add("气温");
        x.add("风力风向");
        myList.add(new ArrayList<String>(x));
        for (int month = 1;month<=9;month++){
            List<String> biao = new ArrayList<>();
            biao.add("2016年"+month+"月");
            biao.add(" ");
            biao.add(" ");
            biao.add(" ");
            myList.add(biao);
            String url = "http://www.tianqihoubao.com/lishi/changsha/month/20160"+month+".html";
            String htmlString=getHtmlResourceByUrl(url, "gbk");
            int i = htmlString.indexOf("table");
            int j = htmlString.indexOf("/table");
            String my = htmlString.substring(i,j).replaceAll( "\\s", "" );;
            String[] list = my.split("<tr>");
            for (int index=2;index<list.length;index++){
                String[] list2 = list[index].split("<td>");
                List<String> temp = new ArrayList<>();
                String tempString = list2[1].substring(list2[1].indexOf(">")+1);
                temp.add(tempString.substring(0,tempString.indexOf("<")));
                for (int index2 = 2;index2<=4;index2++){
                    temp.add(list2[index2].substring(0,list2[index2].indexOf("<")));
                }
                myList.add(temp);
                //System.out.println(temp);
            }
        }
        for (int month = 10;month<=12;month++){
            List<String> biao = new ArrayList<>();
            biao.add("2016年"+month+"月");
            biao.add(" ");
            biao.add(" ");
            biao.add(" ");
            myList.add(biao);
            String url = "http://www.tianqihoubao.com/lishi/changsha/month/2016"+month+".html";
            String htmlString=getHtmlResourceByUrl(url, "gbk");
            int i = htmlString.indexOf("table");
            int j = htmlString.indexOf("/table");
            String my = htmlString.substring(i,j).replaceAll( "\\s", "" );;
            String[] list = my.split("<tr>");
            for (int index=2;index<list.length;index++){
                String[] list2 = list[index].split("<td>");
                List<String> temp = new ArrayList<>();
                String tempString = list2[1].substring(list2[1].indexOf(">")+1);
                temp.add(tempString.substring(0,tempString.indexOf("<")));
                for (int index2 = 2;index2<=4;index2++){
                    temp.add(list2[index2].substring(0,list2[index2].indexOf("<")));
                }
                myList.add(temp);
                //System.out.println(temp);
            }
        }
        System.out.println(myList);
        testexcel e = new testexcel();
        e.writeExcel("qqq.xlsx",myList);
    }
    public void writeExcel(String fileName,List<List<String>> list) {

        // 目标文件
        File file = new File(fileName);
        FileOutputStream fOut = null;
        try {
            // 创建新的Excel 工作簿
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 在Excel工作簿中建一工作表，其名为缺省值。
            // 也可以指定工作表的名字。
            HSSFSheet sheet = workbook.createSheet("Test_Table");

            // 创建字体，红色、粗体
            HSSFFont font = workbook.createFont();

            // 创建单元格的格式，如居中、左对齐等
            HSSFCellStyle cellStyle = workbook.createCellStyle();
            // 设置字体
            cellStyle.setFont(font);
            int rowNum = 0;// 行标
            int colNum = 0;// 列标
            // 建立表头信息
            // 在索引0的位置创建行（最顶端的行）
            HSSFRow row = sheet.createRow((short) rowNum);
            // 单元格
            HSSFCell cell = row.createCell((short) colNum);
            for (rowNum = 0; rowNum < list.size(); rowNum++) {
                // 新建第rowNum行
                row = sheet.createRow((short) rowNum);
                for (colNum = 0; colNum < 4; colNum++) {
                    // 在当前行的colNum位置创建单元格
                    cell = row.createCell((short) colNum);
                    cell.setCellStyle(cellStyle);
                    System.out.println(list.get(rowNum).get(colNum));
                    cell.setCellValue(list.get(rowNum).get(colNum));
                }
            }



            // 工作薄建立完成，下面将工作薄存入文件
            // 新建一输出文件流
            fOut = new FileOutputStream(file);
            // 把相应的Excel 工作簿存盘
            workbook.write(fOut);
            fOut.flush();
            // 操作结束，关闭文件
            fOut.close();

            System.out
                    .println("Excel文件生成成功！Excel文件名：" + file.getAbsolutePath());
        } catch (Exception e) {
            System.out
                    .println("Excel文件" + file.getAbsolutePath() + "生成失败：" + e);
        } finally {
            if (fOut != null) {
                try {
                    fOut.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    public static String getHtmlResourceByUrl(String url, String encoding) {
        StringBuffer buffer=new StringBuffer();
        InputStreamReader isr=null;

        try {
            // 建立网络连接
            URL urlObj = new URL(url);
            // 打开网络连接
            URLConnection uc = urlObj.openConnection();
            isr =new InputStreamReader(uc.getInputStream(),encoding);//建立文件的输入流
            BufferedReader reader =new BufferedReader(isr);//缓冲

            String line=null;
            while ((line=reader.readLine())!=null) {

                buffer.append(line+"\n");

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{

            try{
                if(null!=isr)isr.close();}
            catch(IOException e){
                e.printStackTrace();
            }
        }
        return buffer.toString();

    }

}

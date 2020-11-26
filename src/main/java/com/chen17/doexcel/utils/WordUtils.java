package com.chen17.doexcel.utils;


import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.util.Map;

/**
 * @author yd
 * @version 1.0
 * @date 2020-11-18 14:29
 */
public class WordUtils {
    /**
     *
     * @param templateTextInputStream 输入的模板字符串流
     * @param map 将要填入模板对应的字符
     * @return 返回已经填充完毕的最终日报文字
     * @throws Exception 异常
     */
    public static String creatWordByModel(BufferedInputStream templateTextInputStream, Map<String, String> map) throws Exception {

        /*String s = new String("$yesterdaydate16时至$todaydate16时,全市道路前端科技设备建设运行情况：全市前端设备概况：全市前端科技设备已出质保期点位共1176处（五年以内点位982处，五年以上点位194处），未出质保期点位共2125处。除设备老化需更换的点位$allDghDw处，设备停运的点位$allSbtyDw处，应正常运行的点位$yzcyx处；其中电视监控$allDsjk处，正常运行$dsjkZcyx处，设备完好率$dsjkWhBfb%；电子警察$allDzjc处,正常运行$dzjcZcyx处，设备完好率$dzjcWhBfb%；卡口$allKk处,正常运行$kkZcyx处，设备完好率$kkWhBfb%；微电警$allWdj处,正常运行$wdjZcyx处,设备完好率$wdjWhBfb%。\n" +
                "维修工作情况：昨日报修故障共$yesterdayAllErrNum处（需支队派工维修$yesterdayZdpgErrNum处，大队自行处理$yesterdayDdclErrNum处）,已修复故障$yesterdayAllRepairNum处(支队维修$yesterdayZdpgRepairNum处，大队维修$yesterdayDdclRepairNum处)，剩余故障$lastAllErrNum处（$lastZdWx处未出保第三方维修中,$lastDdWx处大队维修。）；今日报修故障共$todayAllErrNum处（需支队派工维修$todayZdpgErrNum处，大队自行处理$todayDdclErrNum处）。\n" +
                "今日各区县故障明细：$gzqxmx。");*/
        StringBuilder conText = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(templateTextInputStream));

        if(!reader.ready())
        {
            System.out.println("模板文件流无法读取");
        }
        int size=0;
        String line;
        while((line=reader.readLine())!=null)
        {
            conText.append(line+"\n");
        }



        String finalText = conText.toString();

        for (String key : map.keySet()){
            finalText = finalText.replace(key,map.get(key));
        }

        reader.close();
        return finalText;
    }
}


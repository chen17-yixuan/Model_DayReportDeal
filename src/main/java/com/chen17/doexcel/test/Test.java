package com.chen17.doexcel.test;

import com.chen17.doexcel.domain.BaseData;
import com.chen17.doexcel.domain.FromParentData;
import com.chen17.doexcel.domain.ToParentData;
import com.chen17.doexcel.enterPackage.DayReportEnterMethod;
import com.chen17.doexcel.logicalProcess.ReadExcel;
import com.chen17.doexcel.utils.JacksonUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yd
 * @version 1.0
 * @date 2020-11-18 12:57
 */
public class Test {

    public static void main(String[] args) throws FileNotFoundException {

        File dataSrcExcel = new File("D:\\demo.xlsx");

        File templateText = new File("D:/srctext.txt");



        //该工具类的传包入口
        FromParentData fromParentData = new FromParentData();
        //模板文件一般不变
        fromParentData.setTemplateTextInputStream(new BufferedInputStream(new FileInputStream(templateText)));

        List<BaseData> baseData;
        baseData = ReadExcel.readExcel(new BufferedInputStream(new FileInputStream(dataSrcExcel)));
        fromParentData.setSrcBaseData(baseData);

        /*//微电警故障总数 （源数据）
        fromParentData.setWdjGzzs(70);*/
        //微电警已修复总数
        fromParentData.setWdjXfzs(4);
        //派工单故障总数
        fromParentData.setPgdGzzs(8);
        //派工单已修复总数
        fromParentData.setPgdXfzs(3);
        //昨日需支队维修数量
        fromParentData.setYesterdayZdpgErrNum(79);
        //昨日需大队维修数量
        fromParentData.setYesterdayDdclErrNum(23);
        //大队修复的故障
        fromParentData.setDdXfzs(1);
        //传入日报开头显示时间，昨日日期自动计算
        fromParentData.setDate(new Date());
        //微电警对应的值
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("张店",0);
        map.put("淄川",18);
        map.put("博山",9);
        map.put("周村",3);
        map.put("临淄",7);
        map.put("桓台",15);
        map.put("沂源",9);
        map.put("高青",1);
        map.put("高新区",1);
        map.put("文昌湖",4);
        fromParentData.setWdjdygx(map);
        //开始传入
        DayReportEnterMethod dayReportEnterMethod = new DayReportEnterMethod(fromParentData.getSrcBaseData());

        //将其传入，得到日报word的字符串
//        ToParentData dayReportWord = dayReportEnterMethod.dayReportToParent(fromParentData);
//
//        System.out.println(JacksonUtil.toJson(dayReportWord));
        //System.out.println(dayReportWord);

        System.out.println(dayReportEnterMethod.dayReportToLocal(fromParentData));

    }
}

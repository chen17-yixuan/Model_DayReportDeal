package com.chen17.doexcel.enterPackage;

import com.chen17.doexcel.domain.BaseData;
import com.chen17.doexcel.domain.FromParentData;
import com.chen17.doexcel.domain.ToParentData;
import com.chen17.doexcel.utils.FillModel;
import com.chen17.doexcel.utils.JacksonUtil;
import com.chen17.doexcel.utils.WordUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yd
 * @version 1.0
 * @date 2020-11-17 11:28
 * 初步定两种入口方式：
 * 1.使用本类中的方法读取excel表格，填充相关数据
 * 2.使用外部数据库导入的方法填充相关数据
 */
public class DayReportEnterMethod {

    List<BaseData> baseDataList;

    public DayReportEnterMethod(List<BaseData> baseDataList) {
        this.baseDataList = baseDataList;
    }

    /**
     * FromParentData 里面需要传入的参数
     *
     * @param fromParentData 从外部传进来的工具类
     * @return 日报文本
     */
    public String dayReportToLocal(FromParentData fromParentData) {
        String dayReportTxt;
        try {
            //处理对应关系  传入表格数据后自动处理
            FillModel fillModel = new FillModel(fromParentData);
            Map<String, String> stringStringMap = fillModel.dayReportRelase();

            dayReportTxt = WordUtils.creatWordByModel(fromParentData.getTemplateTextInputStream(), stringStringMap);

        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

        return dayReportTxt;
    }

    /**
     * 被当做组件传值时，除了需要加个上传时间外，其他同其他一样
     *
     * @param fromParentData 从外部传进来的值
     *                       <p>
     *                       $yesterdaydate16时至$todaydate16时,全市道路前端科技设备建设运行情况：全市前端设备概况：全市前端科技设备已出质保期点位共1176处（五年以内点位982处，五年以上点位194处），未出质保期点位共2125处。除设备老化需更换的点位$allDghDw处，设备停运的点位$allSbtyDw处，应正常运行的点位$yzcyx处；其中电视监控$allDsjk处，正常运行$dsjkZcyx处，设备完好率$dsjkWhBfb%；电子警察$allDzjc处,正常运行$dzjcZcyx处，设备完好率$dzjcWhBfb%；卡口$allKk处,正常运行$kkZcyx处，设备完好率$kkWhBfb%；微电警$allWdj处,正常运行$wdjZcyx处,设备完好率$wdjWhBfb%。
     *                       维修工作情况：昨日报修故障共$yesterdayAllErrNum处（需支队派工维修$yesterdayZdpgErrNum处，大队自行处理$yesterdayDdclErrNum处）,已修复故障$yesterdayAllRepairNum处(支队维修$yesterdayZdpgRepairNum处，大队维修$yesterdayDdclRepairNum处)，剩余故障$lastAllErrNum处（$lastZdWx处未出保第三方维修中,$lastDdWx处大队维修。）；今日报修故障共$todayAllErrNum处（需支队派工维修$todayZdpgErrNum处，大队自行处理$todayDdclErrNum处）。
     *                       今日各区县故障明细：$gzqxmx。
     */
    public ToParentData dayReportToParent(FromParentData fromParentData) {
        String dayReportTxt;
        try {
            //处理对应关系  传入表格数据后自动处理
            FillModel fillModel = new FillModel(fromParentData);
            Map<String, String> stringStringMap = fillModel.dayReportRelase();
            dayReportTxt = WordUtils.creatWordByModel(fromParentData.getTemplateTextInputStream(), stringStringMap);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        //提取时间
        Map<String, Date> upDateTime   = new HashMap<>(20);

        for (BaseData baseData : baseDataList){
            upDateTime.put(baseData.getCounty(),baseData.getReportTime());
        }

        ToParentData toParentData = new ToParentData();

        toParentData.setWordTest(dayReportTxt);
        toParentData.setUpDateTime(upDateTime);

        return toParentData;


    }

}

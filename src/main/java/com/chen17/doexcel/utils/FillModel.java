package com.chen17.doexcel.utils;

import com.chen17.doexcel.domain.BaseData;
import com.chen17.doexcel.domain.FromParentData;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yd
 * @version 1.0
 * @date 2020-11-17 10:15
 */
public class FillModel {

    FromParentData fromParentData;

    public FillModel(FromParentData fromParentData){
        this.fromParentData = fromParentData;
    }

    /**
     * 填充以故障类别分的总数
     *
     * @return 带有总数的BaseData对象，里面的 county = “总计”
     */
    public BaseData getAllCountByErrClassical() {

        List<BaseData> baseDataList = this.fromParentData.getSrcBaseData();

        //存放总数量
        BaseData baseData = new BaseData();

        for (BaseData bd : baseDataList) {
            //电视监控设备总点位出保
            baseData.setDsjkSbzdwCb(baseData.getDsjkSbzdwCb() + bd.getDsjkSbzdwCb());
            //电视监控设备总点位未出保
            baseData.setDsjkSbzdwWcb(baseData.getDsjkSbzdwWcb() + bd.getDsjkSbzdwWcb());
            //电视监控设备待维修出保
            baseData.setDsjkSbdwxCb(baseData.getDsjkSbdwxCb() + bd.getDsjkSbdwxCb());
            //电视监控设备待维修未出保
            baseData.setDsjkSbdwxwCb(baseData.getDsjkSbdwxwCb() + bd.getDsjkSbdwxwCb());
            //电视监控设备待更换点位
            baseData.setDsjkdghdw(baseData.getDsjkdghdw() + bd.getDsjkdghdw());
            //电视监控设备停运点位
            baseData.setDsjksbtydw(baseData.getDsjksbtydw() + bd.getDsjksbtydw());
            //电视监控其他故障点位
            baseData.setDsjkqtgzdw(baseData.getDsjkqtgzdw() + bd.getDsjkqtgzdw());

            //电子警察设备总点位出保
            baseData.setDzjcSbzdwCb(baseData.getDzjcSbzdwCb() + bd.getDzjcSbzdwCb());
            //电子警察设备总点位未出保
            baseData.setDzjcSbzdwWcb(baseData.getDzjcSbzdwWcb() + bd.getDzjcSbzdwWcb());
            //电子警察设备待维修出保
            baseData.setDzjcSbdwxCb(baseData.getDzjcSbdwxCb() + bd.getDzjcSbdwxCb());
            //电子警察设备待维修未出保
            baseData.setDzjcSbdwxwCb(baseData.getDzjcSbdwxwCb() + bd.getDzjcSbdwxwCb());
            //电子警察设备待更换点位
            baseData.setDzjcdghdw(baseData.getDzjcdghdw() + bd.getDzjcdghdw());
            //电子警察设备停运点位
            baseData.setDzjcsbtydw(baseData.getDzjcsbtydw() + bd.getDzjcsbtydw());
            //电子警察其他故障点位
            baseData.setDzjcqtgzdw(baseData.getDzjcqtgzdw() + bd.getDzjcqtgzdw());

            //卡口设备总点位出保
            baseData.setKkSbzdwCb(baseData.getKkSbzdwCb() + bd.getKkSbzdwCb());
            //卡口设备总点位未出保
            baseData.setKkSbzdwWcb(baseData.getKkSbzdwWcb() + bd.getKkSbzdwWcb());
            //卡口设备待维修出保
            baseData.setKkSbdwxCb(baseData.getKkSbdwxCb() + bd.getKkSbdwxCb());
            //卡口设备待维修未出保
            baseData.setKkSbdwxwCb(baseData.getKkSbdwxwCb() + bd.getKkSbdwxwCb());
            //卡口设备待更换点位
            baseData.setKkdghdw(baseData.getKkdghdw() + bd.getKkdghdw());
            //卡口设备停运点位
            baseData.setKksbtydw(baseData.getKksbtydw() + bd.getKksbtydw());
            //卡口其他故障点位
            baseData.setKkqtgzdw(baseData.getKkqtgzdw() + bd.getKkqtgzdw());

        }
        int wdkErrAllCount =0;
        for (BaseData bd : baseDataList) {

            String county = bd.getCounty();
            int wdj = fromParentData.getWdjdygx().get(county);

            wdkErrAllCount= wdj+wdkErrAllCount;
        }
        baseData.setWdjGzzs(wdkErrAllCount);

        baseData.setCounty("总计");

        return baseData;
    }

    /**
     * 填充以区县分的故障类别
     *
     * @return 以区县分的故障数量的集合
     */
    public String paragraph3() {

        List<BaseData> baseDataList = this.fromParentData.getSrcBaseData();

        StringBuilder stringBuilder = new StringBuilder();

        for (BaseData bd : baseDataList) {

            String county = bd.getCounty();

            int dsjk = bd.getDsjkSbdwxCb() + bd.getDsjkSbdwxwCb() + bd.getDsjkqtgzdw();
            int dzjc = bd.getDzjcSbdwxCb() + bd.getDzjcSbdwxwCb() + bd.getDzjcqtgzdw();
            int kk = bd.getKkSbdwxCb() + bd.getKkSbdwxwCb() + bd.getKkqtgzdw();
            int wdj = fromParentData.getWdjdygx().get(county);
            int errCount = dsjk+dzjc+kk+wdj;
            stringBuilder.append(errCount != 0 ? county : "").append(dsjk != 0 ? "电视监控" + dsjk + "处，" : "").append(dzjc != 0 ? "电警" + dzjc + "处，" : "").append(kk != 0 ? "卡口" + kk + "处，" : "").append(wdj != 0 ? "微电警" + wdj + "处；" : "");
        }
        return stringBuilder.toString();
    }

    /**
     * @return Map Key对应文档里需要替换的标记，Value对应替换的数值(字符串格式)
     */
    public Map<String, String> dayReportRelase() {

        BaseData baseData = this.getAllCountByErrClassical();

        Map<String, String> map = new HashMap<String, String>(150);

        ChangeDataFormat changeDataFormat = new ChangeDataFormat(fromParentData);

        String today = changeDataFormat.getToday();
        String yesterday = changeDataFormat.getYesterday();

        //paragraph 1 base value 以下数总数集合
        int dsjkSbzdwCb = baseData.getDsjkSbzdwCb();
        int dsjkSbzdwWcb = baseData.getDsjkSbzdwWcb();
        int dsjkSbdwxCb = baseData.getDsjkSbdwxCb();
        int dsjkSbdwxwCb = baseData.getDsjkSbdwxwCb();
        int dsjkdghdw = baseData.getDsjkdghdw();
        int dsjksbtydw = baseData.getDsjksbtydw();
        int dsjkqtgzdw = baseData.getDsjkqtgzdw();
        int dzjcSbzdwCb = baseData.getDzjcSbzdwCb();
        int dzjcSbzdwWcb = baseData.getDzjcSbzdwWcb();
        int dzjcSbdwxCb = baseData.getDzjcSbdwxCb();
        int dzjcSbdwxwCb = baseData.getDzjcSbdwxwCb();
        int dzjcdghdw = baseData.getDzjcdghdw();
        int dzjcsbtydw = baseData.getDzjcsbtydw();
        int dzjcqtgzdw = baseData.getDzjcqtgzdw();
        int kkSbzdwCb = baseData.getKkSbzdwCb();
        int kkSbzdwWcb = baseData.getKkSbzdwWcb();
        int kkSbdwxCb = baseData.getKkSbdwxCb();
        int kkSbdwxwCb = baseData.getKkSbdwxwCb();
        int kkdghdw = baseData.getKkdghdw();
        int kksbtydw = baseData.getKksbtydw();
        int kkqtgzdw = baseData.getKkqtgzdw();

        //paragraph 1 deal value
        //待更换 点位总数（电视监控+电子警察+卡口）
        int allDghDw = dsjkdghdw + dzjcdghdw + kkdghdw;
        //设备停运总数（电视监控+电子警察+卡口）
        int allSbtyDw = dsjksbtydw + dzjcsbtydw + kksbtydw;
        //应正常运行数（固定值- 待更换总 - 设备停运总）
        int yzcyx = fromParentData.getSbyxzs() - allDghDw - allSbtyDw;
        //电视监控总数（设备总点位数- 待更换-停运）
        int allDsjk = dsjkSbzdwCb + dsjkSbzdwWcb - dsjkdghdw - dsjksbtydw;
        int allDzjc = dzjcSbzdwCb + dzjcSbzdwWcb - dzjcdghdw - dzjcsbtydw;
        int allKk = kkSbzdwCb + kkSbzdwWcb - kkdghdw - kksbtydw;
        int dsjkZcyx = allDsjk - dsjkSbdwxCb - dsjkSbdwxwCb - dsjkqtgzdw;
        int dzjcZcyx = allDzjc - dzjcSbdwxCb - dzjcSbdwxwCb - dzjcqtgzdw;
        int kkZcyx = allKk - kkSbdwxCb - kkSbdwxwCb - kkqtgzdw;
        int allWdj = fromParentData.getWdjzs();
        int wdjZcyx = allWdj -  baseData.getWdjGzzs();
        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        String dsjkWhBfb = numberFormat.format((float) dsjkZcyx / (float) allDsjk * 100);
        String dzjcWhBfb = numberFormat.format((float) dzjcZcyx / (float) allDzjc * 100);
        String kkWhBfb = numberFormat.format((float) kkZcyx / (float) allKk * 100);
        String wdjWhBfb = numberFormat.format((float) wdjZcyx / (float) allWdj * 100);
        /**
         *
         * @param wdjGzzs 微电警故障总数
         * @param wdjXfzs 微电警已修复总数
         * @param pgdGzzs 派工单故障总数
         * @param pgdXfzs 派工单已修复总数
         */
        //paragraph 2 base value
        //微电警故障总数
        int wdjGzzs = baseData.getWdjGzzs();
        //微电警修复总数
        int wdjXfzs = fromParentData.getWdjXfzs();
        //派工单故障总数
        int pgdGzzs = fromParentData.getPgdGzzs();
        //派工单修复总数
        int pgdXfzs = fromParentData.getPgdXfzs();
        //大队修复总数
        int ddXfzs = fromParentData.getDdXfzs();

        int dsjk = dsjkSbdwxCb+ dsjkSbdwxwCb + dsjkqtgzdw;
        int dzjc =  dzjcSbdwxCb+ dzjcSbdwxwCb + dzjcqtgzdw;
        int kk =  kkSbdwxCb+ kkSbdwxwCb + kkqtgzdw;

        //今天报修的总故障
        int todayAllErrNum = dsjk+dzjc+kk+ wdjGzzs;
        //昨日支大队报修的故障
        int yesterdayZdpgErrNum = fromParentData.getYesterdayZdpgErrNum();
        int yesterdayDdclErrNum = fromParentData.getYesterdayDdclErrNum();
        //昨日报修总故障（昨日支队故障数量+昨日大队故障数量 （从外部获取数据））
        int yesterdayAllErrNum = yesterdayDdclErrNum + yesterdayZdpgErrNum;
        //昨日修复的故障（派工单修复+微电警修复）
        int yesterdayZdpgRepairNum = pgdXfzs+wdjXfzs;
        int todayZdpgErrNum = wdjGzzs+pgdGzzs;
        int todayDdclErrNum = todayAllErrNum-todayZdpgErrNum;


        //paragraph 2 deal value
        //昨日报修已修复故障（昨日支队维修数量+昨日大队维修数量）
        int yesterdayAllRepairNum = yesterdayZdpgRepairNum + ddXfzs;
        //剩余昨日报修总故障（昨日报修总故障 - 今日修复的故障）
        int lastAllErrNum = yesterdayAllErrNum - yesterdayAllRepairNum;
        //支队维修剩余故障 （昨日支队派工单总数-昨日派工单修复的数量）
        int lastZdWx = yesterdayZdpgErrNum - yesterdayZdpgRepairNum;
        //大队维修剩余故障
        int lastDdWx = yesterdayDdclErrNum - ddXfzs;

        //paragraph1
        map.put("$todaydate",today);
        map.put("$yesterdaydate",yesterday);

        map.put("$allDghDw", String.valueOf(allDghDw));
        map.put("$allSbtyDw", String.valueOf(allSbtyDw));
        map.put("$yzcyx", String.valueOf(yzcyx));
        map.put("$allDsjk", String.valueOf(allDsjk));
        map.put("$allDzjc", String.valueOf(allDzjc));
        map.put("$allKk", String.valueOf(allKk));
        map.put("$dsjkZcyx", String.valueOf(dsjkZcyx));
        map.put("$dzjcZcyx", String.valueOf(dzjcZcyx));
        map.put("$kkZcyx", String.valueOf(kkZcyx));
        map.put("$allWdj", String.valueOf(allWdj));
        map.put("$wdjZcyx", String.valueOf(wdjZcyx));
        map.put("$dsjkWhBfb", dsjkWhBfb);
        map.put("$dzjcWhBfb", dzjcWhBfb);
        map.put("$kkWhBfb", kkWhBfb);
        map.put("$wdjWhBfb", wdjWhBfb);
        //paragraph2
        map.put("$yesterdayAllErrNum", String.valueOf(yesterdayAllErrNum));
        map.put("$yesterdayZdpgErrNum", String.valueOf(yesterdayZdpgErrNum));
        map.put("$yesterdayDdclErrNum", String.valueOf(yesterdayDdclErrNum));

        map.put("$yesterdayAllRepairNum", String.valueOf(yesterdayAllRepairNum));
        map.put("$yesterdayZdpgRepairNum", String.valueOf(yesterdayZdpgRepairNum));
        map.put("$yesterdayDdclRepairNum", String.valueOf(ddXfzs));

        map.put("$lastAllErrNum", String.valueOf(lastAllErrNum));
        map.put("$lastZdWx", String.valueOf(lastZdWx));
        map.put("$lastDdWx", String.valueOf(lastDdWx));

        map.put("$todayAllErrNum", String.valueOf(todayAllErrNum));
        map.put("$todayZdpgErrNum", String.valueOf(todayZdpgErrNum));
        map.put("$todayDdclErrNum", String.valueOf(todayDdclErrNum));
        //paragraph3
        map.put("$gzqxmx",paragraph3());


        return map;
    }
}

package com.chen17.doexcel.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.chen17.doexcel.domain.BaseData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yd
 * @version 1.0
 * @date 2020-11-18 11:03
 */
public class ExcelListener extends AnalysisEventListener<BaseData> {

    List<BaseData> list = new ArrayList<BaseData>();

    @Override
    public void invoke(BaseData baseData, AnalysisContext analysisContext) {

        list.add(baseData);
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("读取完成,已形成List<BaseData>源数据");
    }

    public List<BaseData> getList(){
        return this.list;
    }

}

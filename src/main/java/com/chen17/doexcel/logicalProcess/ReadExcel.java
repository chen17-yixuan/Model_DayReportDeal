package com.chen17.doexcel.logicalProcess;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.chen17.doexcel.domain.BaseData;
import com.chen17.doexcel.utils.ExcelListener;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author yd
 * @version 1.0
 * @date 2020-11-18 10:54
 */
public class ReadExcel {

    /**
     * 读取
     * @param dataSrcExcel 读取从文件中获取的文件流
     * @return 以BaseData为模板基础，取出对应集合
     */
    public static List<BaseData> readExcel(BufferedInputStream dataSrcExcel) {
        //获取监听类
        ExcelListener ecl = new ExcelListener();
        //监听类进行读取，在监听类中赋值，放到ecl对象中
        EasyExcel.read(dataSrcExcel, BaseData.class, ecl).sheet().headRowNumber(4).doRead();

        return ecl.getList();
    }
}

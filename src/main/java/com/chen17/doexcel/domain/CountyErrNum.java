package com.chen17.doexcel.domain;

import lombok.Data;

/**
 * @author yd
 * @version 1.0
 * @date 2020-11-17 09:28
 *
 * 该类是domain类，用于计算和生成日报word中的 各区县故障数量详表
 */
@Data
public class CountyErrNum {

    /**
     * @param order 序号
     * @param county 区县
     * @param dsjk 电视监控
     * @param dzjc 电子警察
     * @param kk 卡口
     * @param wdj 微电警
     * @param errCount 区县故障总数
     * @param stringBuilder 存放第三段文字信息
     */
    private int order;
    private String county;
    private int dsjk;
    private int dzjc;
    private int kk;
    private int wdj;
    private int errCount;


}

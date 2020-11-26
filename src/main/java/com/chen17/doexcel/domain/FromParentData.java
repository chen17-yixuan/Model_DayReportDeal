package com.chen17.doexcel.domain;

import lombok.Data;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author yd
 * @version 1.0
 * @date 2020-11-17 11:16
 * 该类是使用该工具的必填方法，一般从外部实现该类后填入对应的方法调用
 */
@Data
public class FromParentData {

    BufferedInputStream templateTextInputStream;

    /**
     * 外部传入
     * 上面微电警故障分类数需要在源表中体现
     * 下面两组是从外部传进来的数据，其中
     *
     * @param wdjGzzs 微电警故障总数 （源数据）
     * @param wdjXfzs 微电警已修复总数
     * @param pgdGzzs 派工单故障总数
     * @param pgdXfzs 派工单已修复总数
     */
   // private int wdjGzzs = 0;
    private int wdjXfzs = 0;
    private int pgdGzzs = 0;
    private int pgdXfzs = 0;
    private int ddGzzs = 0;
    private int ddXfzs = 0;

    /**
     * 外部传入
     *
     * @param sbyxzs 设备运行总数 固定值
     * @param wdjzs 微电警总数，固定值
     */
    private int sbyxzs = 3301;
    private int wdjzs = 1429;

    /**
     * 外部传入
     *
     * @param yesterdayZdpgErrNum 昨日需支队维修数量
     * @param yesterdayDdclErrNum 昨日需大队维修数量
     */
    private int yesterdayZdpgErrNum = 0;
    private int yesterdayDdclErrNum = 0;

    /**
     * @param wdjdygx 微电警区县与数量对应关系 -- 外部传入
     * @param srcBaseData 存放源数据（表格读取的数据） --内部计算或外部传入
     */
    private Map<String, Integer> wdjdygx;

    private List<BaseData> srcBaseData;

    /**
     * 传入日报开头显示时间，昨日日期自动计算
     */
    private Date date = new Date();

}

package com.chen17.doexcel.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Date;

/**
 * @author yd
 * @version 1.0
 * @date 2020-11-17 08:29
 */
@Data
public class BaseData {

    @ExcelProperty(index = 0)
    private int order = 0;

    @ExcelProperty(index = 1)
    private String county = null;

    @ExcelProperty(index = 2)
    private int dsjkSbzdwCb = 0;
    @ExcelProperty(index = 3)
    private int dsjkSbzdwWcb = 0;
    @ExcelProperty(index = 4)
    private int dsjkSbdwxCb = 0;
    @ExcelProperty(index = 5)
    private int dsjkSbdwxwCb = 0;
    @ExcelProperty(index = 6)
    private int dsjkdghdw = 0;
    @ExcelProperty(index = 7)
    private int dsjksbtydw = 0;
    @ExcelProperty(index = 8)
    private int dsjkqtgzdw = 0;

    @ExcelProperty(index = 9)
    private int dzjcSbzdwCb = 0;
    @ExcelProperty(index = 10)
    private int dzjcSbzdwWcb = 0;
    @ExcelProperty(index = 11)
    private int dzjcSbdwxCb = 0;
    @ExcelProperty(index = 12)
    private int dzjcSbdwxwCb = 0;
    @ExcelProperty(index = 13)
    private int dzjcdghdw = 0;
    @ExcelProperty(index = 14)
    private int dzjcsbtydw = 0;
    @ExcelProperty(index = 15)
    private int dzjcqtgzdw = 0;

    @ExcelProperty(index = 16)
    private int kkSbzdwCb = 0;
    @ExcelProperty(index = 17)
    private int kkSbzdwWcb = 0;
    @ExcelProperty(index = 18)
    private int kkSbdwxCb = 0;
    @ExcelProperty(index = 19)
    private int kkSbdwxwCb = 0;
    @ExcelProperty(index = 20)
    private int kkdghdw = 0;
    @ExcelProperty(index = 21)
    private int kksbtydw = 0;
    @ExcelProperty(index = 22)
    private int kkqtgzdw = 0;

    @ExcelProperty(index = 23)
    @DateTimeFormat("yyyy-MM-dd HH:mm")
    private Date reportTime ;

    @ExcelIgnore
    private int wdjGzzs = 0;

}

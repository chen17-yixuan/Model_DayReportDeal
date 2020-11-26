package com.chen17.doexcel.domain;

import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * @author yd
 * @version 1.0
 * @date 2020-11-20 16:42
 * 返回值，要返回 word 文本 和 时间 List
 */

@Data
public class ToParentData {

    private String wordTest;

    private Map<String, Date> upDateTime;

}

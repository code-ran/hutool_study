package com.ransibi.DateTime;

import cn.hutool.core.date.DateTime;

import java.util.Date;

/**
 * @description:
 * @author: rsb
 * @description: 2022-12-23-14-22
 * @description: DateTime类继承于java.util.Date类，为Date类扩展了众多简便方法，这些方法多是DateUtil静态方法的对象表现形式，
 *               使用DateTime对象可以完全替代开发中Date对象的使用。
 * @Version: 1.0.0
 */
public class Demo03 {
    public static void main(String[] args) {

        Date date = new Date();
        //方式一: new
        DateTime dateTime1 = new DateTime(date);
        //方式二: of
        DateTime dateTime = DateTime.of(date);
        //-----
        DateTime now = DateTime.now();
    }
}

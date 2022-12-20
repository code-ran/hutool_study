package com.ransibi.ConvertUtil;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;

import java.util.Date;
import java.util.List;

/**
 * @description: java常用类型转换
 * @author: rsb
 * @description: 2022-12-19-16-37
 * @description: java常用类型转换-hutool实现
 * @Version: 1.0.0
 */

public class Demo01 {
    public static void main(String[] args) {
        /**
         * 在Java开发中我们要面对各种各样的类型转换问题，尤其是从命令行获取的用户参数、从HttpRequest获取的Parameter等等，
         * 这些参数类型多种多样，我们怎么去转换他们呢？常用的办法是先整成String，然后调用XXX.parseXXX方法，还要承受转换失败的风险，
         * 不得不加一层try catch，这个小小的过程混迹在业务代码中会显得非常难看和臃肿。
         * hutool到的Convert类里面封装了针对Java常见类型的转换，用于简化类型转换。Convert类中大部分方法为toXXX，参数为Object，
         * 可以实现将任意可能的类型转换为指定类型。同时支持第二个参数defaultValue用于在转换失败时返回一个默认值。
         */
        /**
         * 1.转换为字符串
         */
        //基本数据类型转字符串
        int a = 1;
        //结果为："1"
        String aStr = Convert.toStr(a);
        //基本数据类型数组转字符串数组
        long[] b = {1, 2, 3, 4, 5};
        //结果为："[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(b);
        /**
         * 2.转换为指定类型数组：
         */
        //字符串数组转Integer类型数组
        String[] c = { "1", "2", "3", "4" };
        //结果为："["1", "2", "3", "4"]"
        Integer[] intArray = Convert.toIntArray(c);
        //long类型的数组转Integer类型数组
        long[] d = {1,2,3,4,5};
        //结果为：[1,2,3,4,5]
        Integer[] intArray2 = Convert.toIntArray(d);

        /**
         * 3.转换为日期对象
         */
        String e = "2022-12-20 15:34:13";
        //结果为：Tue Dec 20 15:34:13 CST 2022
        Date date = Convert.toDate(e);
        /**
         * 4.转换为集合
         */
        Object[] f = {"a", "你", "好", "", 1};
        //结果为：
        List<?> list = Convert.convert(List.class, f);
        //从4.1.11开始可以这么用
        List<?> list1 = Convert.toList(f);


        /**
         * 5.通过convert(TypeReference<T> reference, Object value)方法，自行new一个TypeReference对象可以对嵌套泛型进行类型转换
         */
        Object[] g = {"a", "你", "好", "", 1};
        Object[] h = {"1", "2", "3", "", 4};
        List<String> list2 = Convert.convert(new TypeReference<List<String>>() {},g);
        List<Integer> list3 = Convert.convert(new TypeReference<List<Integer>>() {},h);

        /**
         * 6.半角转全角
         */
        String i = "123456789";
        //结果为："１２３４５６７８９"
        String sbc = Convert.toSBC(i);

        /**
         * 全角转半角
         */
        String j = "１２３４５６７８９";
        //结果为"123456789"
        String dbc = Convert.toDBC(j);

        String j1 = "１     ２３    ４５６  ７８９";
        //结果为: "１     ２３    ４５６  ７８９"
        String dbc1 = Convert.toDBC(j1);
    }
}

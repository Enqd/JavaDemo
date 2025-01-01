package day11;

import java.util.*;

public class test4 {
    public static void main(String[] args) {
        /*
        定义一个Map集合，键用表示省份名称province，值表示市city，但是市会有多个。
        添加完毕后，遍历结果格式如下：
        江苏省=南京市，扬州市，苏州市，无锡市，常州市
        湖北省=武汉市，孝感市，十堰市，宜昌市，鄂州市
        河北省－石家庄市，唐山市，邢台市，保定市，张家口市
         */

        //1.定义集合
        //市单列集合
        ArrayList<String> city1 = new ArrayList<>();
        Collections.addAll(city1, "南京市", "扬州市", "苏州市", "无锡市", "常州市");
        ArrayList<String> city2 = new ArrayList<>();
        Collections.addAll(city2, "武汉市", "孝感市", "十堰市", "宜昌市", "鄂州市");
        ArrayList<String> city3 = new ArrayList<>();
        Collections.addAll(city3, "石家庄市", "唐山市", "邢台市", "保定市", "张家口市");

        //Map双列集合
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        //2.添加元素
        map.put("江苏省", city1);
        map.put("湖北省", city2);
        map.put("河北省", city3);

        //3.打印集合
        for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
            ArrayList<String> value = entry.getValue();
            StringJoiner sj = new StringJoiner(", ", "", "");//控制格式化输出的
            for(String city : value){
                sj.add(city);
            }
            System.out.println(entry.getKey() + " = " + sj);
        }

    }
}

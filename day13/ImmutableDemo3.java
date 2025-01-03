package day13;

import java.util.Map;

public class ImmutableDemo3 {
    public static void main(String[] args) {
        /*
            创建不可变的map集合
            "张三""南京", "李四", "北京", "王五", "上海"
            "赵六","广州", "孙七", "深圳", "周八", "杭州"
            "吴九", "宁波", "郑十", "苏州", "刘一", "无锡"
            "陈二","嘉兴"

         */

        Map<String, String> map = Map.of("张三", "南京", "李四", "北京", "王五", "上海",
                "赵六", "广州", "孙七", "深圳", "周八", "杭州",
                "吴九", "宁波", "郑十", "苏州", "刘一", "无锡",
                "陈二", "嘉兴");

        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

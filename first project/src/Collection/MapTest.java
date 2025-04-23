package Collector;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map= new HashMap<>();
        map.put("x",10);
        map.put("y",20);
        //set 가져와야 함 자동완성으로
        Set<Map.Entry<String,Integer>>entries=map.entrySet();
        entries.removeIf(e->e.getValue()==20);

        System.out.println(map);
    }
}

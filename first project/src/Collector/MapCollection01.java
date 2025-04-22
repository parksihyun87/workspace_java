package Collector;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapCollection01 {

    public static void main(String[] args) {

    HashMap<Integer,String> cats=new HashMap<Integer, String>();
    cats.put(1,"a");
    cats.put(2,"b");
    cats.put(3,"c");
    // 엔트리 활용
    for(Map.Entry<Integer,String> entry:cats.entrySet()){
        System.out.println(" ("+entry.getKey()+", "+entry.getValue()+ ")");
        }

    Iterator<Map.Entry<Integer,String>> entries=cats.entrySet().iterator();
    while(entries.hasNext()){
        Map.Entry<Integer,String>entry=entries.next();
        System.out.println(" (" + entry.getKey()+ "," + entry.getValue());
    }

    //keyset()활용

    for(Integer i: cats.keySet()){
        System.out.println("("+ i +","+cats.get(i)+")");
    }

    Iterator<Integer>keys=cats.keySet().iterator();
    while(keys.hasNext()){
        int key= keys.next();
        System.out.println("("+ key +","+cats.get(key)+")");
    }

    }//매인 끝
}//클래스 끝


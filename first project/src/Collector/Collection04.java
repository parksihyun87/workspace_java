package Collector;

import java.util.HashSet;

public class Collection04 {
    public static void main(String[] args) {
        HashSet<String>str=new HashSet<String>();
        // 해쉬<>변수=뉴 해쉬<자료형>();
        str.add("A");
        str.add("B");
        str.add("C");
        str.add("C");
        //오류는 안나고 안겹쳐져 짐
        System.out.println(str);

        System.out.println("HashSet 요소:");
        for(String elements:str){
            System.out.println(elements+" ");
        }
        String[]array=new String[str.size()];
        str.toArray(array);

        System.out.println();
        System.out.println("Array 요소:");
//        for()
    }
}
//왜 그대로 나옴?
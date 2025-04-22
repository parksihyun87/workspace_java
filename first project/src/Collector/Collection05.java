package Collector;

import java.util.TreeSet;

public class Collection05 {
    public static void main(String[] args) {
        TreeSet<String> str=new TreeSet<String>();

        str.add("A");
        str.add("B");
        str.add("C");
        System.out.println(str);

        System.out.println("TreeSet요소:");
        for(String elements:str){
            System.out.println(elements+ " ");
            // 트리구조에서의 결과는 이렇게 나온다.
        }
    }
}

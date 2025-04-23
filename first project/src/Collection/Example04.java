package Collector;

import java.util.HashSet;

public class Example04 {
    public static void main(String[] args) {
        HashSet<String>cats=new HashSet<String>();
        cats.add("페르시안");
        cats.add("샴");
        System.out.println(cats);
        cats.add("러시안블루");
        System.out.println(cats);
        cats.remove("페르시안");
        System.out.println(cats);
        System.out.println(cats.size());
        System.out.println(cats.contains("샴"));
    }
}

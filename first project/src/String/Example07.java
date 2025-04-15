package String;

import java.sql.SQLOutput;

public class Example07 {
    public static void main(String[] args) {
        String s1="Java";
        String s2="Java";
        String s3="java";
        System.out.println(s1==s2);
        System.out.println(s1!=s2);

        System.out.println(s2==s3);
        System.out.println(s2!=s3);
        String s4=s2+s3;
        System.out.println(s4);
    }
}

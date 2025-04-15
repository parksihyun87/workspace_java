package String;

public class Array07 {
    public static void main(String[] args) {
        String s1=new String("Java");
        String s2=new String("Java");
        String s3=s1;

        if(s1==s2){ System.out.println("s1,2같다");}
        else {System.out.println("같지 않다.");}

        if(s1==s3) {System.out.println("s1,3같다");}
        else {System.out.println("같지 않다.");}

        if(s1.equals(s2)) {System.out.println("s1,2같다");}
        else {System.out.println("같지 않다.");}
    }
}

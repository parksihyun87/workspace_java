package String;

public class Example06 {
    public static void main(String[] args) {
        String s=" Java Programming ";
        System.out.println("s.length()"+s.length());
        System.out.println("s.CharAt(1)"+s.charAt(1));
        System.out.println(s.substring(6));
        System.out.println(s.substring(5,13));
        System.out.println(s.indexOf("P"));
        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());
    }
}

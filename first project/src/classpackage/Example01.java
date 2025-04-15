package classpackage;

public class Example01 {
    public static void main(String[] args) {
        Example02.myMethod1();
        Example02 myObj=new Example02();
        // 이 경우는 해당 Obj가 뉴 익젬플 02로 직접 접근함
        myObj.myMethod2();
        // 이 경우는 객체를 만든 후에 접근함.
    }
}

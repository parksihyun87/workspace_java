package classpackage;

public class Dog {
    public String breed;
    //퍼블릭
    public String color;
    //퍼
    protected int age;
    // 프로
    private String name;
    // 개인(클래스 내에만)

    public void bowwow(){
        System.out.println("멍멍 짖다");
    }

    protected void run(){
        System.out.println("달리다");
    }

    private void sleep() {
        System.out.println("잠을 자다");
    }
}

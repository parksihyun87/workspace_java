package classpackage;

public class Cat {
    String name;
    String breed;
    String color;
    Cat(){
        System.out.println("Cat() 생성자 호출합니다.");
    }
    void eat(){
        System.out.println("먹이를 먹다.");
    }
    void scratch(){
        System.out.println("발톱으로 할퀴다.");
    }
    void meow(){
        System.out.println("야옹하고 울다.");
    }
    //퍼블릭x 스태틱x 보이드
    void ignore(){
        System.out.println("지나가도 무시합니다.");
    }
    void chew(){
        System.out.println("츄르를 먹습니다.");
    }
}

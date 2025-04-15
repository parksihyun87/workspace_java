package classpackage;

public class Cat2 {
    String breed;
    String color;
    Cat2(){
        System.out.println("cat()생성자 호출합니다.");
    }
    Cat2(String pBreed){
        System.out.println("cat(...)생성자 호출합니다.");
        this.breed=pBreed;
    }

    void eat(){
        System.out.println("먹이를 먹다.");
    }
    void scratch() {
        System.out.println("발톱으로 할퀴다.");
    }
    void meow() {
        System.out.println("야옹 하고 울다.");
    }
}

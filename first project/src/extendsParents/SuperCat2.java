package extendsParents;

public class SuperCat2 {
    String breed="샴고양이";
    String age="15살";
    
    void printInfo(){
        System.out.println("부모고양이의 부름");
    }
}

class SubKitten2 extends SuperCat2{
    String age="2살";
    void printInfo(){
        System.out.println("아기고양이의 부름");
    }
    void printDetail(){
        super.printInfo();
        System.out.println("품종은 "+super.breed+",나이는"+super.age);
    }
}



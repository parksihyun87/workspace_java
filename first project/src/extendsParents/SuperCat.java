package extendsParents;

public class SuperCat {
    String name;
    void printInfo(){
        System.out.println("부모 고양이입니다.");
    }
}

class SubKitten extends SuperCat{
    String name;
    void printinfo(){
        System.out.println("아기 고양이입니다.");
    }
    void printDetail(){
        super.printInfo();
        printinfo();
        super.name="extendsParents.SuperCat";
        name="extendsParents.SubKitten";
    }
}





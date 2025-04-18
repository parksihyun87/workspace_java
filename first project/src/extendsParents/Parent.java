package extendsParents;

public class Parent {
    String name="홍길순";

    public void details(){
        System.out.println(name);
    }
}

class Child extends Parent{
    String name="홍길동";

    public void details(){
        super.details();
        System.out.println(name);
    }

    public void printDetails(){
        details();
        System.out.println("부모");
        System.out.println();
    }
}

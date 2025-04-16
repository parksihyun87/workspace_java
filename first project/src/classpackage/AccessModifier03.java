package classpackage;

import org.w3c.dom.ls.LSOutput;

public class AccessModifier03 extends Dog {

//    public static void charm(String[] args){
//     protected void run(){
//            System.out.println("미친듯 달리다");
//    }
//    나중에 다시 하기

    public static void main(String[] args) {

    Dog obj=new Dog();

    obj.breed="포메라니안";
    obj.color="갈색";

    System.out.println("강아지 품종:"+obj.breed);
    System.out.println("강아지 품종:"+obj.color);
    obj.bowwow();
    obj.age=10;
    System.out.println("강아지 나이:"+obj.age);
    obj.run();

//    obj.name="다운";
    System.out.println("강아지 이름:"+obj.age);
//    obj.sleep();

    }



}


package classpackage;

public class Student {
    int id;
    String name;

    void insertReord(int parm1, String parm2){
        this.id=parm1;
        this.name=parm2;
        //this를 꼭 쓰자
    }

    void printInfo(){
        System.out.println("아이디:"+id);
        System.out.println("아이디:"+name);
    }
}

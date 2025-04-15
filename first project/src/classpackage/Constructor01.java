package classpackage;

public class Constructor01 {
    public static void main(String[] args) {
        System.out.println("***학생주소록***");
        Student2 stObj=new Student2();
        stObj.insertRecord(20221004,"홍길순");
        stObj.printInfo();
    }
}

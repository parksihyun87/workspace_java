package classpackage;

public class Object01 {
    public static void main(String[] args) {
        Student stObj1=new Student();
        stObj1.id=20221004;
        stObj1.name="홍길순";
        stObj1.printInfo();
        // 클래스가 설계도 이며, 이 클래스가 객체화 되면 안에 id나 name은
        // 저장 가능한 값이 생겨 불러올 수 있다.

        Student stObj2=new Student();
        stObj2.insertReord(20021005,"홍길동");
        stObj2.printInfo();
        //또한 인서트레코드로 값을 지정한 셈


//        Object[] arr = new Object[3];
    }
}



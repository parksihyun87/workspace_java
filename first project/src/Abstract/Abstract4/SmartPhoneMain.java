package Abstract.Abstract4;

public class SmartPhoneMain {
    public static void main(String[] args) {
        SmartPhoneImpl phone=new SmartPhoneImpl();
        phone.call();
        // 119 전화
        phone.calculator();
        // 스마트 폰 임플리가 컴퓨터에서 확장한 상태임.
    }
}

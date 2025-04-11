import java.util.Scanner;

public class Exmaple11 {
    public static void main(String[] args){
        Example14 ex1=new Example14();
        // 클래스 틀에다가 붕어빵틀에 구워서 만드는 객체 만드는 과정
        // ex1이 붕어방 자체.

        // 두개의 메서드를 가지고 있는 메서드. 클래스 이름과 같은 생성자
        // 그런데 사실 14에는 생성자 이름 메서드가 없음. 안만들면
        // Example14라는 (){}라는 디폴트 껍데기 생성자를 자바가
        // 자동으로 만들어줌. 생성자는 리턴 없어도 보이드도 안 씀.
        // 익셈을 불러서 객체를 만든 후 호출해서 씀.
//        ex1.testDisplay();
//        ex1.titleDisplay();
        Example14.titleDisplay();
        // 스태틱 메서드는 정적 메서드여서 객체를 안만들어도 사용 가능.
        //Example14.testDisplay(); 안됨. 인스턴스 라서 안됌.



        Scanner s= new Scanner(System.in);
        System.out.print("길이: ");

        int len=s.nextInt();

        for(int i=0; i<len; i++){
            for(int j=5;j>= 5-i; j--){
                System.out.print(" ");
            }
//            for(int j=0; j<(2*len)-1-(i*2);j++){
            for(int j=0; j<5;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
// 모양 반대로 하기(현재 5했을시 공백 0-5출력)

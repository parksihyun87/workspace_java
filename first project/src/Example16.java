import java.util.Scanner;


public class Example16 {


    //Scanner s= new Scanner(System.in);
    // 클래스 변수로 객체를 만들때는 뉴생//새로운 생(해당 불러올 연계과정)
    // 해서 메서드를 실행할 수 있게 하는 객체를 만든다.
    public static int add(int x, int y){
        return x+y;
    }
    public static void main(String[] args){
    int a=5, b=6;

    int sum=add(a,b);
    // 같은 클래스 내에 있는 함수라 이런 모양으로 불러 올 수 있음.

        System.out.println(sum);
    }
}

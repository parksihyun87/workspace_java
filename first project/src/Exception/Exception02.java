package Exception;

import java.util.Scanner;

public class Exception02 {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println("숫자를 입력하세요");
        int num=s.nextInt();

        int arr[]=new int[5];

        try{
            arr[num] = 10 / num;
            System.out.println(arr[num]);
        }
        // 해당 수식 작성

        catch (ArithmeticException e){
            // 캐치(매개변수에 아리스매틱 익셉션 클래스형의 e)
            System.out.println("0이 아닌 값을 입력하세요.");
            System.out.println(e.getMessage());
            // e.겟메세지 하면 트라이에 적어놓은 것을
            // 제브엠이 캐치안에다가 넣어서 객체를 던져 주고, 그것으로 메세지를 실행 가능하다.
        }

        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("올바른 배열 인덱스를 입력하세요.");
            System.out.println(e.getMessage());
        }
    }
}

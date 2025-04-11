import java.util.Scanner;
import java.util.SortedMap;
//자.유.스

public class Example12 {
    public static void main(String[] args){

//        Scanner s= new Scanner(System.in);
        // 객체 자료명 하고 변수로 위치저장 선언= 뉴로 생성하겠다 생성자를 통해(시스템인 불러옴)


        for(int i=0;i<5;i++){
            //두번째가 다섯번 실행해야 함. 동시에 아이는 공백을 나타냄
            //0,1,2,3,4
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<5-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


package array;

import java.util.Scanner;
// 임자유스

public class Exam2arrayCreate {
    public static void main(String[] args) {
        //배열 만드는 법 두가지
        //1. int [][] newArray=new int[4][4];
        //2. int [][] newArray= new int{{숫자1~3},{숫자1~3}};
        //3. int [][] newArray={{숫자1,2,3},{숫자1,2,3}};

        Scanner s= new Scanner(System.in);
        // 객체 생성시에는 좌항에는 (클래스이름,변수명) 2가지가 연관되고, 우항에는
        // 뉴, 스캐너(객체 생성함수),(시스템.in)3가지만 연관하면 된다.

        int[][] newArray=new int[4][4];
        int rows= newArray.length;
        int col= newArray[0].length;


//        for(int i=0;i<3;i++){
//            //입력부
//            System.out.println(i+"열의 값을 입력하세요(1행)");
//            newArray[0][i]=s.nextInt();
//            System.out.println(i+"열의 값을 입력하세요(2행)");
//            newArray[1][i]=s.nextInt();
//            System.out.println(i+"열의 값을 입력하세요(3행)");
//            newArray[2][i]=s.nextInt();
//
//            //계산부
//            newArray[3][i]=newArray[0][i]+newArray[1][i]+newArray[2][i];
//            newArray[0][3]+=newArray[0][i];
//            newArray[1][3]+=newArray[1][i];
//            newArray[2][3]+=newArray[2][i];
//            newArray[3][3]+=newArray[3][i];
//        }
        // 포 안에서는 i에 대해서 정의를 해줘야 함.
        // 열 순으로 들어감
        // 입력부
        for(int i=0;i<rows-1;i++){
            for(int j=0;j<col-1;j++){
              System.out.println(j+"열의 값을 입력하세요("+i+"행)");
              newArray[i][j]=s.nextInt();
            }
        }

        for(int i=0;i<rows-1; i++){
            for(int j=0; j<col-1; j++){
                newArray[i][col-1] += newArray[i][j];
                newArray[rows-1][j] += newArray[i][j];
                newArray[rows-1][col-1] += newArray[i][j];
            }
        }
        // 최종형태에서 변형하는 식으로 변경;


        for(int i=0;i<col-1;i++){
            System.out.println(i+"열합계: " +newArray[rows-1][i]+ " ");
        }


        //계산부
        //행 합계
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++) {
//                newArray[i][newArray.length - 1] += newArray[i][newArray.length - j - 2];//4-2=>(i=0/~2)(2-j=2,1,0)
//                // 해당은 {n,3}에 넣을 값을 연계, n은 2까지 감
//            }
//        }

        //열(총합계 포함)
//        for(int i=0;i<=3;i++){
//            for(int j=0;j<3;j++) {
//                newArray[newArray.length - 1][i] += newArray[newArray.length - j - 2][i]; //4-2=>(2-j=2,1,0)(i=0/~3)
//                // 해당은 {3,n}에 넣을 값을 연계인데 n은 3까지 감.
//            }
//        }
        //열 합
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++) {
//                newArray[newArray.length - 1][i] += newArray[newArray.length - j - 2][i]; //4-2=>(2-j=2,1,0)(i=0/~3)
//                // 해당은 {3,n}에 넣을 값을 연계인데 n은 3까지 감.
//            }
//        }
//
//        //총합계
//        for(int i=0;i<3;i++){
//                newArray[newArray.length - 1][newArray.length - 1] += newArray[newArray.length - 1][i]; //4-2=>(2-j=2,1,0)(i=0/~3)
//                // 해당은 {3,n}에 넣을 값을 연계인데 n은 3까지 감.
//        }
//
//

        // 출력부
        System.out.println("행합계");
        System.out.println(newArray[0][3]);
        System.out.println(newArray[1][3]);
        System.out.println(newArray[2][3]);
        System.out.println("열합계");
        System.out.println(newArray[3][0]);
        System.out.println(newArray[3][1]);
        System.out.println(newArray[3][2]);
        System.out.println("총합계");
        System.out.println(newArray[3][3]);
    }
}
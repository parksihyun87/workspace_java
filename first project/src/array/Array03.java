package array;
// 임포트 보다 패키지 이름이 위에 있는것 필요.

import java.util.Scanner;

public class Array03 {
    public static void main(String[] args) {
        double[][] marks= new double[2][3];
        //자배배인= 뉴자크크
        //double [][] marks= new double[2][3];
        Scanner s = new Scanner(System.in);

        for(int i=0;i<2;i++){
            System.out.println("학생번호"+(i+1));
            System.out.print("국어점수:");
            marks[i][0]=s.nextDouble();

            System.out.print("수학점수:");
            marks[i][1]=s.nextDouble();
            marks[i][2]=(marks[i][0]+marks[i][1])/2;
        }

        for(int i=0;i<2;i++){
            System.out.println("학생번호"+(i+1));
            System.out.println("국어: "+marks[i][0]);
            System.out.println("수학: "+marks[i][1]);
            System.out.println("평균: "+marks[i][2]);
        }
    }}




package array;

import java.util.Scanner;
// 자유스 들여오기


public class ExamBaseball {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // 클래스와 변수, 뉴 객체생성함수(생성객체관련);
        int[] arr = new int[3];
        int countNum = 0;

        // 자료형과 관련된 배열, 이름 = 뉴 자료형과 관련된 배열
        //int []arr=new int[]{10,20,30};
        //int []arr={10,20,30};

        int index= 0;
        // 중복 플래그
        // 인덱스 증가 표시
        // 조건 만족하면 탈출
        // 포문에서 arr 안에 잇는 값과 같은 관계가 있으면 플래그 고치고 밖으로 나옴,break;
        // 플래그 확인시 값 넣지 않고 다시 비교, 문제 없으면 밑의 항으로 내려감
        // 값 세번 넣는 표지 삽입

        while(true){
            int number = (int) (Math.random() * 3);
            boolean flag=false;


            for (int i = 0; i < index; i++) { //index랑 비교하는게 옳다.
                if(arr[i] == number) {
                    flag = true;
                    break;
                }
            }

            if(flag==true){
                continue;
            }

            arr[index]=number;
            // 0일때 한번은 무조건 들어감.
            ++index;

            if(index==3){
                break;
            }
        }

        for(int i=0;i<3;i++){
            System.out.println(arr[i]);
        }

    //            int number = s.nextInt();
    //            arr[i] = number;`

        while (true) {
            int strikeNum = 0;
            int ballNum = 0;
            boolean flag = false;

            int[] newArr = new int[3];

            for (int i = 0; i < 3; i++) {
                System.out.println("맞추는 숫자 입력");
                int number = s.nextInt();

                newArr[i] = number;
            }
            ++countNum;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (arr[i] == newArr[j]) {
                        if (i == j) {// 결국 같은 의미의 것을 훨씬 간단히 씀.
                            ++strikeNum;
                        } else {
                            ++ballNum;
                        }
//                            i == j ? ++strikeNum : ++ballNum;
                        flag = true;
                    }
                    // 이제 관계 연산자는 2개 1개로 줄어들었다. (종류 이런것 상관안함)
                    // == !=
                }
            }

            if (!flag) {
                System.out.println("아웃입니다.");
                continue;
            } else {
                if (strikeNum == 3) {
                    System.out.println("총" + countNum + "번 시도하였습니다.");
                    System.out.println(strikeNum + "스트라이크 입니다.");
                    break;
                } else {
                    System.out.println(strikeNum + "스트라이크" + ballNum + "볼 입니다.");
                    continue;
                }

            }
        }
    }
}

package array;

public class Example03 {
    public static void main(String[] args) {
        int[][] myArr=new int[2][4];
        // 인트 [][] 저장변수= new 인트[크기][크기];
        // 자배변= 뉴자[크][크];
        myArr[0][0]=2;
        // 변인인=값;
        myArr[0][1]=5;
        myArr[0][2]=7;
        myArr[0][3]=4;
        myArr[1][0]=9;
        myArr[1][1]=3;
        myArr[1][2]=2;
        myArr[1][3]=8;
        int sum1=0, sum2=0;
        for(int i=0;i<4;i++){
            sum1+=myArr[0][i];
        }
        System.out.println("첫 번째 행의 합계:" +sum1);
        for(int i=0;i<4;i++){
            sum2+=myArr[1][i];
        }
        System.out.println("두 번째 행의 합계:"+sum2);

    }
}

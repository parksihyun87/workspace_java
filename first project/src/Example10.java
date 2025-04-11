import java.util.Scanner;

public class Example10 {
    // 맨 처음은 퍼블릭 클래스 하고 대문자로 시작하는 이름을 붙여줌. 함수는 클래스 안에서야 존재함.
    public static void main(String[] args){
        // jvm이 쓸려면 스태틱 보이드 메인이 필요하며 프로그램 시작시 꼭 string[]만 받음
        // 스트링 args는 직접 입력 받을때 쓰는 거고 지금은 안써서 일단 형식만 가지고 감.
        // 스태틱은 메인에게 붙이는 거고 함수를 쓰려면 객체가 선언 및 변수저장을 해줘야 하지만
        // 스태틱이라는 접합자를 붙이면 그냥 사용이 가능한 메인 함수로서의 자격이 주어짐.
        //
        Scanner input= new Scanner(System.in);
        // 퍼스보메, 스캐너는 자바가 내장하고 있는 클래스
        // System.in은 입력을 받기 시작하겠다고 명령 단계를 준 것임.
        // 시스템은 도큐 같은 건데 클래스임.
        System.out.println("넘버 체크용");
        //시스템의 아웃겍체가 갖고 있는 프린트 ln
        //sout로 입력하면 자동 완성됨.
        // 인트 넘버에 인풋의 넥스트 인트에 입력을 저장하겠다
//        int max=0;
//        int min=0;
        int number=input.nextInt();
        int max=number;
        int min=number;

        for(int i=0;i<9;i++){
//        int number=input.nextInt();
//        if(i==0){
//            max=number;
//            min=number;
//        }
            number=input.nextInt();
//        if(i>=1) {
            if (number > max) {
                max = number;
            }
            if(number < min){
                min = number;
            }
//        }
        }
        System.out.println("최대값:"+max);
        System.out.println("최소값:"+min);
    }
}

// 처음에 미선언하면 에러 내기 때문에 0을 넣어 줘야 함.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);

        // 뉴 키워드를 사용해서 생성자를 사용하여서 객체를 만들었는데 이것은 인스턴스이다.
        // 스캐너 하고 참조값 저장할 변수와 오른쪽 뉴 스캐너 들어있으면 오른쪽에 소괄호에는 함수를 불러온 후
        // 그 함수의 리턴값을 연계한 후 참조값을 저장하게 된다.
        System.out.print("당신의 이름을 입력하세요");
        String name= s1.nextLine();
        // s1.
        System.out.print("당신의 연락처를 입력하세요");
        String phone= s1.nextLine();
        //넥스트 라인의 리턴값.

        System.out.print("*".repeat(60));
        System.out.println("\n\t\t\t\tWelcome to Shopping Mall");
        System.out.println("\t\t\t\tWelcome to Book Market!");

//      System.out.print("1. 고객 정보 확인하기 \t\t 4.바구니에 항목 추가하기\n2. 장바구니 상품 목록 보기 \t 5.장바구니 항목 수량 줄이기\n3. 장바구니 비우기\t\t\t 6.장바구니의 항목 삭제하기\n7. 영수증 표시하기");

        System.out.print("*".repeat(60));
        System.out.print("\n1. 고객 정보 확인하기");
        System.out.print("\t\t 4. 바구니에 항목 추가하기\n");
        System.out.print("2. 장바구니 상품 목록 보기");
        System.out.print("\t 5. 장바구니의 항목 수량 줄이기\n");
        System.out.print("3. 장바구니 비우기");
        System.out.print("\t\t\t 6. 장바구니의 항목 삭제하기\n");
        System.out.print("7. 영수증 표시하기");
        System.out.print("\t\t\t 8. 종료\n");
        String str="************************************************************\n";
        System.out.print(str);

        System.out.print("메뉴 번호를 선택해주세요.");
        int number=s1.nextInt();
        System.out.print(number);
        System.out.print("번을 선택했습니다.");
    }
}

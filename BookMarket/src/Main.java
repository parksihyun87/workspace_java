import java.util.Scanner;
public class Main {

    public static void menuGuestInfo(String x, String y){
        System.out.println("이름:"+x+" 전화번호:"+y);
    }
    public static void menuCartItemList(){
        System.out.println("2번 메뉴입니다.");
    }
    public static void menuCartClear(){
        System.out.println("3번 메뉴입니다.");
    }

    public static void menuCartAdditem(String [][] args){
        Scanner s1= new Scanner(System.in);
        // (클래스 이름, 객체화하려는 변수)두가지= 뉴로 생성자 호출 Scanner 동일이름 생성자, 괄호() 그리고 안에 필요 변수연계하며
        // 객체화함을 통하여 인스턴스 객체의 각종 자료나 메서드를 이용하려고 변형한 것임
        // 자료형으로 변수 만들고, 해당 객체에 있는 함수를 접합 시킨다.
        for(int i=0;i< args.length;i++){
            for(int j=0;j<args[0].length;j++) {
                System.out.print(args[i][j]+"|");
            }
            System.out.print("\n");
        }
        //
    while(true) {
        System.out.println("장바구니에 추가할 도서의 ID를 입력하세요:");
        String ID = s1.nextLine();
        boolean flag = false;

        for (int index = 0; index < args.length; index++) {
            if (args[index][0].equals(ID)) {
                // 반대로도 가능.
                flag = !flag;
                // !flag 같은 경우 변화시키고 본인 변수에 저장해서 변화값을 반영.
                break;
            }
        }

        if (!flag) {
            System.out.println("잘못된 ISBN의 입력입니다.");
            continue;
        } else {
            System.out.println("장바구니에 추가하겠습니까? Y|N");
            String confirm = s1.nextLine().toUpperCase();
//            char confirm=s1.next().toUpperCase().charAt(0);
            // 이렇게 해서 밑에는 직접 같다의 식으로 비교가 가능하다.
            if (confirm.equals("Y")) {
                System.out.println("장바구니에 입력되었습니다.");
                break;
            } else {
                System.out.println("장바구니에 입력되지 않았습니다.");
                break;
            }
        }
        //
    }

    }

    public static void menuCartRemoveItemCount(){
        System.out.println("5번 메뉴입니다.");
    }

    public static void menuCartRemoveItem(){
        System.out.println("6번 메뉴입니다.");
    }

    public static String menuCartBill(){
        return "7번 메뉴입니다.";
    }

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        // 뉴 키워드를 사용해서 생성자를 사용하여서 객체를 만들었는데 이것은 인스턴스이다.
        // 스캐너 하고 참조값 저장할 변수와 오른쪽 뉴 스캐너 들어있으면 오른쪽에 소괄호에는 함수를 불러온 후
        // 그 함수의 리턴값을 연계한 후 참조값을 저장하게 된다.

        String [][] mbookList= new String[3][7];
        mbookList[0][0]="ISBN1234"; mbookList[0][1]="쉽게 배우는 JSP 웹 프로그래밍"; mbookList[0][2]="27000"; mbookList[0][3]="송미영"; mbookList[0][4]="단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍"; mbookList[0][5]="IT 전문서";mbookList[0][6]="2018/10/08";
        mbookList[1][0]="ISBN1235"; mbookList[1][1]="안드로이드 프로그래밍"; mbookList[1][2]="33000"; mbookList[1][3]= "우재남"; mbookList[1][4]="실습 단계별 명쾌한 멘토링!"; mbookList[1][5]="IT전문서";mbookList[1][6]="2022/01/22";
        mbookList[2][0]="ISBN1236"; mbookList[2][1]="스크래치"; mbookList[2][2]="22000"; mbookList[2][3]="고광일"; mbookList[2][4]="컴퓨팅 사고력을 키우는 블록 코딩"; mbookList[2][5]="컴퓨터입문"; mbookList[2][6]="2019/06/10";

        // mbookList 배열 생성

        System.out.print("당신의 이름을 입력하세요");
        String name= s1.nextLine();
        // 일단 클래스를 객체화 한 후에는 이용이 가능하며, 원하는 형식의 자료형 형태를 이어 변수에 붙인후,
        System.out.print("당신의 연락처를 입력하세요");
        String phone= s1.nextLine();
        //넥스트 라인의 리턴값.

        System.out.print("*".repeat(60));
        System.out.println("\n\t\t\t\tWelcome to Shopping Mall");
        System.out.println("\t\t\t\tWelcome to Book Market!");

//      System.out.print("1. 고객 정보 확인하기 \t\t 4.바구니에 항목 추가하기\n2. 장바구니 상품 목록 보기 \t 5.장바구니 항목 수량 줄이기\n3. 장바구니 비우기\t\t\t 6.장바구니의 항목 삭제하기\n7. 영수증 표시하기");

        while(true){
        boolean endflag=false;
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
            int numberS=s1.nextInt();

            switch (numberS){
                case 1:
                    menuGuestInfo(name,phone);
                    break;
                case 2:
                    menuCartItemList();
                    break;
                case 3:
                    menuCartClear();
                    break;
                case 4:
                    menuCartAdditem(mbookList);
                    break;
                case 5:
                    menuCartRemoveItemCount();
                    break;
                case 6:
                    menuCartRemoveItem();
                    break;
                case 7:
                    System.out.println(menuCartBill());
                    break;
                case 8:
                    System.out.println("현재 고객 정보:");
                    System.out.print("이름:" + name);
                    System.out.println("\t\t 연락처:" + phone);
                    endflag=true;
                    break;
                }
                if(endflag==true){
                break;
                }
                continue;
            }
//            if(numberS!=8) {
//                System.out.println("현재 고객 정보:");
//                System.out.print("이름:" + name);
//                System.out.println("\t\t 연락처:" + phone);
//                continue;
//            }
//            if(numberS==8){
//                System.out.println("현재 고객 정보:");
//                System.out.print("이름:"+name);
//                System.out.print("\t\t 연락처:"+phone);
//
//                break;
//            }
        }
    }
// 8번 입력시 종료되도록 설정
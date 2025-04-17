import java.util.Scanner;

public class MenuManager {
    public final static int LOGIN=1;
    public final static int EXIT=2;
    public final static int ADDRESS_SEARCH=1;
    public final static int ADDRESS_SEARCH_ALL=2;
    public final static int USER_INFO_UPDATE=3;
    public final static int LOGOUT=4;
    // 상수 인트할때는 대문자로만 구성
    // 변하지 않을 애들임.
    // 메뉴만 따로 관리하여 출력 및 입력하는 클래스
    // (파이널,static) 2개를 같이 씀. pi와 같이 변하지 않는 수는 어디서나 넓게 사용할 수 있도록 static을 씀.
    // 함수도 다 스태틱 해주고, 이 클래스는 객체 안만듬

    public static void initMenu(){
        System.out.println("<<주소록관리>>");
        System.out.println("1.로그인");
        System.out.println("2.종료");
    }

    public static void addressMenu(){
        System.out.println("<<주소록관리2>>");
        System.out.println("1.주소록 검색");
        System.out.println("2.전체 주소록 검색");
        System.out.println("3.내 정보 변경");
        System.out.println("로그아웃");
    }

    public static int selectInitMenu(){
        // 입력을 선택하니깐
        int select;
        Scanner input= new Scanner(System.in);
        while(true){
            select= input.nextInt();
            // 인트나 기타 숫자 입력은 엔터나 스페이스바를 구분자라고 생각하고 버려서 엔터가 하나 입력되어 있음.
            // 다음에 쓰는 넥스트라인같은 경우는 엔터를 구분자로 가져가기 때문에, 엔터값만 자동으로 가지고 다음으로 넘어가 버림.
            input.nextLine();
            if(select<LOGIN || select>EXIT){
                System.out.println("잘못된 입력");
                continue;
            }
            break;
        }
        return select;
    }

    public static int selectAddressMenu(){
        int select;
        Scanner input= new Scanner(System.in);
        while(true){
            select= input.nextInt();
            // 인트나 기타 숫자 입력은 엔터나 스페이스바를 구분자라고 생각하고 버려서 엔터가 하나 입력되어 있음.
            // 다음에 쓰는 넥스트라인같은 경우는 엔터를 구분자로 가져가기 때문에, 엔터값만 자동으로 가지고 다음으로 넘어가 버림.
            input.nextLine();
            if(select<ADDRESS_SEARCH || select>LOGOUT){
                System.out.println("잘못된 입력");
                continue;
            }
            break;
        }
        return select;
    }


}

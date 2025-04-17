import java.util.Scanner;

public class Main {
    static User[] mUserList = new User[3];
    // User는 자료형 담을 []배열 저장변수=new User는 타입 담을 배열 3개 형성

    public static void main(String[] args) {
        mUserList[0] = new User("aa", "11", "이름1", "1111111", "서울");
        mUserList[1] = new User("bb", "22", "이름2", "2222222", "경기");
        mUserList[2] = new User("cc", "33", "이름3", "3333333", "강원");


        while(true) {
            boolean loginFlag = false;
            boolean exitFlag=false;
            String titleH = "<<주소록 관리>>";
            String titleLog = "1.로그인";
            String titleExit = "2.종료";
            System.out.println(titleH + "\n" + titleLog + "\n" + titleExit);

            System.out.println("주소록 관리 선택");
            Scanner s1 = new Scanner(System.in);
            // 시스템인을 생성변수로 가져간 스캐너 클래스 생성자 함수로 초기화
            int titleInput = s1.nextInt();
            s1.nextLine();
            // 받지 않는 넥스트 라인 자체로 인트 뒤의 엔터키 없앰.

            // 로그인 시작
             if(titleInput==1) {
                 // id 및 pw 입력부
                 System.out.println("id입력:");
                 String idInput = s1.nextLine();
                 System.out.println("pw입력:");
                 String pwInput = s1.nextLine();
                 boolean idFlag = false;
                 String currentUser;

                 // 로그인 확인부
                 for (int i = 0; i < mUserList.length; i++) {
                     if (idInput.equals(mUserList[i].getId())) {
                         if (pwInput.equals(mUserList[i].getPw())) {
                             idFlag = true;
                             loginFlag = true;
                             mUserList[i].setCurrentUser();
                             System.out.println("성공");
                             break;
                         } else {
                             idFlag = true;
                             System.out.println("pw가 틀렸음");
                         }
                     }
                 }

                 if (idFlag == false) {
                     System.out.println("id가 틀렸음");
                 }
             }else{
                 System.out.println("로그인을 종료합니다.");
                 exitFlag=true;
             }
            // 로그인 확인부 종료
            // 로그인 종료
            
            if(loginFlag) {
                //와일문2 시작
                while (true) {
                    //주소록 메뉴 만들기
                    String titleH2 = "<<주소록 메뉴>>";
                    String titleH3_1 = "1.주소록 검색";
                    String titleH3_2 = "2.전체 주소록 검색";
                    String titleH3_3 = "3.내정보 변경";
                    String titleH3_4 = "4.로그아웃";

                    System.out.println(titleH2 + "\n" + titleH3_1 + "\n" + titleH3_2 + "\n" + titleH3_3 + "\n" + titleH3_4);
                    System.out.println("주소록 메뉴 선택");
                    int titleInput2 = s1.nextInt();
                    s1.nextLine();


                    //아이디 검색 및 출력 부
                    if(titleInput2==1) {
                        System.out.println("검색 아이디 입력");
                        String idInput2 = s1.nextLine();

                        for (int i = 0; i < mUserList.length; i++) {
                            if (idInput2.equals(mUserList[i].getId())) {
                                System.out.println(mUserList[i].getPhone());
                                System.out.println(mUserList[i].getAddress());
                                break;
                            }
                        }
                    }

                    //전체 전화번호부 출력부
                    if(titleInput2==2) {
                        // 향상된 포문
                        // for(타입 변수: 배열이나 컬렉션) js의 let a of b의 형태로 이어질수 있다.
                        int index=0;
                        for(User obj:mUserList){
                            System.out.println(mUserList[index].getId());
                            System.out.println(mUserList[index].getName());
                            System.out.println(mUserList[index].getPhone());
                            System.out.println(mUserList[index].getAddress());
                            System.out.println();
                            index++;
                        }

                    }
                    //정보 수정 부
                    if(titleInput2==3) {
                        System.out.println("패스워드를 입력하세요");
                        String pwInput2 = s1.nextLine();
                        boolean pwFlag = false;
                        for (int i = 0; i < mUserList.length; i++) {
                            if (mUserList[i].isCurrentUser()) {
                                if (pwInput2.equals(mUserList[i].getPw())) {
                                    System.out.println("주소 입력해");
                                    String addressInput = s1.nextLine();
                                    mUserList[i].setAddress(addressInput);
                                    System.out.println("번호 입력해");
                                    String phoneInput = s1.nextLine();
                                    mUserList[i].setPhone(phoneInput);
                                    mUserList[i] = new User(mUserList[i].getId(), mUserList[i].getPw(), mUserList[i].getName(), mUserList[i].getPhone(), mUserList[i].getAddress());
                                    mUserList[i].setCurrentUser();
                                    pwFlag = !pwFlag;

                                    System.out.println(mUserList[i].getName()+"님의 정보가 변경되었습니다.");
                                    break;
                                }
                            }
                        }
                        if (!pwFlag) {
                            System.out.println("패스워드가 틀렸습니다.");
                        }
                    }

                    //로그아웃 부

                    if(titleInput2==4) {
                        for (int i = 0; i < mUserList.length; i++) {
                            if (mUserList[i].isCurrentUser()) {
                                System.out.println(
                                        mUserList[i].getName() + "님 로그아웃");
                                mUserList[i].setCurrentUser();
                                exitFlag = true;
                                break;
                            }
                        }
                        if (exitFlag) {
                            break;// 전체 와일문2 탈출
                        }
                    }
                }//전체 와일문2 끝.
            }//메뉴2 if문 종료

            if(exitFlag){
                break;// 전체 와일문1 탈출
            }
        }//전체 와일 문 끝.
    }
}
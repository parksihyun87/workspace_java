import java.util.ArrayList;
import java.util.Scanner;

public class ScoreManager implements ScoreManagement {
    //멤버 변수
    boolean mExitFlag;
    boolean loginIdFlag=false;
    ArrayList<Admin> mAdmin=new ArrayList<>();
    ArrayList<ScoreData> mScoreList=new ArrayList<>();
    ScoreControl mScoreControl = new ScoreControl();
    Person mCurrentUser;


    // 생성자 함수 초기화
    public ScoreManager() {
        Admin a1=new Admin("aaa","111");
        Admin a2=new Admin("bbb","222");
        Admin a3=new Admin("ccc","333");

        ScoreData s1=new ScoreData("ddd","학생1");
        ScoreData s2=new ScoreData("eee","학생2");
        ScoreData s3=new ScoreData("fff","학생3");

        mAdmin.add(a1);
        mAdmin.add(a2);
        mAdmin.add(a3);

        mScoreList.add(s1);
        mScoreList.add(s2);
        mScoreList.add(s3);
    }

    // 메뉴부
    //<<첫번째 메뉴>>
    public void run(){
        while(true){
            System.out.println("메뉴 항목을 시작합니다.");
            System.out.println("<<성적처리>>");
            System.out.println("1.관리자 로그인");
            System.out.println("2.종료");
            Scanner input= new Scanner(System.in);
            int inputNum=input.nextInt();
            input.nextLine();

            switch(inputNum){
                case 1:
                    menuLogin();
                    //로그인 기능 및 성공시 두번째 메뉴 진입
                    break;
                    // *수정 키워드: 다른 클래스나 함수로 분리
                    
                case 2:
                    System.out.println("종료합니다.");
                    mExitFlag=!mExitFlag;
                    break;
            }
            if(mExitFlag){
                break;
            }
        }

    }//런메서드 끝

    //<<두번째 메뉴>>
    public void setScoreMenu(){
        boolean flagLogout=false;
        while(true){
            System.out.println("두번째 메뉴");
            System.out.println("<<성적처리>>");
            System.out.println("1.성적 입력");
            System.out.println("2.성적 검색");
            System.out.println("3.전체 성적 출력");
            System.out.println("4.로그아웃");
            Scanner input= new Scanner(System.in);
            // 막 외우기
            //스일변인 = 뉴스(시인)
            // 번호 입력
            int inputNum= input.nextInt();
            //형이변인 =인네
            input.nextLine();

            switch (inputNum){
                case 1:
                    menuWriteScoreData();
                    break;
                case 2:
                    menuFindScoreData();
                    break;
                case 3:
                    menuPrintScoreData();
                    break;
                case 4:
                    flagLogout=true;
                    mCurrentUser=null;
                    System.out.println("로그아웃 함");
                    break;
            }//스위치 끝

            if(flagLogout==true){
                break;
            }
        }//와일문 끝
    }//셋 스코어메뉴 끝


    // 메뉴 함수 모음부
    public void menuLogin(){
        loginAccess();
    }

    public void menuWriteScoreData(){
        WriteScoreData();
    }

    public void menuFindScoreData(){
        findDataById();
    }

    public void menuPrintScoreData(){
        mScoreControl.printScoreData(mScoreList);
    }

    // 기능 함수 모음부
    // 로그인 함수 + 함수안의 함수->두번째 메뉴 진입
    @Override
    public void loginAccess(){
        Scanner input= new Scanner(System.in);
        System.out.println("관리자 로그인을 시작합니다.");
        System.out.println("이름입력");
        String inputName=input.nextLine();
        System.out.println("번호입력");
        String inputPhone=input.nextLine();
        System.out.println("id입력");
        String inputId=input.nextLine();
        System.out.println("pw입력");
        String inputPw=input.nextLine();
        for(Admin e:mAdmin){
            loginIdFlag=false;
            if(e.getId().equals(inputId)){
                loginIdFlag=true;
                if(e.getPw().equals(inputPw)){
                    System.out.println("로그인 성공");
                    e.setName(inputName);
                    e.setPhone(inputPhone);
                    mCurrentUser=e;
                    System.out.println(mCurrentUser.getName()+"관리자님 반갑습니다.");

                    this.setScoreMenu();
                    break;
                }else{
                    System.out.println("비밀번호 틀림");
                    break;
                }
            }
        }
        if(loginIdFlag==false){
            System.out.println("id가 틀렸음");
        }
    }

    //메뉴 스코어 데이타(점수기록) 함수 시작
    @Override
    public void WriteScoreData(){
        Scanner input= new Scanner(System.in);
        int inputCount=0;

        for(ScoreData m:mScoreList){
            System.out.println(m.getId()+" "+m.getName());
            System.out.println("국어점수:");
            int inputKorean=input.nextInt();
            m.setKorean(inputKorean);
            System.out.println("영어점수:");
            int inputEnglish=input.nextInt();
            m.setEnglish(inputEnglish);
            System.out.println("수학점수:");
            int inputMath=input.nextInt();
            m.setMath(inputMath);
            m.setUpdateScore();
            input.nextLine();
            inputCount++;

            if(inputCount==mScoreList.size()){
                System.out.println("모든 학생의 입력이 끝났습니다.");
                break;
            }

            System.out.println("계속 입력여부 Y/N");
            String inputConfirm= input.nextLine().toUpperCase();
            if(inputConfirm.equals("N")){
                break;
            }
        }
    }// 스코어 데이타 끝.
    
    //파인드 스코어 데이타 시작
    @Override
    public void findDataById(){
        Scanner input=new Scanner(System.in);
        System.out.println("검색할 학생의 학번 입력");
        String inputId=input.nextLine();
        for(ScoreData m:mScoreList){
            if(inputId.equals(m.getId())){
                System.out.println("id:"+m.getId()+", pw:"+m.getName());
                System.out.println("국어:"+m.getKorean());
                System.out.println("영어:"+m.getEnglish());
                System.out.println("수학:"+m.getMath());
                System.out.println("총점:"+m.getTotalScore());
                System.out.println("평균:"+m.getAvgScore());
                break;
            }
        }
    }// 파인드스코어데이타 끝.
}//스코어클래스 끝

//최종: 기능적 이식, 함수의 인터페이스화 및 임플리먼트(최소)
// menuFindScoreData(), printScoreData(ArrayList<ScoreData> scoreArray)
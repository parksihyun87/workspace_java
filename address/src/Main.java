import java.util.Scanner;

public class Main {
    static User[] mUserList = new User[3];


    public static void main(String[] args) {
        mUserList[0] = new User("aa", "11", "aaa", "5555555", "서울");
        mUserList[1] = new User("bb", "22", "bbb", "4444444", "경기");
        mUserList[2] = new User("cc", "33", "ccc", "3333333", "강원");

        String titleH="<<주소록 관리>>";
        String titleLog="1.로그인";
        String titleExit="2.종료";
        System.out.println(titleH+"\n"+titleLog+"\n"+titleExit);

        Scanner s1= new Scanner(System.in);
        int titleInput= s1.nextInt();

        // 로그인 시작
        if(titleInput==1){
        //id 및 pw 입력부
        System.out.println("id입력:");
        String idInput=s1.next();
        System.out.println("pw입력:");
        String pwInput=s1.next();
        boolean flag=false;
            // 로그인 확인부
            for(int i=0;i<3;i++){
                if(idInput.equals(arr[i][0])){
                  if(pwInput.equals(arr[i][1])) {
                      flag = true;
                      System.out.println("성공");
                      break;
                  }else{
                      flag = true;
                      System.out.println("pw가 틀렸음");
                  }
                }
            }

            if(flag==false){
                System.out.println("id가 틀렸음");
            }
            // 로그인 확인부 종료
        }
        // 로그인 종료

    }
}
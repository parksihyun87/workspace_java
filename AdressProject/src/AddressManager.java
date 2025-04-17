import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class AddressManager {
    private User[] userList= new User[3];
    User currentUser;
    public AddressManager(){
        this.userList[0]=new User("aa", "11", "이름1", "1111111", "서울");
        this.userList[1]=new User("bb", "22", "이름2", "2222222", "경기");
        this.userList[2]=new User("cc", "33", "이름3", "3333333", "강원");
    }
    //어드레스 매니저에 각 배열이 들어갔음.

    public void run(){
    // 전체 흐름
        while(true){
            boolean endFlag=false;
            MenuManager.initMenu();
            int select = MenuManager.selectInitMenu();
            // 리턴값이 있기 때문에 select에 연계되어 넘겨짐.
            switch (select){
                case MenuManager.LOGIN :
                    if(this.login()){
                        this.addressProcess();
                        // 함수호출하고 종료되었다면 로그아웃 했다는 뜻.
                    }
                    break;
                case MenuManager.EXIT:
                    endFlag=true;
                    break;
            }
            if(endFlag){
                break;
            }

        }
    }
    // vmf프로세스?
    public void addressSearch(){
        Scanner input= new Scanner(System.in);
        System.out.println("검색할 사용자 이름");
        String name=input.nextLine();

        for(int i=0;i<this.userList.length;i++){
            if(userList[i].getName().equals(name)){
                System.out.println(this.userList[i].getName()+"님의 주소"+ this.userList[i].getAddress());
                System.out.println(this.userList[i].getName()+"님의 전화번호"+ this.userList[i].getPhone());
            }
        }
    }

    public void addressSearchAll(){
        for(int i=0;i<this.userList.length;i++){
                System.out.println(this.userList[i].getName()+"님의 주소"+ this.userList[i].getAddress());
                System.out.println(this.userList[i].getName()+"님의 전화번호"+ this.userList[i].getPhone());
        }
    }

    public void userInfoUpdate(){
        Scanner input= new Scanner(System.in);
        System.out.println("PW :");
        String pw=input.nextLine();

        if(this.currentUser.getPw().equals(pw)){
            System.out.println("비밀번호가 틀렸습니다.");
            return;
            //리턴은 반환과 전체 종료를 동시에 함. 보이드면 그냥 리턴.
        }
        System.out.println("phone");
        String phone=input.nextLine();
        System.out.println("Address");
        String address=input.nextLine();

        this.currentUser.setAddress(address);
        this.currentUser.setPhone(phone);
        System.out.println(this.currentUser.getName()+"님의 정보가 변경되었습니다.");
        //참조값이어서 바뀜.
    }

    public boolean login(){
        Scanner input=new Scanner(System.in);
        System.out.println("ID: ");
        String id= input.nextLine();
        System.out.println("PW: ");
        String pw= input.nextLine();

        for(int i=0;i<this.userList.length;i++){
            if(this.userList[i].getId().equals(id)){
                if(this.userList[i].getPw().equals(pw)){
                    System.out.println("로그인 성공");
                    this.currentUser=this.userList[i];
                    return true;
                }
            }
        }
        System.out.println("계정정보가 틀렸습니다.");
        return false;
    }

    public void addressProcess(){
        while(true){
            boolean endFlag = false;
            MenuManager.addressMenu();
            int select= MenuManager.selectAddressMenu();
            switch (select){
                case MenuManager.ADDRESS_SEARCH:
                    this.addressSearch();
                    break;
                case MenuManager.ADDRESS_SEARCH_ALL:
                    this.addressSearchAll();
                    break;
                case MenuManager.USER_INFO_UPDATE:
                    this.userInfoUpdate();
                    break;
                case MenuManager.LOGOUT:
                    endFlag=true;
                    this.currentUser=null;
            }
            if(endFlag){
                break;
            }
        }
    }

}

import dbpackage.User;
import dbpackage.UserDBConnect;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        UserDBConnect db = new UserDBConnect();
        db.initDBConnect();
        User[] userLits =db.allFetchUsertbl();
        for(int i=0 ; i< userLits.length; i++){
            System.out.println(userLits[i].getUserId());
            System.out.println(userLits[i].getUserName());
            System.out.println(userLits[i].getBirthYear());
            System.out.println(userLits[i].getAddr());
            System.out.println(userLits[i].getMobile1());
            System.out.println(userLits[i].getMobile2());
            System.out.println(userLits[i].getHeight());
            System.out.println(userLits[i].getMdate());
        }
        System.out.println("===".repeat(5));
        User user = db.selectUser("유재석");
        System.out.println(user.getUserId());
        System.out.println(user.getUserName());
        System.out.println(user.getBirthYear());
        System.out.println(user.getAddr());
        System.out.println(user.getMobile1());
        System.out.println(user.getMobile2());
        System.out.println(user.getHeight());
        System.out.println(user.getMdate());

        System.out.println("===".repeat(5));
        db.inputUser(new User("kja","김진아",2001,"경기","111","111111",163, Date.valueOf("2025-04-30")));
//        db.deleteUser("강호동");
        db.releaseDB();//?
    }
}
package perpareBOOKMarket;

public class User extends Person {

    public User(String name, String phone){
        super(name, phone);// 부모의 생성자 매개변수를 통하여 부모의 생성자 함수에게 연계
    }
}

public class Person {
    
    private String name;
    private String phone;
    //이름, 전화번호

    // 이름,전화번호
    public Person(String name, String phone){
        this.name = name;
        this.phone = phone;
    }
    //이름 입력, 전화번호 입력

    public String getName(){
        return this.name;
    }
    //이름을 가져옴

    public String getPhone(){
        return this.phone;
    }
    // 전화번호를 가져옴
    
    public void setName(String name){
        this.name=name;
    }
    // 이름을 가져옴

    public void setPhone(String phone){
        this.phone = phone;
    }
    // 전화번호를 세팅함
}

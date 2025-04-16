public class Salt {
    private String name;
    private String address;
    private String phone;


    public Salt(String name, String address, String phone){
        this.name=name;
        this.address=address;
        this.phone=phone;
    }

    public String getName(){
        return name;
    }
    // 읽기 함수 작성시 리턴값을 받으려면 자연스럽게 처음 지정한 자료 유형을 반환값을
    // 함수에 참조해줘야 한다.

    public String getAddress() {
        return address;
    }
}

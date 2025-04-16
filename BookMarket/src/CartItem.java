public class CartItem {
    private String[] book;
    private int count;
    private int totalPrice;
    // 이 클래스에서는 스트링[0]식으로 북 정보를 다 가져오고
    // 카운트와 총 가격을 관리함.

    public CartItem(String[] book, int count){
        this.book = book;
        this.count = count;
        this.updateTotalPrice();
    }
    // 책 한권 입력, 내가 넣은 카운트로 갯수 설정하고 업데이트 토탈 프라이스를 다시 실행시켜서
    // 토탈프라이스 값을 바꿈.

    public CartItem(String[] book){
        this.book = book;
        this.count = 1;
        this.updateTotalPrice();
    }
    // 처음에 자동으로 1개로 지정해 주는 생성자(처음 담을 때 씀)

    public void updateTotalPrice(){
        this.totalPrice = Integer.parseInt(this.book[2])* this.count;
    }
    // 총 값을 업데이트 함= 가격*디스 카운트로 받은 값
    
    // 읽어오기 시리즈는 왜 필요한가?
    public String[] getBook(){
        return this.book;
    }
    // 북 읽어오기, 읽어와서 ?

    public int getCount(){
        return this.count;
    }
    //카운트 읽어오기

    public int getTotalPrice(){
        return this.totalPrice;
    }
    // 전체 가격 가져오기
    // 읽어오기 종료

    public void setCount(int count){
        this.count = count;
        this.updateTotalPrice();
    }
    // 셋 카운트. 카운트를 바꾸고 안에서 값도 바꾸게 한다.
}

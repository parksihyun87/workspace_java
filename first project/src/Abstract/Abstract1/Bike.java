package Abstract.Abstract1;

public class Bike extends TwoWheeler {
    @Override
    public void printPrice(){// 베히클의 기본 상속
        System.out.println("가격 : 150,000");
    }
    @Override
    public void printType(){
        System.out.println("이것은 자전거입니다.");
        // 투휠러 상속
    }
    public void printBrand(){
        System.out.println("브랜드 : 삼천리");
    }
}

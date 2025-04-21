package Abstract.Abstract1;

public  class Car extends FourWheeler {
    @Override
    public void printPrice(){
        System.out.println("가격 : 50,000,000");
    }
    // 프프는 공동상속이지만 허점을 메워야 함
    public void printType(){
        System.out.println("이것은 자동차입니다.");
    }
    // 자체 생성
    public void printBrand(){
        System.out.println("브랜드: BMW");
    }
    //자체 생성
}

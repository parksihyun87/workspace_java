package Abstract.Abstract2;

public abstract class Shape {
    String color;
    //멤버변수

    abstract double area();
    // 구멍난 추상함수 아레아
    public abstract String toString();
    // 구멍난 추상함수 투스트링

    public Shape(String color){
        System.out.println("Shape 클래스 생성자 호출");
        this.color=color;
    }
    // 스트링 칼라의 함수. 실행시 문구 생성 및 칼러 변경

    public String getColor(){
        return color;
    }
}

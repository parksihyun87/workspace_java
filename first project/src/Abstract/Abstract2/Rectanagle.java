package Abstract.Abstract2;

public class Rectanagle extends Shape {
    double length;
    double width;

    public Rectanagle(String color, double length, double width){
        super(color);
        System.out.println("Rectangle 클래스 생성자 호출");
        this.length=length;
        this.width=width;
    }

    @Override
    double area(){
        return length * width;
    }

    @Override
    public String toString() {
        return "사각형 색상은"+super.getColor() + "그리고 면적은: "+ area();
    }
}

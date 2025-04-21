package Abstract.Abstract2;

public class Circle extends Shape {
    double radius;

    public Circle(String color, double radius){
        super(color);
        System.out.println("Circle 클래스 생성자 호출");
        this.radius= radius;
    }
    //
    @Override
    double area(){
        return radius* radius * 3.14;
    }

    @Override
    public String toString(){
        return "원 색상은 "+ super.getColor()+"그리고 면적은 :"+area();
    }
}

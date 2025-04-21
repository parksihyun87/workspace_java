package Abstract.Abstract1;

public class Example03 {
    public static void main(String[] args) {
        Bike myBike = new Bike();
        Car myCar = new Car();
        myBike.printPrice();
        myBike.printType();
        myBike.printBrand();
        System.out.println("---".repeat(15));
        myCar.printPrice();
        myCar.printType();
        myCar.printBrand();
    }
}

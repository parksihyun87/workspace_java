package Animal;

public class Polymorphism02 {
    public static void main(String[] args) {
        Animal myAnimal=new Animal();
        Animal myPig= new Pig();
        Animal myDog=new Dog();
        myAnimal.animalSound();
        myPig.animalSound();
        myDog.animalSound();
    }
}
// 자료형을 통한 다형성 . 다양하게 이용해 보자.
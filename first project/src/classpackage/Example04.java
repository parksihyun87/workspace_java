package classpackage;

public class Example04 {
    public static void main(String[] args) {
        Cat catObject= new Cat();
        catObject.eat();
        catObject.scratch();
        catObject.meow();
        catObject.ignore();
        catObject.chew();

        Cat cat1= new Cat();
        cat1.name="야옹서생";
        cat1.breed="코리안쇼트헤어";
        cat1.color="삼색이";
        System.out.println("cat1은 이름은 "+cat1.name + ", 종류는 "+cat1.breed+", 색깔은 "+cat1.color);
        System.out.print("특기는 ");
        cat1.eat();

        Cat cat2= new Cat();
        cat2.name="야옹군자";
        cat2.breed="스핑크스";
        cat2.color="분홍 피부색";
        System.out.println("cat2은 이름은 "+cat2.name + ", 종류는 "+cat2.breed+", 색깔은 "+cat2.color);
        System.out.print("특기는 ");
        cat2.scratch();

        Cat cat3= new Cat();
        cat3.name="야옹귀족";
        cat3.breed="샴고양이";
        cat3.color="회색 벨벳색";
        System.out.println("cat3은 이름은 "+cat3.name + ", 종류는 "+cat3.breed+", 색깔은 "+cat3.color);
        System.out.print("특기는 ");
        cat3.chew();
    }
}

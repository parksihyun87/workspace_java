package Abstract.Abstract3;

public class Chicken implements Fly,Walk{
    @Override
    public void fly(){
        System.out.println("닭은 40cm를 날 수 있다..");
    }
    @Override
    public void walk(){
        System.out.println("닭은 땅에 먹이를 쪼아 먹으며 걷는다.");
    }
}

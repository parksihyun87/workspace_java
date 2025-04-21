package Abstract.Abstract3;

public class Bird implements Fly, Walk{
    @Override
    public void fly(){
        System.out.println("새는 하늘 높이 날아 둥지를 찾는다.");
    }

    @Override
    public void walk(){
        System.out.println("새는 주변을 살피며 걷는다.");
    }
}

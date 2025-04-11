public class Example18 {
    public static int sum(int x, int y){
        return (x+y);
    }
    public static int sum(int x, int y, int z){
        return (x+y+z);
    }

    public static double sum(double x, double y){
        return (x+y);
    }

    public static void main(String[] args){
        System.out.println(sum(10,20));
        System.out.println(sum(10,20,30));
        System.out.println(sum(10.5,20.5));
    }
}
// 다른 곳에서 클래스를 가져와서 메인안에 객체로 만들어 지역변수에 저장하면
// 메인안의 지역변수 성격을 지니게 되며 이를 통해 함수를 사용함 (스태틱 함수는 객체 안만들어도 그냥 파일이름.메서드해도 사용이 가능함)
// 같은 클래스 안의 함수는 그냥 이름만으로 불러와서 사용이 가능하다.

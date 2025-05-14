package test;

public class test3 {
    String current;

    public test3(String current) {
        this.current=current;
    }

    public test3() {
    }

    public void run(){
        System.out.println(current);
        test4 test4= new test4();
        test4.run();
    }
}

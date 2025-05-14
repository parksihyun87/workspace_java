package test;

public class test4 {
    public String current= "t4";
    public test4() {

    }

    public void run(){
        test3 test3 = new test3(this.current);
        System.out.println(test3.current);
        test3.run();
    }
}

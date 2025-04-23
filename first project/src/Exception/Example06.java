
package Exception;

class MyException extends Exception{
    String str1;
    MyException(String str2){
        str1=str2;
    }
    public String toString(){
        return ("MyException 발생"+str1);
    }
}

public class Example06{
    public static void main(String[] args) {
        try{
            System.out.println("try블록입니다.");
            throw new MyException("MyException 클래스 호출됩니다.");
        }
        catch (MyException e){
            System.out.println("catch 블록입니다.");
            System.out.println(e);
        }
    }
}
//이동 순서는 어떻게 될까.

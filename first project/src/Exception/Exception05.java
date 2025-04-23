package Exception;

import java.security.spec.ECField;

class InvalidException extends Exception{
    public InvalidException(String s){
        super(s);
    }
}

public class Exception05 {
    void check(int weight)throws InvalidException{
        if(weight<100){
            throw new InvalidException("INvalidException 클래스 호출");
        }
    }
    // 본 호출부의 캐치로 던진다.
    // 인밸리드에 원하는 것 정의해 놓음.
    public static void main(String[] args) {
        Exception05 obj=new Exception05();
        try {
            obj.check(60);
        }
        catch (InvalidException ex){
            System.out.println("예외 처리입니다.");
            System.out.println(ex);
        }
    }
}


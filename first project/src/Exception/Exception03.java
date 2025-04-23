package Exception;

public class Exception03 {
    public static void main(String[] args) {
        int[]arr={10,20,30};

        try {
            for(int i=0;i<=3;i++){
                System.out.println("arr["+i+"]:"+arr[i]);
//            return;
            }
        }

        catch (Exception ex){
            System.out.println("예외 처리입니다.");
            System.out.println(ex.getMessage());
            return;
        }

        finally {
            System.out.println("예외 발생 여부와 상관업싱 실행되니다.");
        }

        // 익셉션 구문에서 파이널리는
    }
}

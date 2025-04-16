public class Light {
    static Salt[] saltList =new Salt[3];
    // 배열은 클래스로 자료형을 정하고 그에 따른 객체저장 변수를
    // 쓰며, 뉴로 동일히 연계될 자료형이 들어가는 몇칸짜리 배열을 지정해준다.
    // 자바에서 배열은 객체취급하고 object 클래스도 상속받았으며
    // 더 유동적인 집합 역할이 가능하다.
    public static void main(String[] args) {
    saltList[0]=new Salt("박시현","산안드레아스","11");
    }


}

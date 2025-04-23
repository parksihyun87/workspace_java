import java.util.ArrayList;

public class ScoreControl {
    ScoreData mScoreList;
    public void printScoreData(ArrayList<ScoreData> scoreArray){
        for(ScoreData m:scoreArray){
            System.out.println("id:"+m.getId()+"pw:"+m.getName());
            System.out.println(m.getKorean());
            System.out.println(m.getEnglish());
            System.out.println(m.getMath());
            System.out.println(m.getTotalScore());
            System.out.println(m.getAvgScore());
        }
    }//함수 끝
}//클래스 끝

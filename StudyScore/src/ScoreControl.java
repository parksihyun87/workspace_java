import java.util.ArrayList;

public class ScoreControl {
    ScoreData mScoreList;
    public void printScoreData(ArrayList<ScoreData> scoreArray){
        for(ScoreData m:scoreArray){
            System.out.println("id:"+m.getId()+", pw:"+m.getName());
            System.out.println("국어:"+m.getKorean());
            System.out.println("영어:"+m.getEnglish());
            System.out.println("수학:"+m.getMath());
            System.out.println("총점:"+m.getTotalScore());
            System.out.println("평균:"+m.getAvgScore());
        }
    }//함수 끝
}//클래스 끝

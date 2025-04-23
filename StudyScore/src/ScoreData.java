public class ScoreData extends Person{
    int korean;
    int english;
    int math;
    int totalScore;
    double avgScore;


    public ScoreData(String id, String name){
        this.id=id;
        this.name=name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getKorean() {
        return korean;
    }

    public int getMath() {
        return math;
    }

    public int getEnglish() {
        return english;
    }

    public int getTotalScore(){return totalScore; }

    public double getAvgScore() {return avgScore; }

    public void setName(String name) {
        this.name = name;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void setTotalScore(){
        this.totalScore=this.korean+this.english+this.math;
    }

    public void setAvgScore(){
        this.avgScore=(this.korean+this.english+this.math)/3;
    }

}

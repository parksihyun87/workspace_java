import java.util.Scanner;

public class MovingField {
    public void movingField(){
        int xMObject=1;
        int x1_1;
        int x2_1;
//        int xAxisDifMobj=10-xMObject;
        x2_1=10-xMObject;
        x1_1=9-x2_1;

//        for(int i=0;i<10;i++){
//            System.out.print("-");
//            if(i==9){
//            System.out.println();
//            }
//        }
        while(true){
            Scanner input = new Scanner(System.in);
            String inputPosition = input.nextLine();
            if(inputPosition.toUpperCase().equals("a")){
                
            } else if(inputPosition.toUpperCase().equals("d")){

            }
            System.out.println("-".repeat(x1_1)+"o"+"-".repeat(x2_1));
            break;
        }

        // MObject자체가 1먹음




    }
}

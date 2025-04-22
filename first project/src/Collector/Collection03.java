package Collector;

import Abstract.Abstract4.Computer;

import java.util.Comparator;
import java.util.Vector;

public class Collection03 {
    public static void main(String[] args) {
        Vector<Integer>num= new Vector<Integer>();

        for(int i=10; i>=1; i--){
            num.add(i);
        }

        System.out.println(num);

        System.out.println("정렬 전:");
        for(int i=0;i<num.size();i++){
            System.out.print(num.get(i)+" ");
        }

        num.sort(Comparator.naturalOrder());
        // 자연순 (오름차순)으로 소트 함.

        System.out.println("정렬 후:");
        for(int i=0;i<num.size();i++) {
            System.out.print(num.get(i) + " ");
        }

    }
}

package ex28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String str=input.nextLine();
        String[] strs=str.split(",");
        int k = input.nextInt();
        int[] array=new int[strs.length];

        for(int i=0;i<strs.length;i++) {
            array[i]=Integer.parseInt(strs[i]);
        }
        input.close();
        Arrays.sort(array);
        findK(array,k);


    }


    private static void findK(int[] array,int k) {

        ArrayList<Integer> arraylist = new  ArrayList<Integer>();
        for(int i=0;i<array.length;i++) {
            arraylist.add(array[array.length-1-i]);
        }

        System.out.print(arraylist.get(k-1));


    }

}

package ex24;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int a=1;
        int b=1;
        for(int i=0;i<32;i++) {
            if(n==a) {
                b=0;
                break;
            }
            a=a*2;
            if(n==a) {
                b=0;
                break;
            }
        }
        if(b==0) {
            System.out.print(1);
        }
        else {
            System.out.print(0);
        }
    }
}
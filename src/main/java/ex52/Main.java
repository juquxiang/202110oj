package ex52;

import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    /**
     * 使用scanner输入一个正整数
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(new Main().divisorGame(n));
    }
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }
}

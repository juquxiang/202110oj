package ex46;

import java.util.Scanner;

public class Main {
    /**
     * 给定一个整数 n ，将 n 拆分为若干个整数的和，其中 n>1。
     * 请问这个若干个整数的乘积最大为多少？
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = integerBreak(n);
        System.out.println(result);
    }
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}

package ex53;

import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    /**
     * 使用scanner换行输入两个字符串
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(Main.test(s1,s2));
    }
    /**
     * 小明玩一个游戏，有两个字符串str1和str2，计算将str1变为str2的最短变化次数
     *
     * 你每次可以对字符串进行如下三种操作中的一个：
     *
     * 插入一个字符
     *
     * 删除一个字符
     *
     * 替换一个字符
     */
    public static int test(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}

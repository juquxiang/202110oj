package ex47;

import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = getMoneyAmount(n);
        System.out.println(result);
    }
    /**
     * 描述
     *
     * 赌大小游戏规则如下：
     *
     * 我选择一个1到n（n>=1）之间的数字，你来猜我选择的数字。
     *
     * 假如你猜了数字 x，如果你猜错了赌输了，我会告诉你，我选的数字比 x 大或者小，同时你将输掉 x 元。
     *
     * 直到你正确猜到了我选的数字，你才算赌赢了。
     *
     * 请问你至少需要准备多少钱才能确保你能坚持到赌赢？
     *
     *
     * 输入
     * 输入:10
     *
     * 解释：第一个数字表示n=10，即我选择的数字在1到10之间。
     *
     *
     * 输出
     * 输出：16
     *
     * 解释：如果n=10，先猜7，再依据大小猜9或4，如果猜9再不对，那一定是8或10，花费7+9=16。
     */
    public static int getMoneyAmount(int n) {
        int[][] f = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                f[i][j] = j + f[i][j - 1];
                for (int k = i; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], k + Math.max(f[i][k - 1], f[k + 1][j]));
                }
            }
        }
        return f[1][n];
    }
}

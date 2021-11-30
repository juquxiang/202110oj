package ex50;

import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findIntegers(n));
    }

    public static int findIntegers(int num) {
        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < 32; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        String numStr = getBinary(num);
        int res = 0;
        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '0') {
                continue;
            }
            res += dp[numStr.length() - i - 1];
            if (i != 0 && numStr.charAt(i - 1) == '1') {
                return res;
            }
        }
        return res + 1;
    }

    // 将非负整数转为二进制字符串
    private static String getBinary(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.insert(0, num & 1);
            num >>= 1;
        }
        return sb.toString();
    }
    /**
     * 另一种解法
     */
    public static int findIntegers2(int n) {
        int[] dp = new int[31];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < 31; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int pre = 0, res = 0;
        for (int i = 29; i >= 0; --i) {
            int val = 1 << i;
            if ((n & val) != 0) {
                res += dp[i + 1];
                if (pre == 1) {
                    break;
                }
                pre = 1;
            } else {
                pre = 0;
            }

            if (i == 0) {
                ++res;
            }
        }

        return res;
    }
}

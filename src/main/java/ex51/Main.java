package ex51;

import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    /**
     * 使用scanner输入不定长数组，用","隔开
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(new Main().massage(nums));
    }

    public int massage(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int dp0 = 0, dp1 = nums[0];

        for (int i = 1; i < n; ++i) {
            int tdp0 = Math.max(dp0, dp1); // 计算 dp[i][0]
            int tdp1 = dp0 + nums[i]; // 计算 dp[i][1]

            dp0 = tdp0; // 用 dp[i][0] 更新 dp_0
            dp1 = tdp1; // 用 dp[i][1] 更新 dp_1
        }
        return Math.max(dp0, dp1);
    }
}

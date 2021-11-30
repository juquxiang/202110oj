package ex64;

import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    /**
     * 使用scanner首先输入数组长度n
     *
     * 接着输入组成数组nums的一串连续的整数
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int result = new Main().maxSubArray(nums);
        System.out.println(result);
    }
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}

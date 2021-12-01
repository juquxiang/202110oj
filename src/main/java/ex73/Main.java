package ex73;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] nums = new int[number];
        /*
        使用Scanner按行输入nums个数字
         */
        for (int i=0;i<number;i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(new Main().triangleNumber(nums));
    }
    /**
     * Description
     *
     * 给定一个包含非负整数的数组，统计其中可以组成三角形三条边的三元组个数。
     *
     *
     * Input
     * 输入非负整数数组
     *
     *
     * Output
     * 返回可以组成的三角形个数
     */
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int left = j + 1, right = n - 1, k = j;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] < nums[i] + nums[j]) {
                        k = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                ans += k - j;
            }
        }
        return ans;
    }
}

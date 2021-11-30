package ex7;

import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            int b = sc.nextInt();
            nums[i] = b;
        }
        int k = sc.nextInt();
        int[] result = maxSlidingWindow(nums, k);
        for(int a:result){
            System.out.print(a+" ");
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i % k == 0) {
                prefixMax[i] = nums[i];
            }
            else {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1 || (i + 1) % k == 0) {
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; ++i) {
            ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return ans;
    }
}

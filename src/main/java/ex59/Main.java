package ex59;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        int k = scanner.nextInt();
        System.out.println(maxResult(nums, k));

    }

    public static int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        // 构造滑动窗口的索引所对应的队列，队首至队尾的索引依次增大，但对应dp数组中的值依次降低
        Deque<Integer> windowIndices = new LinkedList<>();
        for (int i = 1; i < nums.length; i++) {
            // 如果新的索引i所对应的元素dp[i - 1]大于队尾rear所对应的数组元素dp[rear]，就循环弹出队尾，直到新的元素i - 1能够成为队尾
            // 因为dp[rear] < dp[i - 1]且rear < i - 1，只要窗口继续向右移，dp[rear]就一定会被dp[i - 1]压在下面，不会成为窗口最大元素
            while (!windowIndices.isEmpty() && dp[i - 1] >= dp[windowIndices.peekLast()]) {
                windowIndices.pollLast();
            }
            windowIndices.offerLast(i - 1);
            if (windowIndices.peekFirst() < i - k) {
                windowIndices.pollFirst();
            }
            dp[i] = dp[windowIndices.peekFirst()] + nums[i];
        }
        return dp[nums.length - 1];
    }
}

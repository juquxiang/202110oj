package ex7;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    /**
     * Description
     *
     * 给你一个整数数组，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看见在滑动窗口中的k个数字。滑动窗口每次向右移动一位。
     *
     * 请输出每个窗口中的最大值。
     *
     *
     * Input
     * 输入包含三部分，数组的长度，数组中各元素，滑动窗口大小。例如：
     *
     * 8
     *
     * 1 3 -1 -3 5 3 6 7
     *
     * 3
     *
     *
     * Output
     * 输出每个滑动窗口中元素的最大值，元素间用空格分隔，如：
     *
     * [1  3  -1] -3  5  3  6  7       3
     *
     * 1 [3  -1  -3] 5  3  6  7       3
     *
     * 1  3 [-1  -3  5] 3  6  7       5
     *
     * 1  3  -1 [-3  5  3] 6  7       5
     *
     * 1  3  -1  -3 [5  3  6] 7       6
     *
     * 1  3  -1  -3  5 [3  6  7]      7
     *
     * 输出：3 3 5 5 6 7
     */
    public static void main(String[] args) throws Exception{

        Scanner sc=new Scanner(System.in);
        int s=sc.nextInt();
        int[] nums=new int[s];
        for(int i=0;i<s;i++){
            nums[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        try {
            if(k>s) {
                System.out.print(" ");
            } else if(k==0) {
                System.out.print(" ");
            } else{
                int[] ans=Main.maxSlidingWindow(nums, k);
                for(int i:ans){
                    System.out.print(i+" ");
                }
            }
            sc.close();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }


    public  static int[] maxSlidingWindow(int[] nums, int k) throws Exception{
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

}

package ex6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] num = new int[length];
        for (int i = 0; i < length; i++) {
            int b = sc.nextInt();
            num[i] = b;
        }
        List<List<Integer>> result = threeSum(num);
        for(List<Integer> a:result) {
            for (int b:a){
                System.out.print(b+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int lg = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < lg; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = lg - 1;
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if (total == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                } else if (total < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }
}

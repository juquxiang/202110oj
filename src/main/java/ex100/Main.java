package ex100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] nums;
        nums=sc.nextLine().split(",");
        int[] num =new int[nums.length];
        for(int i=0;i<num.length;i++){
            num[i]=Integer.parseInt(nums[i]);
        }
        int amount = sc.nextInt();
        System.out.println(coinChange(num, amount));
    }
    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

package ex72;

import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numBottles = sc.nextInt();
        int numExchange = sc.nextInt();
        System.out.println(new Main().numWaterBottles(numBottles, numExchange));
    }
    /**
     * Description
     *
     * 校园便利店实施促销活动，用 numExchange 个饮料瓶盖可以兑换一瓶新饮料。你购入了 numBottles 瓶饮料。
     *
     * 一瓶饮料只有一个瓶盖。
     *
     * 请你计算最多能得到多少瓶饮料。
     *
     * 1 <= numBottles <= 100
     * 2 <= numExchange <= 100
     *
     * Input
     * 输入初始购买饮料数numBottles，输入numExchange个瓶盖兑换一瓶饮料
     *
     *
     * Output
     * 输出最多能得到多少瓶饮料
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        int bottle = numBottles, ans = numBottles;
        while (bottle >= numExchange) {
            bottle -= numExchange;
            ++ans;
            ++bottle;
        }
        return ans;
    }
}

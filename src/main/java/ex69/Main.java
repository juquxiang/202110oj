package ex69;

import java.util.Scanner;

/**
 * @author qx
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ratings = new int[n];
        for (int i = 0; i < n; i++) {
            ratings[i] = scanner.nextInt();
        }
        System.out.println(new Main().candy(ratings));
    }
    /**
     * 描述
     *
     * 某补课机构今年采用游戏的方式为员工发放年终奖，不仅考量他们的业绩绩效，也和他们运气相关，增加了活动的趣味性。
     *
     * 员工们先站成一条直线，老板按照员工一年的表现，已经提前给他们的绩效打了分数，你需要按照如下规则，帮助老板为员工们发放年终奖。
     *
     * 每位员工至少分配到1份礼品。
     *
     * 绩效评分更高的员工必须比他两侧的邻位员工获得更多的礼品。
     *
     * 那么这样下来，老板至少需要准备多少份礼品作为员工的年终奖呢？
     *
     *
     * 输入
     * 首先输入员工个数n
     *
     * 输入排成一队的员工的绩效评分数组performance[]
     *
     *
     * 输出
     * 老板至少需要准备的礼品份数
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }
}

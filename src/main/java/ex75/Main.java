package ex75;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int[] peaches = new int[number1];
        for (int i=0;i<number1;i++){
            peaches[i] = scanner.nextInt();
        }
        int number2 = scanner.nextInt();
        int[] days = new int[number2];
        for (int i=0;i<number2;i++){
            days[i] = scanner.nextInt();
        }
        System.out.println(new Main().eatenApples(peaches,days));
    }
    /**
     * Description
     *
     * 一棵蟠桃树开始结果，一连 n 天，每天都可以长出若干个蟠桃。在第 i 天，树上会长出 peaches[i] 个苹果，这些蟠桃将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的蟠桃，此时用 peaches[i] == 0 且 days[i] == 0 表示。
     *
     * 你打算每天最多吃一个蟠桃。注意，你可以在这 n 天之后继续吃蟠桃。
     *
     * 给你两个长度为 n 的整数数组 days 和 peaches ，返回你可以吃掉的蟠桃的最大数目。
     *
     *
     * Input
     * 输入蟠桃数组peaches[i]
     *
     * 输入保鲜天数days[i]
     *
     *
     * Output
     * 返回你可以吃掉的蟠桃的最大数目
     */
    public int eatenApples(int[] apples, int[] days) {
        int eatNums = 0;
        if (apples == null || apples.length == 0 || days == null || days.length == 0 || apples.length != days.length) {
            throw new IllegalArgumentException("arr is invalid!");
        }
        PriorityQueue<Element> priorityQueue = new PriorityQueue<>(Comparator.comparingInt((Element o) -> o.shelfLift));
        for (int i = 0; i < apples.length || !priorityQueue.isEmpty(); i++) {
            //1、清理保质期已过的苹果
            while (!priorityQueue.isEmpty()) {
                Element first = priorityQueue.peek();
                if (first.shelfLift <= i) {
                    priorityQueue.poll();
                } else {
                    break;
                }
            }
            //2、添加苹果
            if (i < apples.length) {
                priorityQueue.offer(new Element(apples[i], i + days[i]));
            }
            //3、吃苹果
            while (!priorityQueue.isEmpty()) {
                Element shortShelfLife = priorityQueue.poll();
                if (shortShelfLife.apples > 0 && shortShelfLife.shelfLift > i) {
                    eatNums++;
                    shortShelfLife.apples -= 1;
                    if (shortShelfLife.apples != 0) {
                        priorityQueue.offer(shortShelfLife);
                    }
                    break;
                }
            }
        }
        return eatNums;
    }

    private static class Element {
        private int apples;
        private final int shelfLift;

        public Element(int apples, int shelfLift) {
            this.apples = apples;
            this.shelfLift = shelfLift;
        }
    }
}

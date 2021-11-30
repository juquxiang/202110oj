package ex49;

import java.util.*;

/**
 * @author qx
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Main.minDays(n));
    }

    public static int minDays(int n) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((daysRest1, daysRest2) -> {
            if (daysRest1[0] != daysRest2[0]) {
                return daysRest1[0] - daysRest2[0];
            } else {
                return daysRest1[1] - daysRest2[1];
            }
        });
        Set<Integer> visited = new HashSet<>();
        queue.offer(new int[]{0, n});
        int ans;
        while (true) {
            int[] daysRest = queue.poll();
            assert daysRest != null;
            int days = daysRest[0], rest = daysRest[1];
            if (visited.contains(rest)) {
                continue;
            }
            visited.add(rest);
            if (rest == 1) {
                ans = days + 1;
                break;
            }
            queue.offer(new int[]{days + rest % 2 + 1, rest / 2});
            queue.offer(new int[]{days + rest % 3 + 1, rest / 3});
        }
        return ans;
    }
}

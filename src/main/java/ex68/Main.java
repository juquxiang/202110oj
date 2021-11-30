package ex68;

import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] gas = new int[n];
        int[] cost = new int[n];
        for (int i=0;i<n;i++) {
            gas[i] = sc.nextInt();
        }
        for (int i=0;i<n;i++) {
            cost[i] = sc.nextInt();
        }
        System.out.println(new Main().canCompleteCircuit(gas, cost));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}

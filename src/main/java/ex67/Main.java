package ex67;

import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    /**
     * 使用scanner输入N
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(new Main().monotoneIncreasingDigits(N));
    }
    public int monotoneIncreasingDigits(int n) {
        char[] strN = Integer.toString(n).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }
}

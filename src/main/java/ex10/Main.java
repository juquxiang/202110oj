package ex10;

import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t) {
        char[] chars = s.toCharArray(), chart = t.toCharArray();
        int n = chars.length, m = chart.length;

        int[] hash = new int[128];
        for (char ch : chart) {
            hash[ch]--;
        }

        String res = "";
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            hash[chars[i]]++;
            if (hash[chars[i]] <= 0) {
                cnt++;
            }
            while (cnt == m && hash[chars[j]] > 0) {
                hash[chars[j++]]--;
            }
            if (cnt == m) {
                if ("".equals(res) || res.length() > i - j + 1) {
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;
    }
}

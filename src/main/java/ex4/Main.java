package ex4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author qx
 */
class Main {

    public static void main(String[] args) {
        /*
          用户输入
         */
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            // 获取索引 i
            int i = dic.getOrDefault(s.charAt(j), -1);
            // 更新哈希表
            dic.put(s.charAt(j), j);
            // dp[j - 1] -> dp[j]
            tmp = tmp < j - i ? tmp + 1 : j - i;
            // max(dp[j - 1], dp[j])
            res = Math.max(res, tmp);
        }
        return res;
    }
}

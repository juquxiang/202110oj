package ex12;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    /**
     * Description
     *
     * 寻找趣味数字，趣味数字满足长度为 n 且每两个连续位上的数字之间的差的绝对值为 k 的 非负整数 。
     *
     * 请注意，除了 数字 0 本身之外，答案中的每个数字都不能有前导零。例如，01有一个前导零，所以是无效的；但0是有效的。
     *
     * 按从小到大返回答案。
     *
     *
     * Input
     * 第一行输入n,第二行输入k。
     *
     *
     * Output
     * [ ]中可以按从小到大顺序返回答案，并用“,”分隔。
     */
    static List<Integer> res = new ArrayList<>();
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int k=input.nextInt();
        input.close();

        numsSameConsecDiff(n, k);


    }



    public static void numsSameConsecDiff(int n, int k) {
        //先初始化开头第一个字符，进入递归
        for (int i = 1; i <= 9; i++) {
            //如果i+k或者i-k都不是有效的字符，说明当前i不能作为数字的开头
            if (i + k > 9 && i - k < 0)
                continue;
            //进入递归
            DFS(new StringBuilder(String.valueOf(i)), n, k);
        }
        int[] nums = new int[res.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res.get(i);
        }

        Arrays.sort(nums);
        System.out.print("[");
        for(int i=0;i<nums.length-1;i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.print(nums[nums.length-1]);
        System.out.print("]");

    }


    public static void DFS(StringBuilder str, int n, int k) {
        //长度到了就进入res
        if (str.length() == n) {
            res.add(Integer.parseInt(str.toString()));
            return;
        }
        //获取str上一个数字是什么
        int num = str.charAt(str.length() - 1) - '0';
        //num+k 可以加入到str中，并且开始递归
        if (num + k < 10) {
            str.append(String.valueOf(num + k));
            DFS(str, n, k);
            str.deleteCharAt(str.length() - 1);
        }
        //num-k 可以加入到str中并且开始递归
        if (num - k >= 0 && k != 0) {
            str.append(String.valueOf(num - k));
            DFS(str, n, k);
            str.deleteCharAt(str.length() - 1);
        }
    }

}

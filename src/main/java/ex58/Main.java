package ex58;

import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    /**
     *使用scanner输入数字
     */
    public static void main(String[] args){
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(main.countNumbersWithUniqueDigits(n));
    }
    public int countNumbersWithUniqueDigits(int n) {
        int count = 1;
        //排列组合的每一位的排法
        int m = 9;
        //每n位数的阶段性的和
        int t = 1;

        while(n > 0){
            t *=  m;
            count += t;
            n--;
            //对特殊情况2，3的处理
            if(t != 9 && t!=0) {
                m--;
            }
        }
        return count;
    }
}
package ex11;

import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    /**
     * Description
     *
     * 老师有一些糖果想要分出去，一次可以分1个糖果，也可以分2个糖果。求该老师分n个糖果总共有多少种分法。
     *
     * 答案需要取模1e9+7（1000000007），如计算初始结果为：1000000008，请返回1。
     *
     *
     * Input
     * 输入非负整数n
     *
     *
     * Output
     * 输出正整数即方法数
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if(n>0) {
            System.out.print(way(n));
        }
        else {
            System.out.print(1);
        }

    }
    public static int way(int n) {
        if(n==2||n==1) {
            return n;
        }
        else {
            int left=1,right=2;
            int sum=0;
            for(int i=3;i<=n;i++) {
                if(left+right>=1000000007) {
                    sum=(left+right)%1000000007;
                } else {
                    sum=left+right;
                }
                left=right;
                right=sum;
            }
            return sum;
        }
    }
}

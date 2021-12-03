package ex8;

import java.util.Scanner;

/**
 * @author qx
 */
class Main {
    /**
     * Description
     * <p>
     * 在算式中适当地添加“+”，“-”，“*”，“/”四种运算符，使等式成立（不使用括号）。
     * <p>
     * 例如5 5 5 5 5 3，添加运算符之后为5-5/5-5/5=3，等式成立，则输出：5-5/5-5/5=3。
     * <p>
     * 不用考虑除数为零的情况，等式左边固定为5个操作数，若有多种情况则全部输出。
     * <p>
     * <p>
     * Input
     * 共输入六个数，之间用空格分开，如：1 2 3 4 5 15
     * <p>
     * 前五个数为等式左边的五个数，最后一个数为等式右边的数。
     * <p>
     * <p>
     * Output
     * 添加运算符，若使得等式成立，则将成立的等式输出，如：
     * <p>
     * 1+2+3+4+5=15
     * <p>
     * 1-2*3+4*5=15
     * <p>
     * 1*2*3+4+5=15
     */
    public static void main(String[] args) {
        String a[] = {"", "+", "-", "*", "/"};//四种符号
        int i, j;//变量
        int w[] = new int[5];//符号的位数
        int sign;//正负号
        int count = 0;//计数
        int[] c = new int[5];//输入的数字
        int result;//输入的结果值
        float left, right;
        Scanner input = new Scanner(System.in);
        for (i = 0; i < 5; i++) {
            c[i] = input.nextInt();
        }

        result = input.nextInt();

        for (w[0] = 1; w[0] <= 4; w[0]++) {
            if (w[0] < 3 || c[1] != 0) {
                for (w[1] = 1; w[1] <= 4; w[1]++) {
                    if (w[1] < 3 || c[2] != 0) {
                        for (w[2] = 1; w[2] <= 4; w[2]++) {
                            if (w[2] < 3 || c[3] != 0) {
                                for (w[3] = 1; w[3] <= 4; w[3]++) {
                                    if (w[3] < 3 || c[4] != 0) {
                                        left = 0;
                                        right = c[0];
                                        sign = 1;
                                        for (j = 0; j <= 3; j++) {
                                            switch (a[w[j]]) {
                                                case "+" -> {
                                                    left = left + sign * right;
                                                    sign = 1;
                                                    right = c[j + 1];
                                                }
                                                case "-" -> {
                                                    left = left + sign * right;
                                                    sign = -1;
                                                    right = c[j + 1];
                                                }
                                                case "*" -> right = right * c[j + 1];
                                                case "/" -> right = right / c[j + 1];
                                            }
                                        }
                                        if (left + sign * right == result) {
                                            count++;
                                            //System.out.print("方法"+count+" :");
                                            for (i = 0; i < 5; i++) {
                                                System.out.print(c[i]);
                                                System.out.print(a[w[i]]);
                                            }
                                            System.out.print("=" + result);
                                            System.out.println();


                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}

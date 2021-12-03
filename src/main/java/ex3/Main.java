package ex3;

import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    /**
     * Description
     * <p>
     * 现在某个题库中有M道题,题号分别是1，2，3......M，有N个学生去做，每个人都做了一部分，求这N个学生都未做过的题目数量。
     * <p>
     * 每个学生做的第一道题可能不同，但每个学生做过的题目序号是连续的，并且不同学生做过的题可能重叠。
     * <p>
     * <p>
     * Input
     * 输入包括多组数据，第一行有两个数分别是，题目总数M(0<M<1000)，学生总数N;
     * <p>
     * 接下来的N行，每行包含两个不同的整数，用空格分隔开，
     * <p>
     * 表示每个学生做过的题目起始位置和结束位置（这两个位置的题都被做过）。
     * <p>
     * <p>
     * Output
     * 输出包括一行，这一行只包含一个整数，表示这N个学生都未做过的题目数量。
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] ds = line.split(" ");
        //让得到的题目总数和学生总数从字符串转换为int类型
        int question = Integer.parseInt(ds[0]);
        int student = Integer.parseInt(ds[1]);
        int[] se = new int[student * 2];
        for (int i = 0; i < (student * 2); i = i + 2) {
            se[i] = sc.nextInt();
            se[i + 1] = sc.nextInt();
        }
        if (student == 0) {
            System.out.print(question);
        } else {
            int number;
            try {
                number = Main.Number(question, student, se);
                System.out.print(number);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        sc.close();
    }


    public static int Number(int question, int student, int[] se) {
        int m = 0;
        for (int i = 1; i <= question; i++) {
            int n = 0;
            for (int j = 0; j < se.length; j = j + 2) {
                if (i < se[j] || i > se[j + 1]) {
                    n = n + 1;
                }
            }
            if (n == student) {
                m = m + 1;
            }
        }
        return m;
    }
}

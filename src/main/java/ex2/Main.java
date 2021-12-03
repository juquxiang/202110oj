package ex2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author qx
 */
class Main {
    /**
     * Description
     *
     * 给你一个后缀表达式，请计算其结果并输出。
     *
     * 比如中缀表达式：( 1 + 2 ) * 3  对应的后缀表达式为: 1 2 + 3 *,其计算结果为9。
     *
     * 给定的后缀表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
     *
     *
     * Input
     * 输入一行后缀表达式，元素之间空格分隔。
     *
     *
     * Output
     * 输出中缀表达式的计算结果。
     *
     *
     * Sample Input 1
     */
    public static void main(String[] args) {
        /*
          用户输入
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = null;
        try {
            str = br.readLine().split(" ");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assert str != null;
        System.out.println(evalRpn(str));
    }

    public static int evalRpn(String[] tokens) {
        Stack<Integer> sta = new Stack<>();
        for (String token : tokens) {
            try {
                sta.push(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                //符号
                int lat = sta.pop();
                int pre = sta.pop();
                if ("+".equals(token)) {
                    sta.push(pre + lat);
                } else if ("-".equals(token)) {
                    sta.push(pre - lat);
                } else if ("*".equals(token)) {
                    sta.push(pre * lat);
                } else {
                    sta.push(pre / lat);
                }
            }
        }
        return sta.peek();
    }
}

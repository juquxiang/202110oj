package ex2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author qx
 */
class Main {

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

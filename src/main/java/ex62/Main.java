package ex62;

import java.util.Scanner;

/**
 * @author qx
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(countNumberOf2s1(scanner.nextInt()));
    }
    // 时间复杂度过高在线OJ不通过
    public static int countNumberOf2s(int n) {
        // write code here
        int count = 0;
        for (int i = 0; i <= n; i++) {
            String s = Integer.toString(i);
            for (char ch : s.toCharArray()){
                if(ch == '2'){
                    count++;
                }
            }
        }
        return count;
    }

    public static int countNumberOf2s1(int n) {
        int div=1;
        int count=0;
        while(n/div != 0)
        {
            //div=1代表最低位，div=10代表次低位...
            int num=n/div;
            int cur=num%10;
            int high=num/10;
            int low=n%div;
            if(cur<2)
            {
                count+=high*div;
            }
            else if(cur==2)
            {
                count+=high*div+(low+1);
            }
            else
            {
                count+=(high+1)*div;
            }
            if(n/div<20)
                break;
            div=10*div;
        }
        return count;
    }
}

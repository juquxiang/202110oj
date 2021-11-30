package ex70;

/**
 * @author qx
 */
public class Main {

    public static void main(String[] args) {
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{2,1,1};
        System.out.println(test(g, s));
    }
    /**
     * 描述
     *
     * 假设你是动物园的饲养员，工作是每天给猴子分发香蕉，猴子们的胃口和香蕉都有大有小，但是每天每只猴子只能得到一根香蕉。
     *
     * 对每个猴子i，都有一个胃口值g[i]，这是能让猴子们们满足胃口的香蕉的最小重量；每个香蕉都有一个重量s[j]。如果s[j]>= g[i]，我们可以将这根香蕉j分配给猴子i，这个猴子就会感到满足，不会大喊大叫。你的目标是尽可能满足越多数量的猴子，并输出这个最大数值。
     *
     *
     * 输入
     * 首先输入猴子个数 n1
     *
     * 输入每个猴子对应的胃口值的数组g[i]
     *
     * 输入香蕉的个数n2
     *
     * 输入每根香蕉的重量数组s[i]
     *
     *
     * 输出
     * 输出能使多少只猴子达到满足状态，输出这个最大值
     */
    public static int test(int[] g, int[] s){
        int n1 = g.length;
        int n2 = s.length;
        int[] dp = new int[n1];
        for(int i = 0; i < n2; i++){
            for(int j = 0; j < n1; j++){
                if(s[i] >= g[j]){
                    dp[j] = Math.max(dp[j], i + 1);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n1; i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

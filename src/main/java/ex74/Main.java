package ex74;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author qx
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int beefSlices = scanner.nextInt();
        int cheeseSlices = scanner.nextInt();
        System.out.println(new Main().numOfBurgers(beefSlices,cheeseSlices));
    }
    /**
     * Description
     *
     * 绿色厨房的宗旨是不浪费任何食物。
     *
     * 现针对三明治制定合理的制作计划。有两个整数 beefSlices 和 cheeseSlices，分别表示牛肉片和奶酪片的数目。不同三明治的原料搭配如下：
     *
     * 大三明治：4 片牛肉和 1 片奶酪
     *
     * 小三明治：2 片牛肉和 1 片奶酪
     *
     * 请以 [big_sandwich, small_sandwich]（[大三明治总数，小三明治总数]）的格式返回恰当的制作方案，使得剩下的牛肉片 beefSlices 和奶酪片 cheeseSlices 的数量都是 0。
     *
     * 如果无法使剩下的牛肉片 beefSlices 和奶酪片 cheeseSlices 的数量为 0，就请返回 []。
     *
     *
     * Input
     * 输入牛肉片数量beefSlices
     *
     * 输入奶酪片数量cheeseSlices
     *
     *
     * Output
     * 请以 [big_sandwich, small_sandwich]（[大三明治总数，小三明治总数]）的格式返回恰当的制作方案，使得剩下的牛肉片 beefSlices 和奶酪片 cheeseSlices 的数量都是 0。
     *
     * 如果无法使剩下的牛肉片 beefSlices 和奶酪片 cheeseSlices 的数量为 0，就请返回 []。
     */
    public List<Integer> numOfBurgers(int beefSlices, int cheeseSlices) {
        //4x+2y=t，x+y=c，那么x=t/2-c，y=2c-t/2
        if(beefSlices%2==1||beefSlices/2-cheeseSlices<0||2*cheeseSlices-beefSlices/2<0){return new ArrayList<>();}
        List<Integer> ans=new ArrayList<>();
        ans.add(beefSlices/2-cheeseSlices);
        ans.add(2*cheeseSlices-beefSlices/2);
        return ans;
    }
}

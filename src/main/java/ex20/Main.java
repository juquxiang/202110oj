package ex20;

/**
 * @author qx
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] numbers = str.split(",");
        int[] array = new int[1000];
        for(int i = 0;i<array.length;i++) {
            array[i] = 0;
        }
        //去掉头尾
        String[] top = numbers[0].split("\\[");
        array[Integer.valueOf(top[1])]++;
        String[] base = numbers[numbers.length-1].split("\\]");
        array[Integer.valueOf(base[0])]++;
        for(int i = 1;i<numbers.length-1;i++)
        {
            array[Integer.valueOf(numbers[i])]++;
            if(array[Integer.valueOf(numbers[i])]>numbers.length/2)
            {
                System.out.println(Integer.valueOf(numbers[i]));
                break;
            }
        }

    }
}

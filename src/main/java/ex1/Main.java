package ex1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author qx
 */
class Main {

    public static void main(String[] args) {
        /*
          用户输入
         */
        Scanner sc = new Scanner(System.in);
        int length1 = sc.nextInt();
        int[] arr1 = new int[length1];
        for (int i = 0; i < length1; i++) {
            int b = sc.nextInt();
            arr1[i] = b;
        }
        int length2 = sc.nextInt();
        int[] arr2 = new int[length2];
        for (int i = 0; i < length2; i++) {
            int b = sc.nextInt();
            arr2[i] = b;
        }
        int length3 = length1 + length2;
        int[] arr3 = new int[length3];
        for (int j = 0; j < length3; j++) {
            arr3[j] = 0;
        }
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.arraycopy(arr2, 0, arr3, length1, length2);
        Arrays.sort(arr3);
        for(int a:arr3) {
            System.out.print(a+" ");
        }
    }
}

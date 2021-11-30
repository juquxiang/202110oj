//package ex54;
//
//import java.util.Scanner;
//
//public class Main {
//    /**
//     * 第一行输入为X和N，X为可使用钱总额，N为零食种类。
//     *
//     * 第二行开始为零食属性，每行为3个整型数，分别代表零食价格，数量以及喜爱度。
//     */
//    public static void main(String[] args){
//        Scanner scanner = new Scanner();
//        int x = scanner.nextInt();
//        int n = scanner.nextInt();
//        int[] prices = new int[n];
//        int[] amounts = new int[n];
//        int[] likes = new int[n];
//        for (int i = 0; i < n; i++) {
//            prices[i] = scanner.nextInt();
//            amounts[i] = scanner.nextInt();
//            likes[i] = scanner.nextInt();
//        }
//        Solution solution = new Solution();
//        int result = solution.maxValue(x, prices, amounts, likes);
//        System.out.println(result);
//    }
//    /**
//     * 小朋友考试得到第一名可以得到奖励零食，现有价格A , B , C , D , E . . . A,B,C,D,E...A,B,C,D,E...元商品各A 1 , B 1 , C 1 , D 1 , E 1... A1,B1,C1,D1,E1...A1,B1,C1,D1,E1...个，小朋友的喜爱度依次为A 2 , B 2 , C 2 , D 2 , E 2 , . . . . . A2,B2,C2,D2,E2,.....A2,B2,C2,D2,E2,.....请返回选取X XX元零食可达到的最大喜爱度。
//     */
//
//}

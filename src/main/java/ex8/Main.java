package ex8;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        String a[]= {"","+","-","*","/"};//四种符号
        int i,j;//变量
        int w[]=new int[5];//符号的位数
        int sign;//正负号
        int count=0;//计数
        int []c=new int[5];//输入的数字
        int result;//输入的结果值
        float left,right;
        Scanner input=new Scanner(System.in);
        for( i=0;i<5;i++) {
            c[i]=input.nextInt();
        }

        result=input.nextInt();

        for(w[0]=1;w[0]<=4;w[0]++) {
            if(w[0]<3||c[1]!=0) {
                for(w[1]=1;w[1]<=4;w[1]++) {
                    if(w[1]<3||c[2]!=0) {
                        for(w[2]=1;w[2]<=4;w[2]++) {
                            if(w[2]<3||c[3]!=0) {
                                for(w[3]=1;w[3]<=4;w[3]++) {
                                    if(w[3]<3||c[4]!=0) {
                                        left=0;
                                        right=c[0];
                                        sign=1;
                                        for(j=0;j<=3;j++) {
                                            switch(a[w[j]]) {
                                                case "+":
                                                    left=left+sign*right;
                                                    sign=1;
                                                    right=c[j+1];
                                                    break;
                                                case"-":
                                                    left=left+sign*right;
                                                    sign=-1;
                                                    right=c[j+1];
                                                    break;
                                                case"*":
                                                    right=right*c[j+1];
                                                    break;
                                                case"/":
                                                    right=right/c[j+1];
                                                    break;
                                            }
                                        }
                                        if(left+sign*right==result) {
                                            count++;
                                            //System.out.print("方法"+count+" :");
                                            for(i=0;i<5;i++) {
                                                System.out.print(c[i]);
                                                System.out.print(a[w[i]]);
                                            }
                                            System.out.print("="+result);
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
package base;

import java.util.Scanner;

public class Base {
    //十进制转换其他进制
    public static String tenTo(int number,int radix){
        String str=Integer.toString(number,radix);
        return str;
    }
    //其他进制转换十进制
    public static int toTen(String str,int radix){
        int number=Integer.valueOf(str,radix);
        return number;
    }
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入你要转换的数的进制：");
        int radix1=scanner.nextInt();
        System.out.print("请输入你要转换的数：");
        String str=scanner.next();
        System.out.print("请输入你要转换成的进制：");
        int radix2=scanner.nextInt();
        String result=tenTo(toTen(str,radix1),radix2);
        System.out.println("转换结果为："+result);
    }
}

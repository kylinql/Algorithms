package test3;

import java.util.Scanner;

/**
 * 将一个正整数用二进制表示，并转化为一个String对象
 * @author Kylin
 *
 */

public class NumToBinaryString {

	/**
	 * 自定义方法实现二进制表示
	 * @param num
	 * @return
	 */
	public static String toBinaryString(int num){
		String s = "";
		for(int i = num; i > 0; i /= 2){
			s = (i%2) + s;
		}
		return s;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		System.out.println(NumToBinaryString.toBinaryString(num));
//		自定义实现
		
		
//		使用Integer的内置方法实现
//		System.out.println(Integer.toBinaryString(num));
	}

}

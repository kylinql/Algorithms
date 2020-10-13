package test4;

import java.util.Scanner;

/**
 * 数制转换
 * @author Kylin
 *
 */
public class NumTranslation {

	public static void translate(int n, int base){
		int c;
		if(n == 0){
			System.out.println();
			return;
		}
		else{
			c = n % base;
			translate(n/base, base);
			System.out.print(c);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要转换的数：");
		int n = sc.nextInt();
		System.out.println("请输入转换的进制：");
		int base = sc.nextInt();
		
		System.out.println("转换结果：");
		NumTranslation.translate(n, base);
	}

}

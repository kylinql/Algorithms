package test4;

import java.util.Scanner;

/**
 * 斐波那契数列
 * @author Kylin
 *
 */
public class Fibnacci {

	/**
	 * 这里用的递归，不过尽量少用，比较费时
	 * @param n
	 * @return
	 */
	public static int calculate(int n){
		if (n == 0 || n == 1){
			return 1;
		}
		else{
			return calculate(n-1) + calculate(n-2);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num = Fibnacci.calculate(n);
		System.out.println("第" + n + "个月的小兔子个数为" + num);
		
	}

}

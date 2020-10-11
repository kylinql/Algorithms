package test3;

import java.util.Scanner;

/**
 * 欧几里得求最大公约数
 * @author Kylin
 *
 */

public class Euclid {

	public static int commonDivisor(int x, int y){
		System.out.println("x =" + x + ", y = " + y);
		return y == 0? x : commonDivisor(y, x % y);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(Euclid.commonDivisor(a, b));
	}

}

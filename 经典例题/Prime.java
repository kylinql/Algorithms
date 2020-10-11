package test3;

import java.util.Scanner;

/**
 * 判断是否为素数
 * @author Kylin
 *
 */
public class Prime {
	/**
	 * 判断num是否为一个素数
	 * @param num
	 * @return
	 */
	public static boolean isPrime(int num){
		if(num < 2){
			return false;
		}
		for (int i = 2; i*i <= num; i++) {
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		boolean flag = Prime.isPrime(n);
		if(flag){
			System.out.println(n + "是素数");
		}
		else{
			System.out.println(n + "不是素数");
		}
		
	}

}

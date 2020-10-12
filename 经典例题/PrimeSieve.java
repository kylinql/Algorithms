package test3;

import java.util.Scanner;

/**
 * 计算质数的个数
 * @author Kylin
 *
 */
public class PrimeSieve {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//用数组记录下当前数据是否为素数
		boolean[] isPrime = new boolean[n+1];
		for (int i = 2; i <= n; i++) {
			isPrime[i] = true;
		}
		
//		num用于存储素数个数
		int num = 0;
		for (int factor = 2; factor*factor <= n; factor++) {
			if(!isPrime[factor]){
				continue;
			}
			for (int j = 2; factor*j <= n; j++) {
	            isPrime[factor*j] = false;
	        }
		}
		
//		System.out.println("有" + num + "个素数， 分别是：");
		for (int i = 2; i < isPrime.length; i++) {
			if(isPrime[i]){
				System.out.print(i + " ");
				num++;
			}
		}
		System.out.println("有" + num + "个素数");
	}
}
		

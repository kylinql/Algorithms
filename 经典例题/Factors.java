package test3;

import java.util.Scanner;

/**
 * 素数分解
 * 计算一个数据的素数分解
 * 例如8的分解：2 2 2
 * 例如17的分解：17
 * @author Kylin
 *
 */
public class Factors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long num = sc.nextLong();
		long t = num;
		
		System.out.println(num + "的素数分解为：");
		
		for (long i = 2; i*i < t; i++) {
			while (t % i == 0){
				System.out.print(i + " ");
				t /= i;
			}
		}
		
	
		if(t > 1){
			System.out.println(t);
		}
		else{
			System.out.println();
		}
	}

}

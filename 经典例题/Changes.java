package test4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 贪婪算法
 * 
 * 兑换零钱
 * 用户输入需要找回的钱数，计算找回方案数
 * @author Kylin
 *
 */
public class Changes {

	//定义以分为单位的零钱
	static int value[] = {10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10};
	static int nums[];
	public static void exchange(int n){
		int i;
		nums = new int[10];
		for (i = 0; i < 10; i++) {
			if(n >= value[i]){
				//找到比n小的面值
				break;
			}
		}
		
		while(n > 0 && i < 10){
			if(n >= value[i]){
				n -= value[i];
				nums[i]++;
			}
			else if(n < 10 && n >= 5){
				nums[9]++;
				break;
			}
			else{
				i++;
			}
		}
		System.out.println(Arrays.toString(nums));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double money = sc.nextDouble();
		int tMoney = (int)(money*100); //转化单位为分
		exchange(tMoney);
		for (int i = 0; i < 10; i++) {
			if(Changes.nums[i] > 0){
				System.out.printf("%6.2f: %d张\n", Changes.value[i]/100.0, Changes.nums[i]);
			}
		}
	}
}

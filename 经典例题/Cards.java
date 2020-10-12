package test3;

import java.util.Scanner;

/**
 * 给定n种卡片类型，计算需要的随机卡片张数
 * 要保证每一种卡片至少有1张
 * (主要考察Math.random()的使用，生成一个[0,1)的随机数)
 * @author 尚梦琦
 *
 */
public class Cards {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		type用于存储卡片种类
		int type = sc.nextInt();
		boolean[] isCollected = new boolean[type]; //卡片是否已经被收集
		int count = 0; //收集的卡总数
		int distinct = 0;
		
		/**
		 * 利用随机数生成一个卡片，判断它是否被收集过
		 */
		while(distinct < type){
			int value = (int) (Math.random() * type);
			count ++;
			if(!isCollected[value]){
				distinct++;
				isCollected[value] = true;
			}
		}
		
		System.out.println(count);
	}

}

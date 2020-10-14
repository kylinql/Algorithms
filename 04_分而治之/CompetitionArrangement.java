package test4;

import java.util.Scanner;

/**
 * 比赛日程安排：
 * 重点考察：分治法
 * (1)分解：将要求解的问题划分成若干个规模较小的同类问题
 * (2)求解：当子问题划分得足够小时，用教简单的方法解决
 * (3)合并：按求解问题的要求，将子问题的解逐层合并，构成最终解
 * @author Kylin
 *
 */
public class CompetitionArrangement {

	int[][] table;
	
	
	public CompetitionArrangement(int n) {
		//为了便于处理，0号位置不用
		this.table = new int[n+1][n+1];
	}

	/**
	 * 日程安排（从k号选手开始，安排n位选手的日程）
	 * @param k 需要安排的选手的起始编号
	 * @param n 选手数量
	 */
	public void gamecal(int k, int n){
		//直接安排
		if(n == 2){
			table[k][1] = k;
			table[k][2] = k+1;
			table[k+1][1] = k+1;
			table[k+1][2] = k;
		}
		else{
			//处理左上角的内容
			//分治法的主要体现
			gamecal(k,n/2); //前n/2个人
			gamecal(k+n/2, n/2); //后n/2个人
			
			//填充合并
			//右上角
			for (int i = k; i < k + n/2; i++) {
				for (int j = n/2+1 ; j <= n; j++) {
					table[i][j] = table[i+n/2][j-n/2];
				}
			}

			//右下角
			for (int i = k+n/2; i < k+n; i++) {
				for (int j = n/2+1; j <= n; j++) {
					table[i][j] = table[i-n/2][j-n/2];
				}
			}
			
			
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int competitorNum = sc.nextInt(); //参赛人数
			int i;
			int j = 1;
			for(i = 2; i < 8; i++) {
				j = j * 2;
				if(j == competitorNum){
					break;
				}
			}
			
			if(i >= 8){
				System.out.println("参赛选手人数必须为2的整数次幂，且不超过64");
			}
			else{
				CompetitionArrangement c = new CompetitionArrangement(competitorNum);
				c.gamecal(1, competitorNum);
				
				for (int day = 1; day <= competitorNum; day++) {
					System.out.printf("%2d天  ", day);
				}
				System.out.println();
				
				for (int p = 1; p <= competitorNum; p++) {
					for (int q = 1; q <= competitorNum; q++) {
						System.out.printf("%3d ", c.table[p][q]);
					}
					System.out.println();
				}
			}

	}

}

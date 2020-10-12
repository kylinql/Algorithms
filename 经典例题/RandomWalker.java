package test3;

import java.util.Scanner;

/**
 * 假设n个随机步行者从n×n网格的中心开始，一次移动一个步骤，并选择在每个步骤中以相等的概率向左，向右，向上或向下移动。 
 * 编写一个程序来计算关于走完所有单元需要走多少步。
 * @author Kylin
 *
 */
public class RandomWalker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		int cellsToVisit = n*n; //剩下要访问的单元数
		int steps = 0; //计算走过的步数
		double r;
		boolean[][] visited = new boolean[n][n]; //判断是否走过
		
		//从中点开始
		for(int i = 0; i < n; i++){
			x[i] = n / 2;
			y[i] = n / 2;
		}
		
		visited[n/2][n/2] = true;
		cellsToVisit--;
		
		while(cellsToVisit > 0){
			steps++;
			
			for (int i = 0; i < n; i++) {
				r = Math.random();
				
				if(r <= 0.25){
					x[i]--;
				}
				else if(r <= 0.5){
					x[i]++;
				}
				else if(r <= 0.75){
					y[i]--;
				}
				else{
					y[i]++;
				}
				
				if(x[i] < n && y[i] < n && x[i] >= 0 && y[i] >= 0 && !visited[x[i]][y[i]]){
					cellsToVisit--;
					visited[x[i]][y[i]] = true;
				}
			}
		}
		
		System.out.println("Need " + steps + "!");
	}

}

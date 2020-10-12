package test3;

import java.util.Scanner;

/**
 * 哈达玛矩阵
 * n阶哈达玛矩阵是一个布尔矩阵，其显着特性是任意两行都有n/2位不同。 
 * （此属性对于设计纠错码很有用。）
 * 例如：
 * 		H（1）是单项为true的1阶矩阵。
 * 		对于n> 1，H（2n）时通过对齐H(n)的四个副本在一个大正方形中显示，然后按右下角n到n的方式反转所有条目
 *     （照常，T代表true，F代表false）。
 * @author Kylin
 *
 */

public class HadamardMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[][] Hadmard = new boolean[n][n];
		
		Hadmard[0][0] = true;
		for (int k = 1; k < n; k+=k) {
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < k; j++) {
					Hadmard[i+k][j] = Hadmard[i][j];
					Hadmard[i][j+k] = Hadmard[i][j];
					Hadmard[i+k][j+k] = !Hadmard[i][j];
				}
			}
		}
		
		//output
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(Hadmard[i][j]){
					System.out.print("T");
				}
				else{
					System.out.print("O");
				}
			}
			System.out.println();
		}
	}

}

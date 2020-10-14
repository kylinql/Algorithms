package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 选择排序：
 * 	对n个记录进行扫描，选择最小的记录，将其输出，接着在剩下的n-1的记录中扫描，选择最小的记录。。
 *  交换次数为n次，与输入线性相关，比较次数N2/2
 * @author Kylin 
 *
 */
public class SelectSort {
	public static void sort(int[] a){
		int t, min;
		for (int i = 0; i < a.length - 1; i++) {
			min = i;
			for (int j = i+1; j < a.length; j++) {
				if(a[j] < a[min]){
					min = j;
				}
			}
			t = a[i];
			a[i] = a[min];
			a[min] = t;
			
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//输入用于随机数产生的数据
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = sc.nextInt();
		int max = sc.nextInt();
		int[] array = RandomGenerator.generate(n, min, max);
		System.out.println("-----排序前-------");
		System.out.println(Arrays.toString(array));
		
		SelectSort.sort(array);
		System.out.println("------排序后------");
		System.out.println(Arrays.toString(array));

	}

}

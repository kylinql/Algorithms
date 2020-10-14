package sort;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 冒泡排序法
 * 从后往前，或者从前往后依次遍历数组，当发现相邻两个关键字的次序于排序要求的不符合时，
 * 就将这两个记录进行交换。这样，关键字将逐步移动，就像气泡从水中浮起来一样。
 * 
 * @author Kylin
 *
 */
public class PopSort {

	public static void sort(int[] a){
		int t;
		for (int i = 0; i < a.length-1; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[i] > a[j]){
					t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			}
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
		
		PopSort.sort(array);
		System.out.println("------排序后------");
		System.out.println(Arrays.toString(array));
	}

}

package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 希尔排序法
 * 插入排序的一种改进算法，基本思想：使数组中任意间隔为h的元素都是有序的
 * 将需要排序的序列划分为若干个较小的序列，对这些序列进行直接插入排序，通过这样的操作可使
 * 需要排序的数列基本有序，最后再使用一次直接插入排序。
 * 时间复杂度：O(nlogn)
 * @author Kylin
 *
 */
public class ShellSort {

	/**
	 * 需要排序的数组元素
	 * @param a
	 */
	public static void sort(int a[]){
		int n = a.length;
		int h = n/2; //步长初始为序列的一半
		int x, j;
		while(h >= 1){
			//将数组变为h有序
			for (int i = h; i < n; i++) {
				x = a[i]; //获取序列中的下一个数据
				j = i-h; //位于前第j个元素的索引
				while(j >= 0 && a[j] > x){
					a[j+h] = a[j];
					j = j-h;
				}
				a[j+h] = x;
			}
			h /= 2; //增量缩减一半
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
		
		ShellSort.sort(array);
		System.out.println("------排序后------");
		System.out.println(Arrays.toString(array));

	}

}

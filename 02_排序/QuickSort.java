package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 快速排序
 * 使用分治策略把待排序数据序列分成两个子序列：
 * 	 1. 首先从数列中挑出一个元素，该元素称为“基准”
 *   2. 扫描一遍数列，将所有比“基准”小的元素排基准前面，所有比“基准大的元素，排在基准后面
 *   3. 通过递归，将各子序列划分为更小的序列，直到把小于基准值元素的子数列和大于基准值元素的子数列排序
 * @author Kylin
 *
 */
public class QuickSort {

	/**
	 * 数据分割函数
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	public static int partion(int[] a, int left, int right){
		int pivot = a[left]; //设定切分点，即枢轴元素
		while(left < right){
			while(left < right && a[right] >= pivot){
				//从右向左找到比基准小的数据
				right--;
			}
			a[left] = a[right];
			while(left < right && a[left] <= pivot){
				//从左向右找到比基准大的数据
				left++;
			}
			a[right] = a[left];
		}
		//将基准元素放置到数组中
		a[left] = pivot;
		return left; //返回基准元素现在所在的位置
	}
	
	/**
	 * 排序函数
	 * @param a
	 * @param left
	 * @param right
	 */
	public static void sort(int a[], int left, int right){
		int i;
		if(left < right){
			i = partion(a, left, right);
			sort(a, left, i-1);
			sort(a, i+1, right);
		}
	}
	
	public static void sort(int a[]){
		sort(a, 0, a.length-1);
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
		
		QuickSort.sort(array);
		System.out.println("------排序后------");
		System.out.println(Arrays.toString(array));

	}

}

package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 堆排序
 * 1. 将无序序列构成一个堆，根据升序降序需求选择大顶堆或小顶堆
 *    升序一般采用大顶堆，降序一般采用小顶堆
 * 2. 将堆顶元素与末尾元素交换，将最大元素沉到末端
 * 3. 调整结构，使其满足堆定义
 * 
 * @author Kylin
 *
 */
public class HeapSort {
	
	/**
	 * 构建大堆顶
	 * @param a 数组
	 * @param len 数组长度
	 */
	public static void buildMaxHeap(int[] a, int len){
		//从最后一个非叶节点向前遍历，调整节点
		for (int i = (int)Math.floor(len/2) - 1; i >= 0; i--) {
			heapify(a, i, len);
		}
	}
	
	/**
	 * 调整数组
	 * @param a
	 * @param i
	 * @param len
	 */
	public static void heapify(int[] a, int i, int len){
		//根据堆的性质，找出它左右节点的索引
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		//默认当前节点使最大值
		int largestIndex = i;
		
		if(left < len && a[left] > a[largestIndex]){
			//如果左节点的值比当前值大，则更新largestIndex
			largestIndex = left;
		}
		
		if(right < len && a[right] > a[largestIndex]){
			largestIndex = right;
		}
		
		if(largestIndex != i){
			//判断当前节点是否发生变化，如果发生变化，就调整节点顺序
			swap(a, i, largestIndex);
			//重新调整节点顺序
			heapify(a, largestIndex, len);
		}
	}
	
	public static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	/**
	 * 堆排序的实现
	 * @param a
	 * @param n
	 */
	public static void sort(int a[]){
		int len = a.length;
		
		//首先构造大堆顶
		buildMaxHeap(a, len);
		
		//交换堆顶和当前末尾的节点，重置大堆顶
		for (int i = len-1; i > 0; i--) {
			swap(a, 0, i);
			len--;
			heapify(a, 0, len);
		}
	}
	
	public static void main(String[] args) {
		//输入用于随机数产生的数据
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = sc.nextInt();
		int max = sc.nextInt();
		int[] array = RandomGenerator.generate(n, min, max);
		System.out.println("-----排序前-------");
		System.out.println(Arrays.toString(array));
		
		HeapSort.sort(array);
		System.out.println("------排序后------");
		System.out.println(Arrays.toString(array));
	}

}

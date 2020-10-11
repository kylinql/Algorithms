package search;

import java.util.Arrays;

/**
 * 二分查找的java实现
 * 内置排序功能，无需有序数组
 * @author Kylin
 *
 */

public class BinarySearch3 {
	private int[] array;
	
	
	public BinarySearch3(int[] array) {
		this.array = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			this.array[i] = array[i];
		}
		Arrays.sort(this.array);
	}
	
	public boolean contains(int key){
		return rank(key) != -1;
	}
	
	public int rank(int key){
		int low = 0;
		int high = array.length - 1;
		while(low <= high){
			int mid = low + (high - low) / 2;
			if(key < array[mid]){
				high = mid - 1;
			}
			else if(key > array[mid]){
				low = mid + 1;
			}
			else{
				return mid;
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3, 1, 2, 5, 6, 8, 0};
		BinarySearch3 search = new BinarySearch3(array);
		int key = 5;
		System.out.println(search.contains(key));
	}

}

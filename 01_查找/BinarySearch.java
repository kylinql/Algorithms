package search;

/**
 * 二分查找的实现：
 * 
 * 前提：
 * 	    数组有序
 * 
 * @author Kylin
 *
 */

public class BinarySearch {
	/**
	 * 在数组中查找是否存在key元素
	 * 	若存在则返回其下标，若不存在则返回-1
	 * @param key
	 * @param array
	 * @return
	 */
	public static int rank(int key, int[] array){
		int low = 0;
		int high = array.length - 1;
		
		while(low <= high){
			int mid = low + (high - low) / 2;
			if(key > array[mid]){
				low = mid + 1;
			}
			else if(key < array[mid]){
				high = mid - 1;
			}
			else{
				return mid;
			}
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		int[] array = {1, 2, 5, 10};
		System.out.println(BinarySearch.rank(2, array));
	}

}

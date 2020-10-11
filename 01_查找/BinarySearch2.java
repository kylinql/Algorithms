package search;
/**
 * ¶þ·Ö²éÕÒµÝ¹é°æ
 * @author Kylin
 *
 */
public class BinarySearch2 {

	public static int rank(int key, int[] a){
		return binarySearch(key, a, 0, a.length - 1);
	}
	
	public static int binarySearch(int key, int[] a, int low, int high){
		if(low > high){
			return -1;
		}
		int mid = low + (high - low) / 2;
		if(key < a[mid]){
			return binarySearch(key, a, low, mid);
		}
		else if(key > a[mid]){
			return binarySearch(key, a, mid, high);
		}
		return mid;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3, 5, 5, 6, 8, 19};
		System.out.println(BinarySearch2.rank(6, array));
	}

}

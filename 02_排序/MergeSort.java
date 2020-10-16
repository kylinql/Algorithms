package sort;
/**
 * 归并排序法
 * 将两个或多个有序表合并成一个有序表
 * 	递归将它分成两半分别排序，之后将结果合并起来
 * @author Kylin
 *
 */
public class MergeSort {
	
	/**
	 * 相邻有序段的合并
	 * @param a 原数据 
	 * @param r 保存合并后的数据
	 * @param low 序列起始序号
	 * @param mid 第一个序列结束的序号
	 * @param high 序列的长度
	 */
	public static void merge(int[] a, int[] r, int low, int mid, int high){
		int i, j, k;
		k = low;
		i = low;
		j = mid+1;
		//比较两个有序表
		while(i <= mid && j <= high){
			if(a[i] <= a[j]){
				r[k++] = a[i++];
			}
			else{
				r[k++] = a[j++];
			}
		}
		while(i <= mid ){
			r[k++] = a[i++];
		}
		while(j <= high){
			r[k++] = a[j++];
		}
	}
	
	/**
	 * 完成二路合并的函数
	 * @param a
	 * @param r
	 * @param n
	 * @param len
	 */
	public static void mergePass(int a[], int r[], int n, int len){
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package sort;

import java.util.Arrays;
import java.util.Scanner;

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
     * 将a[low...mid]和a[mid+1...high]合并
     * @param a 原数据
     * @param low 序列起始序号
     * @param mid 第一个序列结束的序号
     * @param high 序列的长度
     */
    public static void merge(int[] a, int low, int mid, int high){
        // merge back to a[]
        int[] b = Arrays.copyOf(a, a.length);
        int i = low, j = mid+1;

        for (int k = low; k <= high; k++) {
            if(i > mid)
                // 左边用尽
                a[k] = b[j++];
            else if (j > high)
                // 右边用尽
                a[k] = b[i++];
            else if (less(b[j], b[i]))
                // 判断b[j]与b[i]的大小
                a[k] = b[j++];
            else
                a[k] = b[i++];
        }
    }

    /**
     * 排序主函数
     * @param a
     * @param low
     * @param high
     */
    public static void sort(int[] a, int low, int high){
        if(high <= low){
            return;
        }
        int mid = low + (high - low) / 2;
        sort(a, low, mid); //左边排序
        sort(a, mid+1, high); //右边排序
        merge(a, low, mid, high);

    }

    // is v < w ?
    private static boolean less(int v, int w) {
        return v - w < 0;
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

        MergeSort.sort(array, 0, n-1);
        System.out.println("------排序后------");
        System.out.println(Arrays.toString(array));


    }

}

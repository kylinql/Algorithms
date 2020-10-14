import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 插入排序的实现：
 *  索引左边的元素都是有序的，但是最终位置还不确定
 */

public class InsertSort {
    public static void sort(int[] a){
        int n = a.length;
        int t, j;
        for (int i = 1; i < n ; i++) {
            t = a[i];
            for (j = i-1; j >= 0 && t < a[j]; j--) {
                a[j+1] = a[j];
            }
            a[j+1] = t;
        }
    }

    public static int[] generate(int n, int min, int max){
        int[] num = new int[n];
        int r;

        for (int i = 0; i < n; i++) {
            r =(int)((max - min + 1) * Math.random()) + min;
            num[i] = r;
        }

        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int min = sc.nextInt();
        int max = sc.nextInt();

        int[] array = generate(n, min, max);
        System.out.println("-----排序前------");
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println("-----排序后--------");
        System.out.println(Arrays.toString(array));
    }
}

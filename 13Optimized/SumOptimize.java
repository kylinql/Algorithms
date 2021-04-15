import java.util.Arrays;
import java.util.Scanner;

/**
 * 优化数组求和问题
 *
 * 给定数组，找到数组中两两元素之和为0的数据对个数
 * 普通方法的时间：O(n^2)
 * 优化后时间：O(nlogn)
 */
public class SumOptimize {
    public static void main(String[] args) {
        //1. 输入数据
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        //2. 查看数组
        System.out.println(Arrays.toString(a));

        //3. 使用未优化的双循环方法
        count(a);

        //4. 优化后的方法，利用二分查找进行优化
        optimizeCount(a);
    }

    /**
     * 未优化的统计方法
     */
    public static void count(int[] a){

        int n = a.length;
        int cnt = 0;

        long start = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (a[i] + a[j] == 0){
                    cnt++;
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("Time : " + (end - start));

        System.out.println("Ordinary count method : " + cnt);
    }

    /**
     * 优化方法
     * 时间复杂度O(nlogn)
     */
    public static void optimizeCount(int[] a) {
        int n = a.length;
        int cnt = 0;

        // 深拷贝，以避免修改原始数组
        int[] b = Arrays.copyOf(a, n);
        System.out.println(Arrays.toString(b));

        // 数据排序，然后用二分查找
        Arrays.sort(b);

        // 遍历一次数组，对于每个数据，利用二分查找判断负数是否存在。
        // 二分查找的时间复杂度是O(logn)
        for (int i = 0; i < n; i++) {
            if(BinarySearch.rank(-b[i], b) > i){
                cnt++;
            }
        }
        System.out.println("Optimized Count Method : " + cnt);
    }
}

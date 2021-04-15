package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 简单选择排序：
 * 首先，找到数据中最小的元素；
 * 然后，将它与数组中第一个元素交换位置。
 * 之后，不断的在剩余元素中进行选择。
 *
 * 时间复杂度：O(n^2)
 */
public class SelectSort {

    public static void main(String[] args) {
        //输入用于随机数产生的数据
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = sc.nextInt();
        int max = sc.nextInt();
        int[] array = RandomGenerator.generate(n, min, max);
        System.out.println("Before sort:\n" + Arrays.toString(array));

        //选择排序
        for (int i = 0; i < n-1; i++) {
            // 1. 首先找到数据最小的那个值的下标
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }

            // 2. 交换
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        System.out.println("After sort:\n" + Arrays.toString(array));
    }

}

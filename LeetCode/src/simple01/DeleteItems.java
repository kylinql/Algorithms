package simple01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给你一个数组nums和一个值 val，
 * 你需要原地移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用O(1)额外空间并原地修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class DeleteItems {
    public static void main(String[] args) {
        // 1. 输入数据
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入元素个数：");
        int n = sc.nextInt();

        System.out.println("请输入元素，空格分隔：");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("请输入想要删除的元素：");
        int target = sc.nextInt();
        int itmesNum = removeElement(array, target);
        System.out.println("删除后的元素个数：" + itmesNum);
        System.out.println("Arrays after deleting:" + Arrays.toString(array));

    }

    /**
     * 删除数组中元素为val的数据
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int targetNum = 0;
        int endIndex = 0;
        boolean flag = false;

        int len = nums.length;

        //先对数据进行排序，便于删除
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        //找到值为val的相关元素，计算此元素的个数
        for (int i = 0; i < len; i++) {
            if(nums[i] == val){
                flag = true;
                targetNum++;
                continue;
            }

            flag = false;

            if((flag == false) && (targetNum != 0)){
                endIndex = i;
                break;
            }
        }

        // 如果没有找到，就返回原始数组的长度
        if(targetNum == 0){
            return len;
        }

        // 如果要删除的元素一直到数组结束
        if(endIndex == 0){
            for (int i = len - targetNum; i < len; i++) {
                nums[i] = 0;
            }
        }
        else{
            // 对数据进行处理，同时将其他元素前置
            for (int i = 0; i < targetNum; i++) {
                nums[endIndex - targetNum + i] = nums[len - 1 - i];
                nums[len - 1 - i] = 0;
            }
        }
        return len-targetNum;
    }
}

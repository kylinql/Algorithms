package simple01;

import java.util.*;

/**
 * 双循环解法：
 *      时间复杂度：O(n^2)
 * 单循环法：
 *      利用查找优化
 *      时间复杂度：O(nlogn)
 */
public class SumCalculate {

    /**
     * 双循环解法：
     * 时间复杂度：O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] sumIndex = new int[2];

        for(int i = 0; i < nums.length-1; i++){
            // 寻找目标转换为：等于target减去该数
            int num = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(num == nums[j]){
                    sumIndex[0] = i;
                    sumIndex[1] = j;
                }
            }
        }
        return sumIndex;
    }

    /**
     * 优化时间复杂度为O(nlog(n))
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int[] sumIndex = new int[2];

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = nums.length-1; i >= 0; i--) {
            list.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            int j = list.indexOf(num);

            if(j == -1 || (nums.length - j - 1) == i){
                continue;
            }
            else{
                sumIndex[0] = i;
                sumIndex[1] = nums.length - j - 1;
                break;
            }
        }
        return sumIndex;
    }

    public static void main(String[] args) {
        //输入用于随机数产生的数据
        Scanner sc = new Scanner(System.in);
        System.out.println("输入数组信息：");
        int n = sc.nextInt();
        int min = sc.nextInt();
        int max = sc.nextInt();

        System.out.println("输入target：");
        int target = sc.nextInt();

        // 1. 生成数据
        int[] array = RandomGenerator.generate(n, min, max);
        System.out.println("======数组数据=======");
        System.out.println(Arrays.toString(array));


        // 2. 找到两数之和为target的数据
        int[] targetIndex = twoSum1(array, target);
        System.out.println("两数之和为" + target + "的下标:");
        System.out.println(Arrays.toString(targetIndex));

        int[] array2 = {3,2,4};

        System.out.println(Arrays.toString(twoSum2(array2, 6)));
    }
}

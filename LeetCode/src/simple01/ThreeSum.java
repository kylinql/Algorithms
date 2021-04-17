package simple01;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 *
 *(该题解为标准题解，时间复杂度O(nlog))
 */
public class ThreeSum {
    public static void main(String[] args) {
//        //输入用于随机数产生的数据
//        Scanner sc = new Scanner(System.in);
//        System.out.println("输入数组信息：");
//        int n = sc.nextInt();
//        int min = sc.nextInt();
//        int max = sc.nextInt();
//
//        // 1. 生成数据
//        int[] array = RandomGenerator.generate(n, min, max);
//        System.out.println("======数组数据=======");
//        System.out.println(Arrays.toString(array));

//        Arrays.sort(array);
//        System.out.println(binarySearch(array, 3));
        // 2. 三数求和
//        int[] array2 = {0, 0, 0};
//        int[] array2 = {-1,0,1,2,-1,-4};
//        int[] array3 = {-1,0,1,0};
        int[] array4 = {3,0,-2,-1,1,2};
        List<List<Integer>> sumZeroList = threeSum(array4);
        System.out.println("======三数之和为0的列表=======");
        System.out.println(sumZeroList);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> zeroList = new ArrayList<>();

        int n = nums.length;
        int t, min, max;
        Object search;

        // 如果长度小于3，直接返回该列表
        if(n < 3){
            return zeroList;
        }

        // 对原数据进行排序，方便处理
        Arrays.sort(nums);

        // 记录当前列表数据集
        HashMap<String, Integer> existed = new HashMap<>();

        //遍历数据
        for (int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                // 如果前后相同，就跳过该数据
                continue;
            }

            //剩下的两数之和为nums[i]的相反数
            t = -nums[i];
            int j = i + 1;
            int k = n - 1;

            // 基于二分思想处理
            while(j < k){
                if (nums[j] + nums[k] > t){
                    k--;
                }
                else if (nums[j] + nums[k] < t){
                    j++;
                }
                else{
                    List<Integer> items = new ArrayList<>();
                    items.add(nums[i]);
                    items.add(nums[j]);
                    items.add(nums[k]);

                    // 当前列表中可能已经存在该序列
                    if(isExisted(items, existed) == false){
                        zeroList.add(items);
                    }

                    j++;
                    k--;
                }
            }
        }

        return zeroList;
    }

    /**
     * 判断当前是否已经存在该序列，如果存在则不用加入到结果列表
     * @param num
     * @param map
     * @return
     */
    public static boolean isExisted(List<Integer> num, HashMap<String, Integer> map){
        String temp = new String();
        Object flag;
        for (int i = 0; i < 3; i++) {
            temp += String.valueOf(num.get(i));
        }

        flag = map.get(temp);

        if(flag == null){
            map.put(temp, 1);
            return false;
        }
        return true;
    }
}

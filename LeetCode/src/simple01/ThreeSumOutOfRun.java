package simple01;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 *
 * (该题解为超时题解，时间复杂度O(n^2))
 *
 */
public class ThreeSumOutOfRun {
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
        int[] array3 = {-1,0,1,0};
//        int[] array4 = {3,0,-2,-1,1,2};
        List<List<Integer>> sumZeroList = threeSum(array3);
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

        // 对原数据进行排序
        Arrays.sort(nums);

        min = nums[0];
        max = nums[n-1];

        //利用字典解决
        Map<Integer,Integer> map = new HashMap<>();
        HashMap<String, Integer> existed = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if(map.get(nums[i]) == null){
                map.put(nums[i],1);
            }
            else{
                int mapTemp = map.get(nums[i]);
                map.put(nums[i], mapTemp+1);
            }
        }

        for (int i = 0; i < n-2; i++) {
            for (int j = i + 1; j < n-1; j++) {
                t = -(nums[i] + nums[j]);

                // 先判断下是否有可能在这个范围内
                if (t > max || t < min) {
                    continue;
                }
                search = map.get(t);

                if (search == null) {
                    continue;
                }

                //需要对两个相等，或者三个相等的数字进行判断处理
                if(t == nums[j] || t == nums[i]){
                    if((int)search < 2){
                        continue;
                    }
                    else if(nums[i] == nums[j] && (int)search < 3){
                        continue;
                    }
                }

                List<Integer> items = new ArrayList<>();
                items.add(nums[i]);
                items.add(nums[j]);
                items.add(t);
                Collections.sort(items);
                if(isExisted(items, existed) == false){
                    zeroList.add(items);
                }
            }
        }
        return zeroList;
    }

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

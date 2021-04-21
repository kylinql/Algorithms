package backtrace04;

import java.util.LinkedList;
import java.util.List;

/**
 * 数据的全排列计算
 */

public class Permute {
    static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(calculate(nums));
    }

    /**
     * 计算一组给定数据的全排列
     * @param nums
     * @return
     */
    public static List<List<Integer>> calculate(int[] nums){
        // track用于记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     * 回溯
     * @param nums 选择列表
     * @param track 路径
     */
    public static void backtrack(int[] nums, LinkedList<Integer> track){
        // 全排列
        // 到达了叶子结点，成功进行判断
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 去掉不合法的选择
            if(track.contains(nums[i])){
                continue;
            }

            // 做选择
            track.add(nums[i]);

            // 进入下一层决策树
            backtrack(nums, track);

            // 取消选择
            track.removeLast();

        }
    }
}

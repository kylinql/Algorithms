package dp03;

import java.util.HashMap;
import java.util.Map;

/**
 * 硬币兑换问题
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 */
public class ExchangeCoin {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 100;
//        System.out.println(dpNormal((coins), amount));
//        System.out.println(dpMemo(coins, amount));
        System.out.println(coinChange(coins, amount));
    }

    /**
     * 利用字典记录已经计算过的数据，优化时间复杂度
     * 优化后可达到O(3n)
     * @param coins
     * @param amount
     * @return
     */
    public static int dpMemo(int[] coins, int amount){
        // 添加一个Map,便于查询
        Map<Integer, Integer> memo = new HashMap<>();
        return dp1(coins, amount, memo);
    }

    /**
     * 时间复杂度：O(3n)
     * @param coins
     * @param amount
     * @param memo
     * @return
     */
    public static int dp1(int[] coins, int amount, Map<Integer, Integer> memo){
        if (memo.get(amount) != null){
            //如果之前计算过，直接查就好啦
            return memo.get(amount);
        }

        if(amount == 0){
            //如果没有剩余的金额，返回
            return 0;
        }
        if(amount < 0){
            //如果金额为负数，表示没有找到
            return -1;
        }

        int res = Integer.MAX_VALUE;
        int t;
        for (int i = 0; i < coins.length; i++) {
            t = dp1(coins, amount - coins[i], memo);
            if(t == -1){
                continue;
            }
            res = Integer.min(res, t+1);
        }
        if(res != Integer.MAX_VALUE){
            memo.put(amount, res);
        }
        else{
            memo.put(amount, -1);
        }
        return memo.get(amount);
    }


    /**
     * 暴力破解
     * 时间复杂度：O(kn^k)
     * @param coins
     * @param amount
     * @return
     */
    public static int dpNormal(int[] coins, int amount){
        // 基状态
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        // 定义最小值
        int res = Integer.MAX_VALUE;

        int t;
        for (int i = 0; i < coins.length; i++) {
            t = dpNormal(coins, amount-coins[i]);
            if(t == -1){
                continue;
            }
            res = Integer.min(res, 1+t);
        }

        if(res == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return res;
        }
    }

    /**
     * 自底向上求解
     * 假设当目标金额为i时，需要的最小硬币个数为dp[i]
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount){
        int[] dp = new int[amount+1];

        //初始化数组, 相当于将每种金额的可能硬币个数设置为MAX
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }

        //基状态
        dp[0] = 0;

        //一次遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins){
                if(i - coin < 0){
                    continue;
                }
                dp[i] = Integer.min(dp[i], 1 + dp[i - coin]);
            }
        }

        if(dp[amount] == amount + 1){
            //没有找到
            return -1;
        }
        else{
            return dp[amount];
        }
    }
}

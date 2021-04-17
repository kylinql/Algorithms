package simple01;

/**
 * 拿硬币：
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 */
public class Coin {
    public static void main(String[] args) {
        int[] array = {2, 3, 10};
        System.out.println(minCount(array));
    }

    public static int minCount(int[] coins) {
        int sum = 0;
        for (int i = 0; i < coins.length; i++) {
            sum += (coins[i] + 1) / 2;
        }
        return sum;
    }


}

package simple01;

import java.util.Scanner;

/**
 * 斐波那契数列
 */
public class Fib {
    public static void main(String[] args) {
        //1. 输入数据
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

//        System.out.println(fibNormal(n));
//        System.out.println(fib(n));
        System.out.println(fib3(n));
    }

    /**
     * 斐波那契的优化解法
     * 每次计算出结果后，将其存储起来后，再返回。
     * 存储是为了计算的方便，如果已经计算过了，那就不用计算了。
     * 时间复杂度为O(n)
     *
     * @param n
     * @return
     */
    public static int fib(int n){
        if (n == 0){
            return 0;
        }

        int[] fibNum = new int[n+1];
        fibNum[0] = 0;

        return calculateFib(n, fibNum);
    }

    public static int calculateFib(int n, int[] fibNum){
        if(n == 1 || n == 2){
            return 1;
        }

        if(fibNum[n] != 0){
            return fibNum[n];
        }

        fibNum[n] = calculateFib(n-1, fibNum) + calculateFib(n-2, fibNum);

        return fibNum[n];
    }

    /**
     * 一般解法：
     * 使用普通递归，但是这样会存在重复计算的问题。
     * 例如fib(8)与fib(7),
     * 求fib(8)的时候需要重新计算fib(6)和fib(7),
     * 然而在计算fib(7)的时候，已经得出了fib(6)的结论。
     * 这样的方法，时间复杂度为：O(2^n)
     * @param n
     * @return
     */
    public static int fibNormal(int n){
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        return fibNormal(n-1) + fibNormal(n-2);
    }

    /**
     * 利用状态转移方程求解
     * @param n
     * @return
     */
    public static int fib2(int n){
        if(n == 0){
            return 0;
        }

        if(n == 1 || n == 2){
            return 1;
        }

        int[] fibNum = new int[n+1];
        fibNum[0] = 0;
        fibNum[1] = 1;
        fibNum[2] = 1;

        for (int i = 3; i <= n; i++) {
            fibNum[i] = fibNum[i-1] + fibNum[i-2];
        }
        return fibNum[n];
    }

    /**
     * 斐波那契空间优化
     * 只与前两个有关
     * @param n
     * @return
     */
    public static int fib3(int n){
        if(n == 0){
            return 0;
        }

        if(n == 1 || n == 2){
            return 1;
        }

        int pre = 1;
        int cur = 1;

        for (int i = 3; i <= n; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }
}

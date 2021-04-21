package dp03;

import java.util.Scanner;

/**
 * 字符串解码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * 要解码已编码的消息，所有数字必须基于上述映射的方法，
 * 反向映射回字母（可能有多种方法）。
 *
 */
public class DecodeStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = numDecodings(str);
        System.out.println("解码的方式有：" + n + "种");
    }

    /**
     * 基于动态规划的求解策略
     * 对于字符串中第i个字符，
     * 1. 第一种情况是使用了一个字符，只要它不为0，就可以被编码为A～I的某个字符
     * 2. 第二种情况是使用了两个字符，也就是利用[i-1]和[i]一起进行编码，此时两个字符组成的整数必须小于等于26
     * 而且[i-1]不为0，将其解码成J~Z。
     * 此外，i大于1才能进行转换，否在不存在
     *
     * 最后，将两种对应条件下的表示个数相加，得到总的表示个数。
     *
     * 边界条件：空字符串返回1；
     * @param s
     * @return
     */
    public static int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n+1];
        f[0] = 1;
        s = " " + s;

        char[] sArray = s.toCharArray();
        for (int i = 1; i <= n; i++) {

            int a = sArray[i] - '0';
            int b = (sArray[i-1] - '0') * 10 + (sArray[i] - '0');

            //第一种情况，使用一个字符，而且它不为0
            if(1 <= a && a <= 9){
                f[i] = f[i-1];
            }

            //第二种情况，使用两个字符
            if(10 <= b && b <= 26){
                f[i] += f[i-2];
            }
        }

        return f[n];
    }

    /**
     * 状态方程简化版
     * @param s
     * @return
     */
    public static int numDecodings2(String s) {
        int n = s.length();
        int a = 0, b = 1, c = 0;

        for (int i = 1; i <= n; i++) {
            c = 0;
            if(s.charAt(i-1) != 0){
                c += b;
            }
            if(i > 1 && s.charAt(i-2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)){
                c += a;
            }

            a = b;
            b = c;

        }

        return c;
    }
}

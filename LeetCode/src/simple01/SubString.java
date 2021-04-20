package simple01;

import java.util.Scanner;

/**
 * 找寻子字符串String.indexOf(String substring)
 *
 * 给你两个字符串 haystack 和 needle ，
 * 请在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回  -1 。
 *
 */
public class SubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String haystack = sc.nextLine();
        String needle = sc.nextLine();
//        int index = normalMethod(haystack, needle);
        int index = strStr(haystack, needle);
        System.out.println("The index is : " + index);

    }

    /**
     * 标准做法，使用String库提供的indexOf()方法即可
     * @param haystack
     * @param needle
     * @return
     */
    public static int normalMethod(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 自己实现indexOf()方法
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int index = 0;
        int len1, len2;
        String sub;
        len1 = haystack.length();
        len2 = needle.length();

        for (int i = 0; i <= len1 - len2 ; i++) {
            sub = haystack.substring(i, i+len2);
            System.out.println(sub);

            if(sub.equals(needle)){
                return i;
            }
        }
        return -1;
    }


}
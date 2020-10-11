package test3;

import java.util.Scanner;

/**
 * 回环变位：如果字符串s中的字符循环移动任意位置之后能得到另一个字符串t，s就被称为t的回环变位
 * 编写程序，检验两个字符串s和t是否互为回环变位
 * @author Kylin
 *
 */
public class Circular {

	public static boolean isCircular(String str1, String str2){
		String s = str1 + str1;
		if(s.indexOf(str2) > -1){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		System.out.println(Circular.isCircular(str1, str2));
	}

}

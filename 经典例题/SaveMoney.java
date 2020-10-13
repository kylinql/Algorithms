package test4;

import java.util.Scanner;

/**
 * 丑林的攒钱之路——零存整取
 * 若丑林每个月消费1000， 而且他还想在第48个月的时候连本带息要取1000元，那么最初他需要存入多少钱？
 * 关键：逆推
 * @author Kylin
 *
 */
public class SaveMoney {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 假设银行的年利率为1.71%
		double ratio = 0.0171;
		double[] moneylist = new double[49];
		
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		
		moneylist[48] = (double) money;
		
		for(int i = 47; i >= 0; i--){
			moneylist[i] = (moneylist[i+1]+money)/(1 + ratio/12);
		}
		
		for (int i = 0; i < moneylist.length; i++) {
			System.out.println("第" + i + "个月的钱为" + moneylist[i]);
		}
		
	}

}

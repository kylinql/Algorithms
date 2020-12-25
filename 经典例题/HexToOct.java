import java.util.Scanner;


public class Main {

    /**
     * 将十六进制转化为二进制
     * @param hex
     */
    public static String transformToBinary(String hex){
        String[] nums = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
                "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
        char ch;
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < hex.length(); i++) {
            ch = hex.charAt(i);

            if ('0' <= ch && '9' >= ch){
                binary.append(nums[ch-'0']);
            }
            else{
                binary.append(nums[ch - 'A' + 10]);
            }
        }
        return binary.toString();
    }

    /**
     * 去除或添加前置0
     * @param str
     * @return
     */
    public static String stripSpace(String str){
        int length = str.length();
        int k = 0;
        String subStr;

//        如果当前是3的倍数，暂不处理
        if(length % 3 == 0){
            return str;
        }

        subStr = stripZero(str);

        if(subStr.length() % 3 == 0){
            return subStr;
        }

//        前方补0
        int p = 3 - subStr.length() % 3;
//        在前面加p个0
        StringBuilder zero = new StringBuilder();
        for (int i = 0; i < p; i++) {
            zero.append('0');
        }
        zero.append(subStr);
        return zero.toString();
    }

    /**
     * 去除前置0
     * @param str
     * @return
     */
    public static String stripZero(String str){
        int length = str.length();
        int k = 0;
        for (int i = 0; i < length; i++) {
            if(str.charAt(i) == '0'){
                k++;
            }
            else{
                break;
            }
        }
        return str.substring(k,length);
    }

    /**
     * 将二进制转化为八进制
     * @param binary
     */
    public static String transformToOct(String binary){
        binary = stripSpace(binary);
//        System.out.println("去除前置0：" + binary);
        int length = binary.length();
        StringBuilder oct = new StringBuilder();
        int num;
        int k = 0;
        String sub;
        int i = 0;
        while (i < length){
            if(k < length / 3)
            {
                sub = binary.substring(i,i+3);
            }
            else{
                sub = binary.substring(i,length);
            }
//            System.out.println("sub = " + sub);

            num = (sub.charAt(0) - '0')* 4 + (sub.charAt(1) - '0') * 2 + (sub.charAt(2) - '0');
            oct.append(num);

            i += 3;
            k += 1;
        }

        return stripZero(oct.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] hexList = new String[n];
        String octStr;
        String binStr;


//        1. 读取每行的十六进制数据
        for (int i = 0; i < n; i++) {
            hexList[i] = sc.next();
        }

//        2. 逐行将十六进制转化为二进制
        for (int i = 0; i < n; i++) {
            binStr = transformToBinary(hexList[i]);

//            System.out.println("二进制表示：" + binStr);
            octStr = transformToOct(binStr);
            System.out.println(octStr);
        }
    }
}

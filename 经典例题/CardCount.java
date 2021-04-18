package simple01;

public class CardCount {
    public static void main(String[] args) {
        int t = 0;
        for (int i = 1; i <= 3200; i++) {
            String s = String.valueOf(i);
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if(chars[j] == '1'){
                    t++;
                }
            }
        }
        System.out.println(t);
    }
}

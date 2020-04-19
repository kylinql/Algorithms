
import java.util.Arrays;
import java.util.function.Function;

/**
 * 多元四阶龙格库塔的计算
 */

public class RungeKutta{

    /**
     * 计算多元龙格库塔
     * @param func 函数计算。使用函数式接口
     * @param iniValues 初始值数组
     * @param xn 计算终止条件
     * @param step 步长
     * @return y 计算结果
     */
    public static double[] Solve(Function<double[], double[]> func, double[] iniValues, double xn, double step){
        assert(iniValues.length > 0);

        int length = iniValues.length;
        double[] yn = new double[length];
        double x = iniValues[0];
        double[] y = iniValues.clone();

        while (x < xn){
            double[] k1 = func.apply(y);

            double[] k2ParaValues = new double[length];
            k2ParaValues[0] = x + step / 2;
            for (int i=1; i<length; i++){
                k2ParaValues[i] = y[i] + k1[i] * step / 2;
            }
            double[] k2 = func.apply(k2ParaValues);

            double[] k3ParaValues = new double[length];
            k3ParaValues[0] = x + step / 2;
            for (int i=1; i<length; i++){
                k3ParaValues[i] = y[i] + k2[i] * step / 2;
            }
            double[] k3 = func.apply(k3ParaValues);

            double[] k4ParaValues = new double[length];
            k4ParaValues[0] = x + step;
            for (int i=1; i<length; i++){
                k4ParaValues[i] = y[i] + k3[i] * step;
            }
            double[] k4 = func.apply(k4ParaValues);

            yn[0] = x;
            for (int i=1; i<length; i++){
                yn[i] = y[i] + step * (k1[i] + 2 * k2[i] + 2 * k3[i] + k4[i]) / 6;
            }

            x += step;
            y = yn.clone();
            y[0] = x;

            System.out.println(Arrays.toString(y));
        }

        return y;
    }
}
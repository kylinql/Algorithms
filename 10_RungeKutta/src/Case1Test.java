import java.util.Arrays;

public class Case1Test {
    /**
     * 算例1：捕食者被捕食者模型
     * dx/dt = 2x - 0.02xy
     * dy/dt = 0.0002xy - 0.8y
     * 初值：x = 3000, y = 120
     */

    public static double[] f1(double[] par){
        double y1 = 2 * par[1] - 0.02 * par[1] * par[2];
        double y2 = 0.0002 * par[1] * par[2] - 0.8 * par[2];
        return new double[]{par[0], y1, y2};
    }

    public static void main(String[] args) {
        double[] iniValues = new double[]{0, 3000, 120};

        double[] results = RungeKutta.Solve((double[] val) -> f1(val), iniValues, 20.0, 0.1);
        System.out.println(Arrays.toString(results));

    }
}

import java.util.Arrays;

public class Case2Test {
    /**
     * 算例2：Lorenz模型
     * dx/dt = -10x + 10y
     * dy/dt = 28x - y - xz
     * dz/dt = -8/3 z + xy
     * dy/dt = 0.0002xy - 0.8y
     * 初值：x = 5, y = 5, z = 5
     * step = 0.01
     */

    public static double[] f1(double[] par){
        double x = -10 * par[1] + 10 * par[2];
        double y = 28 * par[1] - par[2] - par[1] * par[3];
        double z = - 8 / 3 * par[3] + par[1] * par[2];
        return new double[]{par[0], x, y, z};
    }


    public static void main(String[] args) {
        double[] iniValues = new double[]{0, 5, 5, 5};

        double[] results = RungeKutta.Solve((double[] val) -> f1(val), iniValues, 50, 0.01);
        System.out.println(Arrays.toString(results));

    }
}

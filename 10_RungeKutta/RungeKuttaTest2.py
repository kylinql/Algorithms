# -- coding = 'utf-8' -- 
# Author Kylin
# Python Version 3.7.3
# OS macOS
import numpy as np
import matplotlib.pyplot as plt
from RungeKutta.RungeKutta import RungeKutta
from matplotlib.ticker import MultipleLocator


class MultiFunc2(object):

    def getFunction(self, parameters):
        """
        * 算例2：Lorenz模型
        * dx/dt = -10x + 10y
        * dy/dt = 28x - y - xz
        * dz/dt = -8/3 z + xy
        * 初值：x = 5, y = 5, z = 5
         * step = 0.01
        :param parameters: 初始值
        :return: num数组
        """
        num = np.zeros_like(parameters)
        num[0] = parameters[0]
        num[1] = -10 * parameters[1] + 10 * parameters[2]
        num[2] = 28 * parameters[1] - parameters[2] - parameters[1] * parameters[3]
        num[3] = -8/3 * parameters[3] + parameters[1] * parameters[2]

        return num

    def plotNum(self, values):
         valueArray = np.array(values)
         x = valueArray[:, 1]
         y = valueArray[:, 3]

         xmajorlocator = MultipleLocator(10)  # 将1轴主刻度标签设置为10的倍数
         ymajorlocator = MultipleLocator(5)  # 将2轴主刻度标签设置为5的倍数

         fig = plt.figure()

         plt.plot(x, y, color="red", alpha=0.9)
         plt.xlim(-20, 20)
         ax = plt.gca()
         ax.xaxis.set_major_locator(xmajorlocator)
         ax.yaxis.set_major_locator(ymajorlocator)
         plt.xlabel("X")
         plt.ylabel("Z")
         plt.title("X-Z")
         plt.show()


if __name__ == "__main__":
    inivalues = np.array([0.0, 5.0, 5.0, 5.0])
    runge = RungeKutta()
    multiFunc = MultiFunc2()
    y, values = runge.calculate(multiFunc, inivalues, 25, 0.01)
    multiFunc.plotNum(values)

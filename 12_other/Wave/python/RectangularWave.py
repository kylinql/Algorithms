# -- coding = 'utf-8' -- 
# Author Kylin
# Python Version 3.7.3
# OS macOS

"""
矩形波模拟
"""
import numpy as np
import matplotlib.pyplot as plt

class RectangularWave(object):
    def __init__(self, power, duty, start, end):
        self.power = power
        self.duty = duty
        self.start = start
        self.end = end
        self.currentTime = start

    # 计算
    def calculateWave(self):
        time = self.currentTime % 60
        if (time == 0) and (self.duty == 60):
            return self.power
        elif (time <= self.duty) and (time != 0):
            return self.power
        else:
            return 0

    def simulation(self):
        T = np.arange(self.start, self.end+1)
        P = []
        for i in range(self.start, self.end+1):
            p = self.calculateWave()
            self.currentTime += 1
            P.append(p)
        return T, P

    def plot(self, T, P):
        fig = plt.figure("Rectangular Wave")
        plt.rc('font', family='Times New Roman')
        plt.rcParams["xtick.direction"] = "in"
        plt.rcParams["ytick.direction"] = "in"
        T = T/60
        plt.plot(T, P)
        plt.xlabel("T (min)")
        plt.ylabel("Power (W)")
        plt.title("Rectangular Wave")
        plt.grid()
        plt.show()


if __name__ == "__main__":
    #1. 设置时间
    start = 0
    end = 400

    #2. 计算当占空比为30s时的脉冲矩形波
    power1 = 20
    duty1 = 30
    rectangular1 = RectangularWave(power1, duty1, start, end)
    T1, P1 = rectangular1.simulation()

    #3. 计算当占空比为60s时的脉冲矩形波
    power2 = 20
    duty2 = 60
    rectangular2 = RectangularWave(power2, duty2, start, end)
    T2, P2 = rectangular2.simulation()

    fig = plt.figure("Rectangular Waves")
    plt.rc('font', family='Times New Roman')
    plt.rcParams["xtick.direction"] = "in"
    plt.rcParams["ytick.direction"] = "in"
    T = T1 / 60
    plt.plot(T, P1, color="green", label="power = 20W, duty = 30")
    plt.plot(T, P2, linestyle="--", color="blue", label="power = 20W, duty = 60")
    plt.xlabel("T (min)")
    plt.ylabel("Power (W)")
    plt.title("Rectangular Wave")
    plt.legend()
    plt.grid()
    plt.show()




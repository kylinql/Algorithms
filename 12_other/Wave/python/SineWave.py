# -- coding = 'utf-8' -- 
# Author Kylin
# Python Version 3.7.3
# OS macOS

import math
import numpy as np
import matplotlib.pyplot as plt

"""
正弦波模拟
"""
class SineWave(object):
    def __init__(self, A, fai, k, start, end):
        self.A = A
        self.w = math.pi / 30 #wT = 2pai, 所以w为pai/30
        self.fai = fai
        self.k = k
        self.start = start
        self.end = end
        self.currentTime = start

    def calculateWave(self):
        p = self.A * math.sin(self.w * self.currentTime + self.fai) + self.k
        return p

    def simulation(self):
        T = np.arange(self.start, self.end+1)
        P = []
        for i in range(self.start, self.end+1):
            p = self.calculateWave()
            self.currentTime += 1
            P.append(p)
        return T, P

    def plot(self, T, P):
        fig = plt.figure("Sine Wave")
        plt.rc('font', family='Times New Roman')
        plt.rcParams["xtick.direction"] = "in"
        plt.rcParams["ytick.direction"] = "in"
        plt.plot(T, P)
        plt.xlabel("T (s)")
        plt.ylabel("Power (W)")
        plt.title("Sine Wave")
        plt.grid()
        plt.show()

if __name__ == "__main__":
    #1. 设置时间
    start = 0
    end = 120

    #2. 正弦波仿真，经典sin函数
    A1 = 1
    fai1 = 0
    k1 = 0
    sine1 = SineWave(A1, fai1, k1, start, end)
    T1, P1 = sine1.simulation()
    print(P1)
    sine1.plot(T1, P1)

    #3. 正弦波仿真，1/2sin(x)
    A2 = 1/2
    fai2 = 0
    k2 = 0
    sine2 = SineWave(A2, fai2, k2, start, end)
    T2, P2 = sine2.simulation()
    sine1.plot(T2, P2)

    #4. 正弦波仿真，sin(x+90)
    A3 = 1
    fai3 = 90
    k3 = 0
    sine3 = SineWave(A3, fai3, k3, start, end)
    T3, P3 = sine3.simulation()
    sine3.plot(T3, P3)

    fig = plt.figure("Sine Wave")
    plt.rc('font', family='Times New Roman')
    plt.rcParams["xtick.direction"] = "in"
    plt.rcParams["ytick.direction"] = "in"
    plt.plot(T1, P1, linestyle="-", color="blue", label="y = sinx")
    plt.plot(T1, P2, linestyle="--", color="green", label = r'y = $\frac{1}{2}$sinx')
    plt.plot(T1, P3, linestyle="-.", color="red", label = "y = sin(x+90)")
    plt.xlabel("T (s)")
    plt.ylabel("Power (W)")
    plt.title("Sine Wave")
    plt.legend()
    plt.grid()
    plt.show()




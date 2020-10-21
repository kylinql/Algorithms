# -- coding = 'utf-8' -- 
# Author Kylin
# Python Version 3.7.3
# OS macOS

import math
import numpy as np
import matplotlib.pyplot as plt

"""
余弦波模拟
"""
class CosineWave(object):
    def __init__(self, A, fai, k, start, end):
        self.A = A
        self.w = math.pi / 30 #wT = 2pai, 所以w为pai/30
        self.fai = fai
        self.k = k
        self.start = start
        self.end = end
        self.currentTime = start

    def calculateWave(self):
        p = self.A * math.cos(self.w * self.currentTime + self.fai) + self.k
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
        fig = plt.figure("Cosine Wave")
        plt.rc('font', family='Times New Roman')
        plt.rcParams["xtick.direction"] = "in"
        plt.rcParams["ytick.direction"] = "in"
        plt.plot(T, P)
        plt.xlabel("T (s)")
        plt.ylabel("Power (W)")
        plt.title("Cosine Wave")
        plt.grid()
        plt.show()

if __name__ == "__main__":
    #1. 设置时间
    start = 0
    end = 120

    #2. 余弦波仿真，经典cos函数
    A1 = 1
    fai1 = 0
    k1 = 0
    cos1 = CosineWave(A1, fai1, k1, start, end)
    T1, P1 = cos1.simulation()
    cos1.plot(T1, P1)

    #3. 余弦波仿真，1/2cos(x)
    A2 = 1/2
    fai2 = 0
    k2 = 0
    cos2 = CosineWave(A2, fai2, k2, start, end)
    T2, P2 = cos2.simulation()
    cos2.plot(T2, P2)

    #4. 余弦波仿真，cos(x+90)
    A3 = 1
    fai3 = 90
    k3 = 0
    cos3 = CosineWave(A3, fai3, k3, start, end)
    T3, P3 = cos3.simulation()
    cos3.plot(T3, P3)

    fig = plt.figure("Cosine Wave")
    plt.rc('font', family='Times New Roman')
    plt.rcParams["xtick.direction"] = "in"
    plt.rcParams["ytick.direction"] = "in"
    plt.plot(T1, P1, linestyle="-", color="blue", label="y = cosx")
    plt.plot(T1, P2, linestyle="--", color="green", label = r'y = $\frac{1}{2}$cosx')
    plt.plot(T1, P3, linestyle="-.", color="red", label = "y = cos(x+90)")
    plt.xlabel("T (s)")
    plt.ylabel("Power (W)")
    plt.title("Cosine Wave")
    plt.legend()
    plt.grid()
    plt.show()


# -- coding = 'utf-8' -- 
# Author Kylin
# Python Version 3.7.3
# OS macOS

import math
import numpy as np
import matplotlib.pyplot as plt

"""
锯齿波模拟
"""


class SawtoothWave(object):
    def __init__(self, A, T, start, end):
        self.A = A
        self.T = T
        self.k = 2 * A / T
        self.start = start
        self.end = end
        self.currentTime = start

    def calculateWave(self):
        time = self.currentTime % self.T
        p = self.k * (time - self.T/2)
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
        fig = plt.figure("Sawtooth Wave")
        plt.rc('font', family='Times New Roman')
        plt.rcParams["xtick.direction"] = "in"
        plt.rcParams["ytick.direction"] = "in"
        plt.plot(T, P)
        plt.xlabel("T (s)")
        plt.ylabel("Power (W)")
        plt.hlines(0, T[0], T[-1], linestyles="--", color="orange")
        plt.title("Sawtooth Wave")
        plt.grid()
        plt.show()

if __name__ == "__main__":
    #1. 设置时间
    start = 0
    end = 120

    #2. 锯齿波仿真1
    A1 = 5
    T1 = 60
    tooth1 = SawtoothWave(A1, T1, start, end)
    T1, P1 = tooth1.simulation()
    print(P1)
    tooth1.plot(T1, P1)

    #3. 锯齿波仿真2
    A2 = 5
    T2 = 30
    tooth2 = SawtoothWave(A2, T2, start, end)
    T2, P2 = tooth2.simulation()
    print(P2)
    tooth2.plot(T2, P2)

    # 4. 锯齿波仿真3
    A3 = 5
    T3 = 40
    tooth3 = SawtoothWave(A3, T3, start, end)
    T3, P3 = tooth3.simulation()
    print(P3)
    tooth3.plot(T3, P3)

    fig = plt.figure("Sawtooth Wave")
    plt.rc('font', family='Times New Roman')
    plt.rcParams["xtick.direction"] = "in"
    plt.rcParams["ytick.direction"] = "in"
    plt.plot(T1, P1, linestyle="-", color="blue", label="A = 5, T = 60")
    plt.plot(T1, P2, linestyle="-.", color="green", label="A = 5, T = 30")
    plt.hlines(0, T1[0], T1[-1], linestyles="--", color="orange")
    plt.ylim(-6, 6)
    plt.xlabel("T (s)")
    plt.ylabel("Power (W)")
    plt.title("Sawtooth Wave")
    plt.legend()
    plt.grid()
    plt.show()





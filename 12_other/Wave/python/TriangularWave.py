# -- coding = 'utf-8' -- 
# Author Kylin
# Python Version 3.7.3
# OS macOS
"""
三角波仿真
"""
import math
import numpy as np
import matplotlib.pyplot as plt


class TriangularWave(object):
    def __init__(self, A, T, start, end):
        self.A = A
        self.k = A/(T//4)
        self.T = T
        self.start = start
        self.end = end
        self.currentTime = start

    def calculateWave(self):
        time = self.currentTime % self.T
        if time <= self.T // 4:
            return self.k*time
        elif time <= (3 * self.T // 4):
            return -self.k * time + self.k * (self.T // 2)
        else:
            return self.k * time - self.k * self.T

    def simulation(self):
        T = np.arange(self.start, self.end + 1)
        P = []
        for i in range(self.start, self.end + 1):
            p = self.calculateWave()
            self.currentTime += 1
            P.append(p)
        return T, P

    def plot(self, T, P):
        fig = plt.figure("Triangular Wave")
        plt.rc('font', family='Times New Roman')
        plt.rcParams["xtick.direction"] = "in"
        plt.rcParams["ytick.direction"] = "in"
        plt.plot(T, P)
        plt.xlabel("T (s)")
        plt.ylabel("Power (W)")
        plt.title("Triangular Wave")
        plt.grid()
        plt.show()

if __name__ == "__main__":
    # 1. 设置时间
    start = 0
    end = 120

    # 2. 正弦波仿真1
    A1 = 5
    T1 = 60
    triwave1 = TriangularWave(A1, T1, start, end)
    T1, P1 = triwave1.simulation()
    print(P1)
    triwave1.plot(T1, P1)

    # 3. 正弦波仿真2
    A2 = 10
    T2 = 120
    triwave2 = TriangularWave(A2, T2, start, end)
    T2, P2 = triwave2.simulation()
    print(P2)
    triwave2.plot(T2, P2)

    # 4. 正弦波仿真2
    A3 = 10
    T3 = 20
    triwave3 = TriangularWave(A3, T3, start, end)
    T3, P3 = triwave3.simulation()
    print(P3)
    triwave3.plot(T3, P3)

    fig = plt.figure("Triangular Wave")
    plt.rc('font', family='Times New Roman')
    plt.rcParams["xtick.direction"] = "in"
    plt.rcParams["ytick.direction"] = "in"
    plt.plot(T1, P1, linestyle="-", color="blue", label="A = 5, T = 60")
    plt.plot(T1, P2, linestyle="--", color="green", label="A = 10, T = 120")
    plt.plot(T1, P3, linestyle="-.", color="red", label="A = 10, T = 20")
    plt.xlabel("T (s)")
    plt.ylabel("Power (W)")
    plt.title("Triangular Wave")
    plt.legend()
    plt.grid()
    plt.show()


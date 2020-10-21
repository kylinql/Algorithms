# -- coding = 'utf-8' -- 
# Author Kylin
# Python Version 3.7.3
# OS macOS
"""
傅立叶变换生成波形
"""
import numpy as np
import math
import matplotlib.pyplot as plt

class Fourier(object):
    def __init__(self, a0, T, start, end):
        self.alist = []
        self.blist = []
        self.alist.append(a0)
        self.T = T
        self.start = start
        self.end = end
        self.Y = []
        self.n = 0
        self.label = ""

    #添加函数
    def addFunction(self, a, b):
        self.alist.append(a)
        self.blist.append(b)
        self.n += 1
        for i in range(self.start, self.end + 1):
            self.Y[i - self.start] += (a * math.cos(2 * math.pi * self.n * i / self.T) + b * math.sin(2 * math.pi * self.n * i / self.T))
        self.label += " + " + str(a) + "cos(2πnx/T) + " + str(b) + "sin(2πnx/T)"

    def initial(self):
        for i in range(self.start, self.end+1):
            y = self.alist[0] / 2
            self.Y.append(y)
        self.label += str(self.alist[0] / 2) + ""

    def plot(self):
        T = np.arange(self.start, self.end+1)
        fig = plt.figure("Wave")
        plt.rc('font', family='Times New Roman')
        plt.rcParams["xtick.direction"] = "in"
        plt.rcParams["ytick.direction"] = "in"
        plt.plot(T, self.Y)
        plt.xlabel("T (s)")
        plt.ylabel("Power (W)")
        plt.title(self.label)
        plt.grid()
        plt.show()

if __name__ == "__main__":
    a0 = 2
    T = 60
    start = 0
    end = 100
    fourier = Fourier(a0, T, start, end)
    fourier.initial()
    y1 = fourier.Y.copy()
    fourier.addFunction(2, 3)
    y2 = fourier.Y.copy()
    fourier.addFunction(3, 2)
    y3 = fourier.Y.copy()
    fourier.addFunction(-1, 1)
    y4 = fourier.Y.copy()

    T = np.arange(start, end + 1)
    alist = fourier.alist
    blist = fourier.blist
    lables = []
    lables.append("y = " + str(alist[0]) + "/2")

    for i in range(len(fourier.blist)):
        label = "y += " + str(alist[i+1]) + "cos(2πnx/T) + " + str(blist[i]) + "sin(2πnx/T)"
        lables.append(label)

    fig = plt.figure("Wave")
    plt.rc('font', family='Times New Roman')
    plt.rcParams["xtick.direction"] = "in"
    plt.rcParams["ytick.direction"] = "in"
    plt.plot(T, y1, linestyle="--", label=lables[0])
    plt.plot(T, y2, linestyle="-.", label=lables[1])
    plt.plot(T, y3, linestyle="-", label=lables[2])
    plt.plot(T, y4, linestyle=":", label=lables[3])
    plt.xlabel("T (s)")
    plt.ylabel("Power (W)")
    plt.title("Fourier Wave")
    plt.legend()
    plt.grid()
    plt.show()


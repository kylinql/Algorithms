"""
递归模拟2
"""

def fact(x):
    #计算阶乘
    if x == 1:
        #基线条件
        return 1
    else:    
        return x * fact(x-1) #递归条件

if __name__ == "__main__":    
    n = int(input("请输入想要计算的阶乘数n:"))
    print(fact(n))

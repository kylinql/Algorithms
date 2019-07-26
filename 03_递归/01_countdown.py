"""
递归练习1
输出：从n到0
"""

def countdown(i):
    print(i)
    if i <= 0:
        # base case基线条件
        return
    else:
        countdown(i-1)#递归条件

if __name__ == "__main__":    
    countdown(5)

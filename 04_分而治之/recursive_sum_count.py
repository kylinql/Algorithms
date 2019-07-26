"""
利用递归的思想，
编写函数，求一个数组的和，顺便求数组中的元素个数
"""

def sumArray(arr):
    #递归求和函数
    if arr == []:
        return 0
    else:
        return arr[0] + sumArray(arr[1:])

def countNum(arr):
    #递归计数函数
    if arr == []:
        return 0
    else:
        return 1 + countNum(arr[1:])

if __name__ == "__main__":
    #1. 输入数组列表
    array = input("请输入数组(以逗号分开)：").split(",")
    array = [int(i) for i in array]
    #2. 求和
    result = sumArray(array)
    print("sum =", result)
    #3. 计算列表元素个数
    count = countNum(array)
    print("count =", count)
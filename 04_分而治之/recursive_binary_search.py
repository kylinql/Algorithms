# -*- coding: utf-8 -*-
"""
Created on Sat Jul 27 16:44:44 2019
二分查找的递归实现
@author: Kylin
"""

def search(array, key):
    #基准条件，当数组的长度为1
    if len(array) == 1:
        if array[0] == key:
            return True
        else:
            return False
    #递归条件
    else:    
        middle = len(array) // 2
        print("当前数组：", array)
        print("middle =", middle)

        if array[middle] > key:
            #如果中间值大于key，则找前面的
            return search(array[:middle], key)
        else:
            #否则找后面的
            return search(array[middle:], key)


if __name__ == "__main__":
    #1. 输入数组列表
    array = input("请输入数组(以逗号分开)：").split(",")
    array = [int(i) for i in array]
    
    #2. 输入要查找的元素
    key = int(input("请输入要查找的元素："))

    #3. 数组排序
    array.sort()
    
    if search(array, key) == True:
        print("该数组中存在该元素")
    else:
        print("查找失败，数组中不存在该元素")
    


# -*- coding: utf-8 -*-
"""
Created on Sun Jul 28 22:19:13 2019
快速排序的简单实现及多种排序算法的耗时比较
@author: Kylin
"""

import numpy as np
from time import time

def createdata(n):
    """
    创建所需的数据
    参数：n数据元素个数
    返回值：创建好的数据列表
    """
    array = np.random.randint(0,100000,n)
    arraylist = array.tolist()
    return arraylist

def quicksort(array):
    """
    快速排序的算法
    """
    arraylist = array.copy()
    if len(arraylist) < 2:
        #基准条件，为空或者只包含一个元素时，返回该数组
        return arraylist
    else:
        pivot = arraylist[0]
        less = [i for i in arraylist[1:] if i <= pivot]
        greater = [i for i in arraylist[1:] if i > pivot]
        return quicksort(less) + [pivot] + quicksort(greater)

def findSmallest(arr):
    """
    找到数组中值最小的元素
    参数：数组列表arr
    返回值：值最小元素的索引
    """
    smallest = arr[0] #首先将第一个元素默认为值最小的元素
    smallest_index = 0 #记录最小元素所在索引
    
    for i in range(1, len(arr)):
        if arr[i] < smallest:
            smallest = arr[i]
            smallest_index = i
            
    return smallest_index

def selectionSort(arr):
    """
    选择排序
    参数：数组列表arr
    返回值：排序好的数组
    """
    newArr = []
    
    for i in range(len(arr)):
        #每次找到一个最小的值加入新数组列表
        smallest = findSmallest(arr)
        newArr.append(arr[smallest])
        del(arr[smallest])
    
    return newArr

def popsort(array):
    """
    冒泡排序方法
    """
    arraylist = array.copy()
    for i in range(len(arraylist)-1):
        for j in range(i+1, len(arraylist)):
            if arraylist[i] > arraylist[j]:
                t = arraylist[i]
                arraylist[i] = arraylist[j]
                arraylist[j] = t
    return arraylist

if __name__ == "__main__":
    #1. 输入数组列表
    n = int(input("需要创建的数据个数："))
    array = createdata(n)
   
    print("-"*5,"使用冒泡排序方法", "-"*5)
    #2. 冒泡排序
    t_start = time() 
    sort = popsort(array)
    t_end = time()
    #冒泡排序计时
    usetime = t_end - t_start
    print("冒泡排序耗时：",usetime)
    
    print("-"*5,"使用快速排序方法", "-"*5)
    #3. 快速排序
    t_start = time() 
    sort = quicksort(array)
    t_end = time()
    #print("快速排序后的数组:", sort)
    #快速排序计时
    usetime = t_end - t_start
    print("快速排序耗时{:.3f}s".format(usetime))
    
    print("-"*5,"使用选择排序方法", "-"*5)
    #4. 选择排序
    t_start = time() 
    sort = selectionSort(array)
    t_end = time()
    #选择排序计时
    usetime = t_end - t_start
    print("选择排序耗时：",usetime)
    
    
    
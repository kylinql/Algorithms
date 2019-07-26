"""
选择排序算法的实现
"""

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

if __name__ == "__main__":
     #1. 输入数组列表
    array = input("请输入数组(以逗号分开)：").split(",")
    array = [int(i) for i in array]
    sortArr = selectionSort(array)
    print("排序后的数组列表:", sortArr)


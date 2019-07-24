"""
二分查找算法的简单实现
"""

def binary_search(array, key):
    """
    二分查找函数
    参数：
        array: 数组列表
        key: 待查找的元素
    """
    low = 0
    high = len(array) - 1

    #如果没有找到目标元素，则返回空值
    while low <= high:
        mid = (low + high) // 2
        guess = array[mid]
        if guess == key:
            #如果找到了当前元素，就返回其下标
            return mid
        if guess > key:
            #如果中间元素大于目标元素，则将high重新设置
            high = mid - 1
        else:
            #否则重新设置low
            low = mid + 1

    return None

if __name__ == "__main__":
    #1. 输入数组列表
    array = input("请输入数组(以逗号分开)：").split(",")
    array = [int(i) for i in array]
    key = int(input("请输入待查找的元素："))
    #2. 数组排序，二分查找的前提是一个有序数组
    array.sort()
    print("排序后的数组：", array)
    #3. 利用二分查找，查看数组中是否有元素key
    index = binary_search(array, key)
    if index != None:
        print("待查找元素的下标是：", index)
    else:
        print("查找失败，数组中没有该元素")
    
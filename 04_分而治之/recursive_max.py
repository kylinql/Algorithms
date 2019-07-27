"""
利用递归的思想，找出列表中最大的值
"""

def maxitem(arr):
  if len(arr) == 2:
      #如果长度为2的话，返回那个较大的值
      if arr[0] > arr[1]:
          return arr[0]
      else:
          return arr[1]
      
  #求出子数组列表中的最大值    
  sub_max = maxitem(arr[1:])
  
  if arr[0] > sub_max:
      return arr[0]
  else:
      return sub_max
  
if __name__ == "__main__":
    #1. 输入数组列表
    array = input("请输入数组(以逗号分开)：").split(",")
    array = [int(i) for i in array]
    #2. 求出列表中的最大值
    maxnum = maxitem(array)
    print(maxnum)
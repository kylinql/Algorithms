# -*- coding: utf-8 -*-
"""
Created on Mon Aug  5 17:10:19 2019
最长公共子串
计算两个序列中共同拥有的子串的长度
@author: Kylin
"""
import numpy as np

def subsentence(str1, str2):
    len1 = len(str1)
    len2 = len(str2)
    array = np.zeros((len1,len2))
    for i in range(len1):
        for j in range(len2):
            if str1[i] == str2[i]:
                if i == 0 or j == 0:
                    array[i][j] = 1
                else:
                    array[i][j] = array[i-1][j-1] + 1
            else:
                array[i][j] = 0
    maxlen = int(np.max(array))
    return maxlen

if __name__ == "__main__":
    str1 = input("请输入字符串1：")
    str2 = input("请输入字符串2：")
    maxsublen = subsentence(str1, str2)
    print("两序列中最大公共子串的长度是:", maxsublen)

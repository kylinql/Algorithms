# -*- coding: utf-8 -*-
"""
Created on Mon Aug  5 17:44:56 2019
判断最长公共子序列
最长公共子序列：两个字符串中都有的序列包含的字母数
@author: Kylin
"""
import numpy as np

def subsequence(str1, str2):
    len1 = len(str1)
    len2 = len(str2)
    array = np.zeros((len1,len2))
    if str1[0] == str2[0]:
        array[0][0] = 1
    for i in range(len1):
        for j in range(len2):
            if str1[i] == str2[j]:
                if i == 0 or j == 0:
                    array[i][j] = 1
                else:
                    array[i][j] = array[i-1][j-1] + 1
            elif i == 0 and j != 0:
                array[0][j] = array[0][j-1]
            elif i != 0 and j == 0:
                array[i][0] = array[0][i-1]
            else:
                array[i][j] = max(array[i-1][j], array[i][j-1])
    return int(array[len1-1][len2-1])        
        
if __name__ == "__main__":
    str1 = input("请输入字符串1：")
    str2 = input("请输入字符串2：")
    maxsublen = subsequence(str1, str2)
    print("两序列中的最大公共子序列长度是:", maxsublen)



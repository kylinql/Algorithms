# -*- coding:utf-8 -*-
"""
Fibnacci 509

斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和
F(0) = 0，F(1) = 1
F(n) = F(n - 1) + F(n - 2)，其中 n > 1

:Author: Shangmengqi@tsingj.com
:Last Modified by: Shangmengqi@tsingj.com
"""

class Solution:
    def fib(self, n: int) -> int:
        a = 0
        b = 1
        i = 0

        while i <= n:
            ret = a % (1e9 + 7)
            a, b = b % (1e9 + 7), (a + b) % (1e9 + 7)
            i += 1

        return int(ret)

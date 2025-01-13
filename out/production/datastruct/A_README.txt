
SmallNumber.java 归并排序
InversionNumber.java 逆序数、分治+归并
note:
虽然时间复杂度没快排好，但是具有稳定性
*idea:
什么是分治——>将问题分解，处理，合并；
对于操作后会对后续数据处理产生影响的算法，可以对其进行反向处理（逆向思维）


# EuclideanAlgorithm.java 欧几里得算法（辗转相除法求最大公约数Gcd）


QuickSort.java  快速排序
Quicksort1.java 快速排序高效版
note:
不具有稳定性，但是时间复杂度低
*idea:
类似于二分法的分治；
对于一个原始问题或操作先进行抽象，抽象成为等价的其他问题，而不是直接进行模拟运算。


RadixSort.java 基数排序 + 桶排序
note:
不具有稳定性，时间复杂度也赶不上快排

PalindromeLinkedList.java 快慢指针
note:
应用范围广，链表常用算法
快慢指针(双指针)同时还应用到了归并排序中

ListNode.java 链表的类结构

Leetcode86.java 链表快排
note:
使用了虚拟头节点
将单向链表按某值划分成左边小、中间相等、右边大的形式

Leetcode160.java 交叉链表

LeetcodeLCR022.java 判断链表是否有环，以及环的入口节点位置
note:
快慢指针
当快慢指针相遇时表明链表中有环
当快慢指针相遇时，将快指针移至头节点，随后循环快指针和慢指针每次都只next一次，最后快慢指针相遇时的位置就是环的入口节点

CodeforcesRound990_A.java 贪心算法
idea:
在面对贪心时一定要想好sum的加和判断条件，只有状态转移方程写对了答案才不会错。


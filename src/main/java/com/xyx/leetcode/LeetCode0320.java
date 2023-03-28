package com.xyx.leetcode;

import com.xyx.leetcode.entity.ListNode;

public class LeetCode0320 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode nodeStar = new ListNode((l1.val+l2.val)%10);    //创建首节点
        ListNode nextNode =nodeStar;                     //声明一个变量用来在移动过程中指向当前节点
        nextNode=nodeStar;                      //指向首节点  （ ListNode nextNode = nodeStar 合起来提示内存超出限制，不知道为什么）
        int num = (l1.val+l2.val)/10;
        while(l1.next != null || l2.next != null || num != 0){
            int numA = (l1.next != null)? l1.val: 0;
            l1 = (l1.next != null)? l1.next: l1;

            int numB = (l2.next != null)? l2.val: 0;
            l1 = (l2.next != null)? l2.next: l2;
            ListNode node = new ListNode(((numA + numB + num) %10 == 0)? 0:(numA + numB + num) %10);  //生成新的节点
            nextNode.next=node;               //把心节点连起来
            nextNode=nextNode.next;
            num = (numA + numB + num)/10;//当前节点往后移动
        }
        return  nodeStar;
    }
}

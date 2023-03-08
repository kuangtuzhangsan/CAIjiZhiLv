package com.xyx.leetcode;

import com.xyx.leetcode.entity.ListNode;

public class LeetCode0304 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static ListNode middleNode(ListNode head) {
        /*
         * 1. 获取总节点数量
         * 2.取到中间节点
         * 3.把新设置的节点指向中间节点
         * */
        int sum = 0;
        int midNum ;
        ListNode nodeStar = new ListNode(head.val,head.next);  //创建首节点
        while (head != null){
            head = head.next;
            sum ++;
        }
        head = nodeStar; //重新指向首节点
        midNum = sum / 2 + 1  ;
        sum = 1;
        ListNode result = null;
        while (head != null){
            if (sum == midNum){
                result= head;
                break;
            }
            head = head.next;
            sum ++;
        }
        return result;
    }

    public static void main(String[] args){

        ListNode nodeStar = new ListNode(0);    //创建首节点
        ListNode nextNode;                     //声明一个变量用来在移动过程中指向当前节点
        nextNode=nodeStar;                      //指向首节点

        //创建链表
        for(int i=1; i<10; i++){
            ListNode node = new ListNode(i);  //生成新的节点
            nextNode.next=node;               //把心节点连起来
            nextNode=nextNode.next;           //当前节点往后移动
        } //当for循环完成之后 nextNode指向最后一个节点，

        nextNode=nodeStar;//重新赋值让它指向首节点
        ListNode middleNode = middleNode(nextNode);
        print(middleNode);                      //打印输出

    }
    //打印输出方法
    static void print(ListNode listNoed){
        //创建链表节点
        while(listNoed!=null){
            System.out.println("节点:"+listNoed.val);
            listNoed=listNoed.next;
        }
        System.out.println();
    }
}

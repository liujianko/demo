package com.demo.suanfa;

import org.junit.Test;

/**
 * @ClassName 算法题2 两数之和
 * @Description TODO
 * @Author liujianko
 * @Date 2020-1-5
 **/
public class Class2 {
    int[] arr1 = {2,4,3};
    int[] arr2 = {5,6,4};
    int len1 = arr1.length;
    int len2 = arr2.length;


    // 错误的
    @Test
    public void test1(){
        ListNode l1 = null;
        ListNode l2 = null;
        int len = len1 > len2?len1:len2;
        for (int i = 0; i < len; i++) {
            l1 = new ListNode(arr1[i]);
            l2 = new ListNode(arr2[i]);
            addTwoNumber(l1,l2);
        }
    }

    @Test
    public void test2(){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        addTwoNumber(l1,l2);
    }

    public ListNode addTwoNumber(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null)? p.val:0;
            int y = (q != null)? q.val:0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        System.out.println(dummyHead.next.val);
        return dummyHead.next;
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x){ val = x; }
}
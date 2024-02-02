package com.lyxianowo.ds.list;

import com.lyxianowo.ds.util.ListNode;
import com.lyxianowo.ds.util.PrintUtil;

/**
 * @author lyxianowo
 * @date 2024-02-02
 */
public class SingleLinkedList {

    /* 链表插入节点 */
    static void insert(ListNode listNode1, ListNode target) {
        // 新建一个节点在 listNode1 后面
        ListNode listNode2 = listNode1.next;
        target.next = listNode2;
        listNode1.next = target;
    }

    /* 链表删除 target 的后一个节点 */
    static void remove(ListNode target) {
        // 如果后面没有节点则返回
        if (target.next == null) return;
        // target -> listNode1 -> listNode2
        ListNode listNode1 = target.next;
        ListNode listNode2 = listNode1.next;
        target.next = listNode2;
    }

    /* 访问链表中的节点 */
    static ListNode access(ListNode head, int index) {
        for (int i = 0; i < index; i++) {
            if (head == null)
                return null;
            head = head.next;
        }
        return head;
    }

    /* 查找链表中值为 target 的节点 */
    static int find(ListNode head, int target) {
        int index = 0;
        while (head != null) {
            if (head.val == target) {
                return index;
            }
            head = head.next;
            index++;
        }
        // not found
        return -1;
    }


    public static void main(String[] args) {
        /* 初始化链表 1 -> 3 -> 2 -> 4 -> 5 */
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        System.out.println("init linkedlist...");
        PrintUtil.printLinkedList(listNode1);

        System.out.println("insert linkedlist...");
        insert(listNode1, new ListNode(0));
        PrintUtil.printLinkedList(listNode1);

        System.out.println("remove linkedlist...");
        remove(listNode1);
        PrintUtil.printLinkedList(listNode1);

        ListNode node = access(listNode1, 3);
        System.out.println("链表中索引 3 处的节点的值 = " + node.val);

        int index = find(listNode1, 1);
        PrintUtil.printLinkedList(listNode1);
        System.out.println("链表中值为 1 的节点的索引 = "+ index);


    }

}

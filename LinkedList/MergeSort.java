package LinkedList;

import java.util.List;

public class MergeSort {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode sortedList = new ListNode(0);
        ListNode tail = sortedList;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val){
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }
        return sortedList.next;


    }

    private ListNode getMid(ListNode head){
        ListNode midPrev = null;
        while(head !=null && head.next != null){
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while(present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null){
                next = next.next;
            }
        }
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) {
            return head;
        }

        //skip the l-1 node;
        ListNode current = head;
        ListNode prev = null;
        for (int i = 0; current !=null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }
        ListNode last = prev;
        ListNode newEnd = current;

        //reverse b/w left & right;
        ListNode next = current.next;
        for (int i = 0; current != null && i < right-left+1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null){
                next = next.next;
            }
        }

        if (last != null){
            last.next = prev;
        } else {
            head = prev;
        }
        newEnd.next = current;

        return head;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        ListNode headSecond = reverseList(head);
        ListNode rereverseHead = headSecond;

        while (head != null && headSecond != null){
            if (head.val != headSecond.val) {
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(rereverseHead);

        return head == null || headSecond == null;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }
}

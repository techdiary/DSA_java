package LinkedList;

public class InterviewQuestions {

    // https://leetcode.com/problems/linked-list-cycle
    // Amazon and Microsoft
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // find length of the cycle
    public int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // calculate the length
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }

    // https://leetcode.com/problems/linked-list-cycle-ii/
    public ListNode detectCycle(ListNode head) {
        int length = 0;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                length = lengthCycle(slow);
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        // find the start node
        ListNode f = head;
        ListNode s = head;

        while (length > 0) {
            s = s.next;
            length--;
        }

        // keep moving both forward and they will meet at cycle start
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;
    }

    // https://leetcode.com/problems/middle-of-the-linked-list/submissions/
    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    // https://leetcode.com/problems/reverse-linked-list/submissions/
    // google, apple, amazon, microsoft
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
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

    // it's also reversing the < k end items -> modify it accordingly
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null) {
            return head;
        }

        //skip the l-1 node;
        ListNode current = head;
        ListNode prev = null;

        while (true){

            ListNode last = prev;
            ListNode newEnd = current;

            //reverse b/w left & right;
            ListNode next = current.next;
            for (int i = 0; current != null && i < k; i++) {
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
            if (current == null){
                break;
            }
            prev = newEnd;
        }
        return head;
    }

    public ListNode myRotateRight(ListNode head, int k){
        if(k==0){
            return head;
        }
        ListNode temp = head;
        while(temp.next !=null){
            if( temp.next.next == null) {
                head = temp.next;
                temp.next.next = head;
                temp.next = null;
            }
            temp = temp.next;
        }
        return myRotateRight(head, k--);
    }

    public ListNode rotateRight(ListNode head, int k){
        if (k <=0 || head == null || head.next == null){
            return head;
        }

        ListNode last = head;
        int length = 1;
        while (last.next != null){
            last = last.next;
            length++;
        }
        last.next = head;
        int rotations = k % length;
        int skip = length - rotations;

        ListNode newlast = head;
        for (int i = 0; i < skip - 1; i++) {
            newlast = newlast.next;
        }
        head = newlast.next;
        newlast.next = null;

        return head;
    }

    public int getLength(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }


    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
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


//    https://leetcode.com/problems/reorder-list/description/
    public void reorderList(ListNode head) {

        if(head == null || head.next == null){
            return;
        }

        ListNode mid = middleNode(head);
        ListNode hs = reverseList(mid);
        ListNode hf = head;

        //re-arrange
        while(hf != null && hs != null){
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;
            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        // setting next of hf to null
        if (hf != null){
            hf.next = null;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int x) {
        val = x;
        next = null;
    }
}

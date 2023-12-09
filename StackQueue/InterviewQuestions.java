package StackQueue;

import java.util.Arrays;
import java.util.Stack;

public class InterviewQuestions {
    public static void main(String[] args) {
//        QueueUsingStack stack = new QueueUsingStack();
//        stack.add(5);
//        stack.add(4);
//        stack.add(3);
//        stack.add(2);
//        stack.add(1);
//        System.out.println(stack.remove());

     //2 stack game
//        int[] arr = {4,2,4,6,1};
//        int[] arr2 = {4,1,8,5};
//        TwoStack stackgame = new TwoStack();
//        int ans = stackgame.twoStack(10, arr, arr2);
//        System.out.println(ans);

        // HISTOGRAM
//        HistogramRectangle rect = new HistogramRectangle();
//        int[] histogramArr ={2,1,5,6,2,3};
//        int ans = rect.maxRectangleArea(histogramArr);

        //VALID PARANTH
//        System.out.println(isValid("()[]{}"));
//        System.out.println(minAddToMakeValid("((("));
//        System.out.println(minInsertions("((("));
        System.out.println(minInsertions("(()))"));
        System.out.println(minInsertions("())"));
        System.out.println(minInsertions("))())("));
    }
    
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for (char ch :
                s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            } else {
                if (ch == ')'){
                    if ( stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                }
                if (ch == '}'){
                    if ( stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                }
                if (ch == ']'){
                    if ( stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if(ch == ')'){
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }

    public static int minInsertions(String s) {
        int closed = 0, open = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i <= chars.length -1; i++) {
            if (chars[i] == ')') {
                //check next char el is closed too
                if ((i+1) < chars.length && chars[i + 1] == ')') {
                    ++i;
                } else {
                    ++closed;
                }

                if (open > 0){
                    --open;
                } else {
                    ++closed;
                }
            } else {
                ++open;
            }
        }

        closed += open * 2;

        return closed;
    }

}

class HistogramRectangle {

    public HistogramRectangle() {}

    public int maxRectangleArea(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        stack.push(0);

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                max = getMax(arr, stack, max, i);
            }
            stack.push(i);
        }

        int i = arr.length;
        while (!stack.isEmpty()){
            max = getMax(arr, stack,max, i);
        }

        return max;
//        int max = maxArea(arr, 0, 1);
    }

    private int getMax(int[] arr, Stack<Integer> stack, int max, int i) {
        int area;
        int popped = stack.pop();
        if(stack.isEmpty()){
            area = arr[popped] * i;
        } else {
            area = arr[popped] * (i-1 - stack.peek());
        }
        return Math.max(max, area);

    }
}
class TwoStack{

    public TwoStack(){}
    public  int twoStack(int x, int[] a, int[] b) {
        return twoStack(x, a, b, 0, 0) - 1;
    }

    private static int twoStack(int x, int[] a, int[] b, int sum, int count) {

        if(sum > x){
            return count;
        }

        if (a.length == 0 || b.length == 0){
            return count;
        }

        int ans1 = twoStack(x, Arrays.copyOfRange(a, 1, a.length), b, sum+a[0], count+1);
        int ans2 = twoStack(x, a, Arrays.copyOfRange(b, 1, b.length), sum+b[0], count+1);

        return Math.max(ans1, ans2);

    }

}

class QueueUsingStack {

    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item) {
        first.push(item);
    }

    public int remove() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int removed  = second.pop();

        while (!second.isEmpty()){
            first.push(second.pop());
        }

        return removed;
    }

    public int peek() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int peeked  = second.peek();

        while (!second.isEmpty()){
            first.push(second.pop());
        }

        return peeked;
    }

    public boolean empty() {
        return first.isEmpty();
    }

}

class QueueUsingStackRemove {

    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStackRemove() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item) {
        while (!first.isEmpty()){
            second.push(first.pop());
        }

        first.push(item);

        while (!second.isEmpty()){
            first.push(second.pop());
        }
    }

    public int remove() {
        return first.pop();
    }

    public int peek() {
        return first.peek();
    }

    public boolean empty() {
        return first.isEmpty();
    }

}

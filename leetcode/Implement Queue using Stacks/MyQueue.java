import java.util.*;
public class MyQueue {
    private Queue<Integer> stack = new LinkedList<Integer>();
    private Queue<Integer> buffer= new LinkedList<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        while(!stack.isEmpty()){
            int tmp = stack.remove();
            buffer.add(tmp);
        }
        stack.add(x);
        while(!buffer.isEmpty()){
            int tmp = buffer.remove();
            stack.add(tmp);
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!stack.isEmpty()){
            stack.remove();
        }
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
    public void output(){
        System.out.println("The Stack is now: ");
        System.out.println(stack);
    }
    public static void main(String []args){
        MyQueue pq = new MyQueue();
        pq.output();
        pq.push(1);
        pq.output();
        pq.push(2);
        pq.output();
        pq.pop();
        pq.output();
        pq.peek();
        pq.output();
    }
}

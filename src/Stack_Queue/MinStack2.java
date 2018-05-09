package Stack_Queue;

import java.util.Stack;

public class MinStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public MinStack2(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }
    public int getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("Stack is Empty");
        }
        return stackMin.peek();
    }
    public void push(int newNum){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }
        if(this.getMin() >= newNum){
            this.stackMin.push(newNum);
        }
        else{
            this.stackMin.push(this.stackMin.peek());
        }
        this.stackData.push(newNum);
    }
    public void pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Stack is Empty");
        }
        this.stackData.pop();
        this.stackMin.pop();
    }
    public static void main(String[] args) {
        MinStack2 minStack2 = new MinStack2();
        minStack2.push(5);
        System.out.println(minStack2.getMin());
        minStack2.push(4);
        System.out.println(minStack2.getMin());
        minStack2.push(8);
        System.out.println(minStack2.getMin());
        minStack2.push(3);
        System.out.println(minStack2.getMin());
        minStack2.pop();
        System.out.println(minStack2.getMin());
        minStack2.pop();
        System.out.println(minStack2.getMin());
    }
}

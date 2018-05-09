package Stack_Queue;
import java.util.Stack;

//实现一个具有 getMin 功能的栈， 即找到栈中的最小值，在时间复杂度为 O(1) 的情况下
public class MinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public MinStack(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }
    public Integer getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("Stack is Empty!");
        }
        return this.stackMin.peek();//返回 stackMin 的栈顶值
    }
    public void push(int newNum){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }
        if(this.getMin() > newNum){
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }
    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Stack is Empty");
        }
        int value = this.stackData.pop();
        if(value == this.getMin()){
            this.stackMin.pop();
        }
        return value;
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        System.out.println(minStack.getMin());
        minStack.push(4);
        System.out.println(minStack.getMin());
        minStack.push(8);
        System.out.println(minStack.getMin());
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

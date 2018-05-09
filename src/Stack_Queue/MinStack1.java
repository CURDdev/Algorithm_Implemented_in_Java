package Stack_Queue;
import java.util.Stack;

//实现一个具有 getMin 功能的栈， 即找到栈中的最小值，在时间复杂度为 O(1) 的情况下
public class MinStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public MinStack1(){
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
        if(this.getMin() >= newNum){
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
        MinStack1 minStack1 = new MinStack1();
        minStack1.push(5);
        System.out.println(minStack1.getMin());
        minStack1.push(4);
        System.out.println(minStack1.getMin());
        minStack1.push(8);
        System.out.println(minStack1.getMin());
        minStack1.push(3);
        System.out.println(minStack1.getMin());
        minStack1.pop();
        System.out.println(minStack1.getMin());
        minStack1.pop();
        System.out.println(minStack1.getMin());
    }
}

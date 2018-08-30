package Stack_Queue;
import java.util.Stack;

//实现一个具有 getMin 功能的栈， 即找到栈中的最小值，在时间复杂度为 O(1) 的情况下
public class MinStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public MinStack1(){
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }
    public Integer getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("Stack is Empty!");
        }
        return this.stackMin.peek();//返回 stackMin 的栈顶值
    }
    public void push(int newNum){
        //min 栈初始化
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }
        if(this.getMin() >= newNum){
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }
    public int pop(){
        //别忘了异常判断
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Stack is Empty");
        }
        int value = this.stackData.pop();
        //如果弹出的数据比 min 大，则 min 栈不需要弹出;如果弹出的数据等于 min，则 min 弹出栈顶元素;弹出的数据不可能小于 min 的栈顶元素
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

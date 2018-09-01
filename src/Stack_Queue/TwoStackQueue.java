package Stack_Queue;

import java.util.Stack;

//编写一个类，用两个栈实现队列，支持队列的基本操作
public class TwoStackQueue {
    //压入栈，新来的数据全部压入这个栈
    public Stack<Integer> stackPush;
    //弹出栈，压入栈向弹出栈压入数据时，必须全部压入；如果弹出栈不为空，则不能从压入栈向弹出栈中压入数据
    public Stack<Integer> stackPop;
    public TwoStackQueue(){
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }
    //入队操作不会使得stackPop为空
    public void add(int newNum){
        stackPush.push(newNum);
    }
    //出队操作
    public int poll(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("队列为空");
        }
        //将stackPush中的元素全部压入stackPop
        if(stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }
    //查询队首元素
    public int peek(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("队列为空");
        }
        if(stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
    public static void main(String[] args){
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.add(1);
        twoStackQueue.add(2);
        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.peek());
        twoStackQueue.add(1);
        twoStackQueue.add(3);
    }
}

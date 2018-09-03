package Stack_Queue;

import java.util.Stack;

public class SortStackWithStack {
    private Stack<Integer> helpStack;
    public void sortStackByStack(Stack<Integer> stack){
        while(!stack.isEmpty()){
            //未考虑到初始情况，helpStack为空时,需要暂存stack.pop()的值
//            if(stack.peek() <= helpStack.peek()){
//                helpStack.push(stack.pop());
//            }
//            else {
//                while(stack.peek() > helpStack.peek()){
//                    stack.push(helpStack.pop());
//                }
            //    helpStack.push(stack.pop());
//            }
            //书上的解法
            //如果cur小于等于helpstack栈顶的元素，则直接将cur压入helpstack
            //如果cur大于helpstack栈顶的元素，则一直将helpStack中的元素弹出到stack中，直到cur小于等于helpstack栈顶的元素，再将cur压入helpstack。
            //最后将helpstack中的元素依次压入到stack中
            int cur = stack.pop();
            while(!helpStack.isEmpty() && helpStack.peek() > cur){
                stack.push(helpStack.pop());
            }
            helpStack.push(cur);
        }
        while(!helpStack.isEmpty()){
            stack.push(helpStack.pop());
        }
    }
}

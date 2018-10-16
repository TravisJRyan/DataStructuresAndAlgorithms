/* 
    3.2 Min Function Stack - w would you design a stack which, in addition to push and pop, also 
    has a function min which returns the minimum element? Push, pop and min shouldall operate in O(1) time
*/

import java.util.EmptyStackException;

public class MinFunctionStack{

    private StackNode<Integer> top;
    Stack<Integer> minStack; // keep an additional stack of all the mins, update if a min is pushed/popped

    public MinFunctionStack(){
        minStack = new Stack<Integer>();
    }

    public int pop(){
        if(top==null)
            throw new EmptyStackException();
        else{
            int valueToReturn = top.getValue();
            top = top.next;
            if(valueToReturn==minStack.peek())
                minStack.pop();
            return valueToReturn;
        }
    }

    public void push(int value){
        StackNode<Integer> newStackNode = new StackNode<Integer>(value);
        if(isEmpty()){
            top = newStackNode;
            minStack.push(newStackNode.value);
        } else{
            newStackNode.next = top;
            top = newStackNode;
            if(top.value<=minStack.peek())
                minStack.push(top.value);
        }
    }

    public int peek(){
        if(isEmpty())
            throw new EmptyStackException();
        else{
            return top.getValue();
        }
    }

    public boolean isEmpty(){
        return top==null;
    }

    // Return the top element of the stack of minimums
    public int getMin(){
        return minStack.peek();
    }

    public class StackNode<Integer>{

        int value;
        StackNode next;

        public StackNode(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }

    }

    public static void main(String[] args){
        MinFunctionStack testStack = new MinFunctionStack();
        testStack.push(19);
        testStack.push(5);
        testStack.push(12);
        testStack.push(9);
        testStack.push(10);
        System.out.println("Expecting 5: "+testStack.getMin());
        testStack.push(3);
        testStack.push(30);
        System.out.println("Expecting 3: "+testStack.getMin());
        testStack.pop();
        testStack.pop();
        testStack.pop();
        System.out.println("Expecting 5: "+testStack.getMin());
    }
}
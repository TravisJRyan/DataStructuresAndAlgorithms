/* 
    3.2 Min Function Stack - w would you design a stack which, in addition to push and pop, also 
    has a function min which returns the minimum element? Push, pop and min shouldall operate in O(1) time

    TODO: implement Min Element aspect
*/

import java.util.EmptyStackException;

public class MinFunctionStack{

    private StackNode<Integer> top;
    Integer minElement;

    public MinFunctionStack(){}

    public int pop(){
        if(top==null)
            throw new EmptyStackException();
        else{
            int valueToReturn = top.getValue();
            top = top.next;
            return valueToReturn;
        }
    }

    public void push(int value){
        StackNode<Integer> newStackNode = new StackNode<Integer>(value);
        if(isEmpty()){
            top = newStackNode;
        } else{
            newStackNode.next = top;
            top = newStackNode;
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
}
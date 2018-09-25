import java.util.EmptyStackException;

public class Stack<T>{

    private StackNode<T> top;

    public Stack(){}

    public T pop(){
        if(top==null)
            throw new EmptyStackException();
        else{
            T valueToReturn = top.getValue();
            top = top.next;
            return valueToReturn;
        }
    }

    public void push(T value){
        StackNode<T> newStackNode = new StackNode<T>(value);
        if(isEmpty()){
            top = newStackNode;
        } else{
            newStackNode.next = top;
            top = newStackNode;
        }
    }

    public T peek(){
        if(isEmpty())
            throw new EmptyStackException();
        else{
            return top.getValue();
        }
    }

    public boolean isEmpty(){
        return top==null;
    }

    public class StackNode<T>{

        T value;
        StackNode next;

        public StackNode(T value){
            this.value = value;
        }

        public T getValue(){
            return value;
        }

    }
}
/* 
    3.4 Queue Via Stacks - Implement a MyQueue class which implements a queue using two stacks
*/

public class QueueViaStacks{

    Stack<Integer> filledStack;
    Stack<Integer> emptyStack;

    // solution uses a filled stack and an empty stack to reverse elements for every dequeue
    public QueueViaStacks(){
        filledStack = new Stack<Integer>();
        emptyStack = new Stack<Integer>();
    }

    // Enqueue runs in O(1)
    public void enqueue(int value){
        filledStack.push(value);
    }

    // Dequeue runs in O(n) - must copy all elements back and forth twice
    public int dequeue(){
        while(!filledStack.isEmpty())
            emptyStack.push(filledStack.pop());
        int returnValue = emptyStack.pop();
        while(!emptyStack.isEmpty())
            filledStack.push(emptyStack.pop());
        return returnValue;
    }

    public static void main(String[] args){
        QueueViaStacks queue = new QueueViaStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println("1: "+queue.dequeue());
        System.out.println("2: "+queue.dequeue());
        queue.enqueue(6);
        queue.enqueue(7);
        System.out.println("3: "+queue.dequeue());
    }

}
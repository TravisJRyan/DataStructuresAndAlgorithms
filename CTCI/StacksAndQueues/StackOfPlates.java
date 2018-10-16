/* 
    3.3 Stack of Plates - Imagine a (literal) stack of plates. If the stack gets too high, it might topple. We would
    likely start a new stack if the previous exceeds some threshold. Implement a data structure SetOfStacks that
    mimics this. It should be composed of several stacks and should create a new one once the previous exceeds
    capacity. push() and pop() should behave identically to if there were just one stack.

    FOLLOW UP: Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
*/

import java.util.EmptyStackException;
import java.util.ArrayList;

public class StackOfPlates{

    public static class SetOfStacks{

        ArrayList<Stack> stacks;
        int currentIndex = 0;
        int threshold; // max number of plates on a stack

        public SetOfStacks(int threshold){
            stacks = new ArrayList<Stack>();
            stacks.add(0, new Stack<Integer>());
            this.threshold = threshold;
        };

        public void push(int element){
            stacks.get(currentIndex).push(element);
            if(stacks.get(currentIndex).size() >= threshold){
                currentIndex++;
                if(stacks.size()<=currentIndex+1);
                    stacks.add(new Stack<Integer>());
            }
        }

        public int pop(){
            if(stacks.get(currentIndex).size()==0){
                if(currentIndex==0)
                    throw new EmptyStackException();
                else
                    currentIndex--;
            }
            return (int)stacks.get(currentIndex).pop();
        }

        // Working popAt function. The primary issue with this solution is that stacks aren't always
        // filled to capacity. There are trade-offs to different approaches, and it depends on requirements ultimately.
        public int popAt(int index){
            return (int)stacks.get(index).pop();
        }
    }

    public static void main(String[] args){
        SetOfStacks stacks = new SetOfStacks(3);
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        stacks.push(5);
        stacks.push(6);
        stacks.push(7);
        stacks.push(8);
        stacks.push(9);
        stacks.push(10);
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.popAt(1));
    }

}
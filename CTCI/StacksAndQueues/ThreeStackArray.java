/* 
    3.1 - Describe how you could use an array to implement three stacks.
*/

import java.util.EmptyStackException;

import java.lang.StackOverflowError;

public class ThreeStackArray{

    int[] stackArray;
    int stackOneIndex;
    int stackTwoIndex;
    int stackThreeIndex;

    public ThreeStackArray(){
        stackArray = new int[102];
        stackOneIndex = 0;
        stackTwoIndex = 1;
        stackThreeIndex = 2;
    }

    public void push(int stackNumber, int value){
        int stackIndex = 0;
        if(stackNumber == 1)
            stackIndex = stackOneIndex;
        else if(stackNumber == 2)
            stackIndex = stackTwoIndex;
        else if(stackNumber == 3)
            stackIndex = stackThreeIndex;
        else
            return;
        stackIndex+=3;
        if(stackArray.length <= stackIndex) // could also create a resize method for this case
            throw new StackOverflowError();
        else{
            stackArray[stackIndex] = value;
            if(stackNumber == 1)
                stackOneIndex += 3;
            else if(stackNumber == 2)
                stackTwoIndex += 3;
            else if(stackNumber == 3)
                stackThreeIndex += 3;
        }
    }

    public int pop(int stackNumber){
        int stackIndex;
        if(stackNumber == 1){
            stackIndex = stackOneIndex;
            stackOneIndex -= 3;
        }
        else if(stackNumber == 2){
            stackIndex = stackTwoIndex;
            stackTwoIndex -= 3;
        }
        else if(stackNumber == 3){
            stackIndex = stackThreeIndex;
            stackThreeIndex -= 3;
        }
        else
            return -1; // failure indicator
        if(stackIndex < 0)
            throw new EmptyStackException();
        return stackArray[stackIndex];
    }

    public static void main(String[] args){
        ThreeStackArray stacks = new ThreeStackArray();
        stacks.push(1, 12);
        stacks.push(1, 23);
        stacks.push(1, 40);
        stacks.push(2, 30);
        stacks.push(3, 18);
        stacks.push(2, 29);
        System.out.println(stacks.pop(1));
        System.out.println(stacks.pop(3));
        System.out.println(stacks.pop(1));
        System.out.println(stacks.pop(2));

    }

}
/* 
    2.5 Sum Lists - You have two numbers represented by linked lists where each node contains a single digit.
    The digits are stored in reverse order such that the 1's digit is at the head of the list. Write a function that
    adds the two numbers and returns the sum as a linked list.

    Follow Up: Suppose digits are in forward order. Repeat the same problem.
*/

public class SumLists{
    public static void main(String[] args){
        LinkedList<Integer> firstNumberTest = new LinkedList<Integer>();
        LinkedList<Integer> secondNumberTest = new LinkedList<Integer>();
        // First number: 617
        firstNumberTest.add(7);
        firstNumberTest.add(1);
        firstNumberTest.add(6);
        // Second number: 295
        secondNumberTest.add(5);
        secondNumberTest.add(9);
        secondNumberTest.add(2);
        // Expected Result: 2 -> 1 -> 9 (912)
        sum(firstNumberTest, secondNumberTest).printList();
    }

    // Time - O(N) where N is the length of the integer in digits. For small enough integers, essentially O(1)
    // Space - O(3N) where N is average int length. Very small space in typical case.
    public static LinkedList<Integer> sum(LinkedList<Integer> firstList, LinkedList<Integer> secondList){
        int firstInt = getNumberFromReverseList(firstList);
        int secondInt = getNumberFromReverseList(secondList);
        int sum = firstInt + secondInt;
        return getReverseListFromNumber(sum);
    }

    // Aux method that gets an integer from digits in reversed linked list
    public static int getNumberFromReverseList(LinkedList<Integer> list){
        LinkedListNode<Integer> current = list.head;
        int multiplyFactor = 1;
        int sum = 0;
        while(current!=null){
            sum += multiplyFactor*current.getValue();
            multiplyFactor*=10;
            current = current.next;
        }
        return sum;
    }

    // Aux method that generates a linked list in reverse order for a number
    public static LinkedList<Integer> getReverseListFromNumber(int input){
        LinkedList<Integer> output = new LinkedList<Integer>();
        while(input!=0){
            output.add(input%10);
            input /= 10;
        }
        return output;
    }
}
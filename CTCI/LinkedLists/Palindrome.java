
/*
    2.6 Palindrome - Implement a method to check if a linked list is a palindrome
*/

import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        LinkedList<Integer> testListTrue = new LinkedList<Integer>();
        testListTrue.add(4);
        testListTrue.add(5);
        testListTrue.add(6);
        testListTrue.add(5);
        testListTrue.add(4);

        LinkedList<Integer> testListFalse = new LinkedList<Integer>();
        testListFalse.add(3);
        testListFalse.add(4);
        testListFalse.add(5);
        testListFalse.add(7);
        testListFalse.add(3);

        System.out.println("True: " + isPalindrome(testListTrue));
        System.out.println("False: " + isPalindrome(testListFalse));
    }

    // O(n) time - iterate through list several time
    // O(2n) space -  create one additional list of same size
    public static boolean isPalindrome(LinkedList<Integer> input) {
        if (input.head == null || input.head.next == null) // handle nulls or size 1
            return true;
        LinkedListNode<Integer> current = input.head;
        LinkedListNode<Integer> reversedCurrent = new LinkedListNode<Integer>(current.value);
        while(current.next!=null){ // go through original list and build new list into a reverse of the original
            LinkedListNode<Integer> tempNode = new LinkedListNode<Integer>(current.next.value);
            tempNode.next = reversedCurrent;
            reversedCurrent = tempNode;
            current = current.next;
        }

        current = input.head; // reset current iterator to be head of original list

        while(current!=null){ // go through both lists and check for differences, returning false if any
            if(reversedCurrent.value != current.value)
                return false;
            current = current.next;
            reversedCurrent = reversedCurrent.next;
        }

        return true; // no discrepencies found, return true
    }
}
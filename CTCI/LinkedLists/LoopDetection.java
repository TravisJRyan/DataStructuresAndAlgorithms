/* 
    2.8 Loop Detection - Given a circular linked list, implement an algorithm at the beginning of the loop
    Example Input:  A -> B -> C -> D -> E -> C (the same C as earlier)
            Output: C
*/

public class LoopDetection{
    public static void main(String[] args){
        LinkedList<Integer> testList = new LinkedList<Integer>();
        testList.add(3);
        testList.add(49);
        testList.add(31);
        testList.add(84);
        LinkedListNode<Integer> loopStart = new LinkedListNode<Integer>(12);
        testList.head.next.next.next.next = loopStart;
        LinkedListNode<Integer> loopNode2 = new LinkedListNode<Integer>(14);
        loopStart.next = loopNode2;
        LinkedListNode<Integer> loopNode3 = new LinkedListNode<Integer>(0);
        loopNode2.next = loopNode3;
        LinkedListNode<Integer> loopNode4 = new LinkedListNode<Integer>(29);
        loopNode3.next = loopNode4;
        loopNode4.next = loopStart;
        System.out.println("Expecting 12: "+findLoopStart(testList).value);
    }

    // 3 -> 49 -> 31 -> 84 -> 12 -> 14 -> 0 -> 29 -> 12 -> ...
    // a fast slow moves by 2, a slow node moves by 1
    // when they meet, move the slow node back to the beginning, and increment both by 1 until they meet. Return this node.
    // O(2) space - only need 2 additional nodes
    // O(N) time - moving through the list several times
    public static LinkedListNode<Integer> findLoopStart(LinkedList<Integer> inputList){
        if(inputList.head == null || inputList.head.next == null)
            return null;
        LinkedListNode<Integer> fast = inputList.head;
        LinkedListNode<Integer> slow = inputList.head;
        // make one "movement" for both fast and slow to ensure loop doesnt terminate early
        fast = fast.next.next;
        slow = slow.next;
        // get slow and fast to meet
        while(fast!=slow){
            if(fast == null || slow == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        // move slow node to beginning, move them both by ONE to find the loop's start
        slow = inputList.head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        // return fast (or slow, they're at the same point now)
        return fast;
    }
}
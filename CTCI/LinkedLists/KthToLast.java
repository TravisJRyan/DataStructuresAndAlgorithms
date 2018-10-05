/*
    2.2 Kth to Last - Implement an algorithm to return the kth to last element
    of a singly linked list
*/

public class KthToLast{
    public static void main(String[] args){
        // Standard case test
        LinkedList<Integer> testList = new LinkedList<Integer>();
        testList.add(9);
        testList.add(2);
        testList.add(5);
        testList.add(12);
        testList.add(3);
        testList.add(19);
        testList.add(7);
        testList.add(2);
        testList.add(24);
        testList.add(24);
        testList.add(4);
        testList.add(5);
        testList.add(18);
        testList.printList();
        System.out.println(kthToLast(testList, 4).getValue());
    }

    //O(N) time - Iterating through each node once
    //O(N+2) space - Only additional space is the runner nodes
    public static LinkedListNode<Integer> kthToLast(LinkedList<Integer> list, int K){
        if(list.getSize()<=K)
            return null;
        LinkedListNode<Integer> runnerToEnd = head;
        for(int i = 0; i < K; i++){
            runnerToEnd = runnerToEnd.next;
        }
        LinkedListNode<Integer> runnerToTarget = head;
        while(runnerToEnd!=null){
            runnerToEnd = runnerToEnd.next;
            runnerToTarget = runnerToTarget.next;
        }
        return runnerToTarget.getValue();
    }
}
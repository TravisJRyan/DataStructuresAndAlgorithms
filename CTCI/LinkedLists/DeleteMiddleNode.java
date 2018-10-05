/* 
    2.3 Delete Middle Node - Implement an algorithm to delete a middle node in the linked list (a node that is
    not the first or last node counts as a middle node.) You only have access to that node.
*/

public class DeleteMiddleNode{
    public static void main(String[] args){
        LinkedList<Integer> testList = new LinkedList<Integer>();
        testList.add(1);
        testList.add(2);
        testList.add(3); // test node
        testList.add(4);
        testList.add(5);
        LinkedListNode<Integer> testNode = testList.head.next.next;
        deleteMiddle(testNode);
        testList.printList();
    }

    // Cannot solve if given node is null or it is the last node in the list
    // 
    public static void deleteMiddle(LinkedListNode<Integer> givenNode){
        if(givenNode == null || givenNode.next==null)
            return;
        LinkedListNode<Integer> nextNode = givenNode.next;
        givenNode.setValue(nextNode.getValue());
        givenNode.setNext(nextNode.getNext());
    }

}
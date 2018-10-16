/*
    4.6 Successor - Write an algorithm to find the "next" node (in-order successor) of a given node in a binary search tree.
    You may assume each node has a link to its parent.
*/

public class Successor{
    public static void main(String[] args){
        BinarySearchTree<Integer> testTree = new BinarySearchTree<Integer>();
        /*
                    6
                                    24
                        9                    59
                              23          49
                          15                 50                    
        */
        testTree.add(6);
        testTree.add(24);
        testTree.add(59);
        testTree.add(9);
        testTree.add(49);
        testTree.add(50);
        testTree.add(23);
        testTree.add(15);
        System.out.println(getSuccessor(testTree.root.right)); // 24 -> 49
    }

    // O(N) time - visiting all nodes at worst case
    // O(1) space - no additional space is created
    // If node has a right subtree, get its leftmost element. Else, traverse up until the node is no longer a right child
    public static BSTNode<Integer> getSuccessor(BSTNode<Integer> node){
        if(node==null)
            return null;
        if(node.right!=null)
            return leftMostChild(n.right);
        else{
            BSTNode<Integer> parent = node.parent;
            while(parent != null && parent.left != node){
                parent = node;
                node = node.parent;
            }
            return x;
        }
    }

    public BSTNode<Integer> leftMostChild(BSTNode<Integer> node){
        if(node==null)
            return null;
        while(node.left!=null)
            node = node.left;
        return node;
    }


}
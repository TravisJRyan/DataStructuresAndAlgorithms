/* 
    4.5 Validate BST - Implement a function to check if a binary tree is a binary search tree
*/

public class ValidateBST{
    public static void main(String[] args){
        /* TRUE Example
                            50
                25                  75
            12      37                      76
                                                    89
        */
        BSTNode<Integer> trueNode1 = new BSTNode<Integer>(50);
        BSTNode<Integer> trueNode2 = new BSTNode<Integer>(25);
        trueNode1.left = trueNode2;
        BSTNode<Integer> trueNode3 = new BSTNode<Integer>(75);
        trueNode1.right = trueNode3;
        BSTNode<Integer> trueNode4 = new BSTNode<Integer>(12);
        trueNode2.left = trueNode4;
        BSTNode<Integer> trueNode5 = new BSTNode<Integer>(37);
        trueNode2.right = trueNode5;
        BSTNode<Integer> trueNode6 = new BSTNode<Integer>(76);
        trueNode3.right = trueNode6;
        BSTNode<Integer> trueNode7 = new BSTNode<Integer>(89);
        trueNode6.right = trueNode7;
        System.out.println("Expecting True: "+validateBST(trueNode1));

         /* FALSE Example
                            50
                25                  75
            12      37                      74 (Violation)
                                                    89
        */
        BSTNode<Integer> falseNode1 = new BSTNode<Integer>(50);
        BSTNode<Integer> falseNode2 = new BSTNode<Integer>(25);
        falseNode1.left = falseNode2;
        BSTNode<Integer> falseNode3 = new BSTNode<Integer>(75);
        falseNode1.right = falseNode3;
        BSTNode<Integer> falseNode4 = new BSTNode<Integer>(12);
        falseNode2.left = falseNode4;
        BSTNode<Integer> falseNode5 = new BSTNode<Integer>(37);
        falseNode2.right = falseNode5;
        BSTNode<Integer> falseNode6 = new BSTNode<Integer>(74); // Violating node (74 to the right of 75)
        falseNode3.right = falseNode6;
        BSTNode<Integer> falseNode7 = new BSTNode<Integer>(89);
        falseNode6.right = falseNode7;
        System.out.println("Expecting False: "+validateBST(falseNode1));
    }

    // O(N) - iterator through every node
    // O(logN) additional space needed - additional logn of nodes are stored while traversing the bottom level
    // Breadth First Search adaptation - keep a linked list of nodes that acts as a stack, add every node's children
    // If a violation is found, return false. If iteration concludes, return true
    public static boolean validateBST(BSTNode<Integer> root){
        if(root==null) // empty binary tree, technically a true BST
            return true;
        LinkedList<BSTNode<Integer>> nodes = new LinkedList<BSTNode<Integer>>();
        nodes.add(root);
        while(nodes.head!=null){
            BSTNode<Integer> currentNode = nodes.head.value;
            if(currentNode.left!=null){
                if((int)currentNode.left.value > currentNode.value)
                    return false;
                nodes.add(currentNode.left);
            }
            if(currentNode.right!=null){
                if((int)currentNode.right.value < currentNode.value)
                    return false;
                nodes.add(currentNode.right);
            }
            nodes.head = nodes.head.next;
        }
        return true;
    }
}
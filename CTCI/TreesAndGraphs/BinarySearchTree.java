public class BinarySearchTree<T extends Comparable>{
    
    BSTNode<T> root;

    public BinarySearchTree(){ }

    public void add(T newValue){
        BSTNode newNode = new BSTNode(newValue);
        if(root==null)
            root = newNode;
        else{
            BSTNode current = root;
            boolean inserted = false;
            while(!inserted){
                if(newValue.compareTo(current.getValue())<=0){
                    if(current.getLeft() == null){
                        current.setLeft(newNode);
                        inserted = true;
                    } else {
                        current = current.getLeft();
                    }
                }
                else {
                    if(current.getRight() == null){
                        current.setRight(newNode);
                        inserted = true;
                    } else {
                        current = current.getRight();
                    }
                }
            }
        }
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void inOrder(){
        inOrder(root);
    }

    public void inOrder(BSTNode node){
        if(node==null)
            return;
        inOrder(node.left);
        System.out.print(" "+node.value+" ");
        inOrder(node.right);
    }

    public void preOrder(){
        preOrder(root);
    }

    public void preOrder(BSTNode node){
        if(node==null)
            return;
        System.out.print(" "+node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    public void postOrder(BSTNode node){
        if(node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(" "+node.value+" ");
    }

    public class BSTNode<T extends Comparable>{

        T value;
        BSTNode left;
        BSTNode right;

        public BSTNode(T value){
            this.value = value;
        }

        public BSTNode getLeft(){
            return left;
        }

        public BSTNode getRight(){
            return right;
        }

        public T getValue(){
            return value;
        }

        public void setLeft(BSTNode newLeft){
            left = newLeft;
        }

        public void setRight(BSTNode newRight){
            right = newRight;
        }
    }
}
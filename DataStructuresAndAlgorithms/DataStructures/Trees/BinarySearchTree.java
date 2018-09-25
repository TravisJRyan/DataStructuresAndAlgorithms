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
public class LinkedList<T>{

    LinkedListNode<T> head;
    int size;

    public LinkedList(){ 
        size = 0;
        head = null;
    }

    public void add(T value){
        if(size == 0){
            head = new LinkedListNode<T>(value);
            size++;
        }
        else{
            LinkedListNode<T> current = head;
            while(current.hasNext()){
                current = current.getNext();
            }
            current.setNext(new LinkedListNode<T>(value));
            size++;
        }
    }

    public boolean remove(T target){
        if(size==0)
            return false;
        LinkedListNode<T> current = head;
        if(current.getValue()==target){
            head = current.getNext();
            size--;
            return true;
        }
        while(current.hasNext()){
            if(current.getNext().getValue()==target){ // target found
                System.out.println("Found "+target);
                if(current.getNext().getNext()!=null){
                    current.setNext(current.getNext().getNext());
                    size--;
                } else {
                    current.setNext(null);
                    size--;
                }
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int getSize(){
        return size;
    }

    public void printList(){
        LinkedListNode<T> current = head;
        while(current!=null){
            System.out.println(current.getValue());
            current = current.getNext();
        }

    }
}
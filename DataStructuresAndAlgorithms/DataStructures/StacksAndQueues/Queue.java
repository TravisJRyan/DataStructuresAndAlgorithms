public class Queue<T>{

    QueueNode top;

    public Queue(){ }

    public T remove(){
        T valueToReturn = (T)top.getValue();
        if(top.getNext()==null){
            top = null;
        } else {
            top = top.getNext();
        }
        return valueToReturn;
    }

    public void add(T newValue){
        QueueNode<T> newNode = new QueueNode<T>(newValue);
        if(isEmpty())
            top = newNode;
        else{
            QueueNode<T> current = top;
            while(current.getNext()!=null){
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public T peek(){
        return (T)top.getValue();
    }

    public boolean isEmpty(){
        return top==null;
    }

    public class QueueNode<T>{

        private T value;
        private QueueNode<T> next;

        public QueueNode(T value){
            this.value = value;
        }

        public T getValue(){
            return value;
        }

        public void setNext(QueueNode next){
            this.next = next;
        }

        public QueueNode getNext(){
            return next;
        }

    }
}
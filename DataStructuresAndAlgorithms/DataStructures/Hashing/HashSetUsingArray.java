public class HashSetUsingArray{
    public static void main(String[] args){
        ArrayHashSet<String> newHashSet = new ArrayHashSet<String>(100);
        System.out.println(newHashSet.isEmpty());
        newHashSet.insert("Hello");
        newHashSet.insert("Hello");
        newHashSet.insert("blahblahblah");
        System.out.println(newHashSet.contains("Hello"));
        System.out.println(newHashSet.contains("Goodbye"));
        System.out.println(newHashSet.isEmpty());
    }

    public static class ArrayHashSet<T>{
        Object[] hashSet;
        public int elements;
        
        public ArrayHashSet(int size){
            hashSet = new Object[size];
            elements = 0;
        }

        public boolean insert(T element){
            if(!contains(element)){
                int insertionIndex = getHashIndex(element);
                // Linear probing until available spot is found
                while(hashSet[insertionIndex]!=null){
                    if(insertionIndex == hashSet.length-1)
                        insertionIndex=0;
                    else{
                        insertionIndex++;
                    }
                }
                hashSet[insertionIndex] = element;
                System.out.println("Inserted "+element+" at "+insertionIndex);
                elements++;
                if((float)elements/getSize()>.7){
                    resize();
                }
                return true;
            }
            return false;
        }

        public boolean contains(T element){
            int hashIndex = getHashIndex(element);
            int getIndex = hashIndex;
            while(hashSet[getIndex]!=element){
                if(getIndex == hashSet.length-1)
                    getIndex = 0;
                else if(getIndex == hashIndex-1)
                    return false;
                else
                    getIndex++;
            }
            return true;
        }

        public int getSize(){
            return hashSet.length;
        }

        public int getHashIndex(T input){
            int hashCode = input.hashCode();
            int index = hashCode % getSize();
            return index;
        }

        public boolean isEmpty(){
            return elements==0;
        }

        public void resize(){
            Object[] oldArray = hashSet;
            hashSet = new Object[getSize()*2];
            for(int i = 0; i < oldArray.length; i++){
                if(oldArray[i]!=null){
                    insert((T)oldArray[i]);
                }
            }
        }

    }
}
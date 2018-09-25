public class BinarySearch{
    public static void main(String[] args){
        int[] numbers = {2, 5, 5, 5, 6, 10, 19, 24, 49, 102, 123, 156, 830, 1002, 3402, 10239, 20349, 103242};
        System.out.println("6 (Index 4): "+binarySearch(numbers, 6));
        System.out.println("10239 (Index 15): "+binarySearch(numbers, 10239));
        System.out.println("20 (Index -1): "+binarySearch(numbers, 20));
        System.out.println("2 (Index 0): "+binarySearch(numbers, 2));
        System.out.println("103242 (Index 17): "+binarySearch(numbers, 103242));
    }

    public static int binarySearch(int[] numbers, int target){
        return binarySearchAux(numbers, target, 0, numbers.length);
    }

    public static int binarySearchAux(int[] numbers, int target, int low, int high){
        if(numbers[0]==target) // edge case: first index is the target
            return 0;
        while(low<high){
            int middle = (low+high)/2;
            System.out.println("Checking "+middle);
            if(numbers[middle]==target)
                return middle;
            else if(target>numbers[middle]){
                low = middle;
            } else {
                high = middle-1;
            }
        }
        return -1;
    }
}
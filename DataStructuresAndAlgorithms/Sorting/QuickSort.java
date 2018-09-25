public class QuickSort{
    public static void main(String[] args){
        int[] numbersToSort = {4, 84, 1, 5, 12, 40, 12, 19, 34, 62, 12, 73, 23, 48};
        quickSort(numbersToSort, 0, numbersToSort.length - 1);
        printArray(numbersToSort);
    }

    // O(nlogn) best and average case - Typically the fastest way to sort
    // O(n^2) worst case - This is rare, but it can happen
    public static void quickSort(int[] numbers, int low, int high){
        if(low<high){
            int partitionIndex = partition(numbers, low, high);
            quickSort(numbers, 0, partitionIndex-1);
            quickSort(numbers, partitionIndex+1, high);
        }
    }

    public static int partition(int[] numbers, int low, int high){
        int pivotValue = numbers[high]; // pick last element for pivot
        int i = low-1; // index of smaller element
        for (int j=low; j<high; j++){ // iterate through the selection
            // If current element is smaller than or equal to pivot 
            if (numbers[j] <= pivotValue){ 
                i++; // increment index of smaller element
                // swap values i and j 
                int temp = numbers[i]; 
                numbers[i] = numbers[j]; 
                numbers[j] = temp; 
            }
        }
        int temp = numbers[i+1]; // swap numbers[i+1] and numbers[high] (or pivot) 
        numbers[i+1] = numbers[high];
        numbers[high] = temp;
        return i+1;
    }

    public static void printArray(int[] numbers){
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i]+" ");
        }
    }
}
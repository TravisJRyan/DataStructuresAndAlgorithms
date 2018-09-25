public class MergeSort{
    public static void main(String[] args){
        int[] numbersToSort = {4, 84, 1, 5, 12, 40, 12, 19, 34, 62, 12, 73, 23, 48};
        mergeSort(numbersToSort, 0, numbersToSort.length-1);
        printArray(numbersToSort);
    }

    // O(nlogn) best, average, and worst case case
    // Requires 2n space (temporary subarrays for merging), so it can be a poor sorting choice if space is an issue
    public static void mergeSort(int[] numbers, int leftIndex, int rightIndex){
        if(leftIndex<rightIndex){
            // Get middle index
            int middleIndex = (leftIndex+rightIndex)/2;

            // Keep merging left and right subarray
            mergeSort(numbers, leftIndex, middleIndex);
            mergeSort(numbers, middleIndex+1, rightIndex);

            // Merge the sorted halves
            merge(numbers, leftIndex, middleIndex, rightIndex);
        }
    }

    public static void merge(int[] numbers, int leftIndex, int middleIndex, int rightIndex){
        // Get sizes of the subarrays that need to be merged
        int leftArraySize = middleIndex-leftIndex+1;
        int rightArraySize = rightIndex - middleIndex;

        // Create the new subarrays (this is where additional space is needed)
        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];

        //Populate the new subarrays
        for(int i = 0; i < leftArraySize; i++){
            leftArray[i] = numbers[leftIndex+i];
        }
        for(int i = 0; i < rightArraySize; i++){
            rightArray[i] = numbers[middleIndex+1+i];
        }

        // Keep track of indexes of the two subarrays and the new merged subarray for merging purposes
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int mergedArrayIndex = leftIndex;

        while(leftArrayIndex<leftArraySize && rightArrayIndex<rightArraySize){
            if(leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]){
                numbers[mergedArrayIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            } else {
                numbers[mergedArrayIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }
            mergedArrayIndex++;
        }

        // If any remaining elements in left array, copy them over
        while(leftArrayIndex<leftArraySize){
            numbers[mergedArrayIndex] = leftArray[leftArrayIndex];
            leftArrayIndex++;
            mergedArrayIndex++;
        }

        // If any remaining elements in right array, copy them over
        while(rightArrayIndex<rightArraySize){
            numbers[mergedArrayIndex] = rightArray[rightArrayIndex];
            rightArrayIndex++;
            mergedArrayIndex++;
        }
    }

    public static void printArray(int[] numbers){
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i]+" ");
        }
    }
}
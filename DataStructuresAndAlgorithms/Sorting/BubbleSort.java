public class BubbleSort{
    public static void main(String[] args){
        int[] numbersToSort = {4, 84, 1, 5, 12, 40, 12, 19, 34, 62, 12, 73, 23, 48};
        bubbleSort(numbersToSort);
        printArray(numbersToSort);
    }

    // O(n^2) - Not an efficient algorithm
    // Sorts the array by swapping values, bringing one larger number to the end at every iteration
    public static void bubbleSort(int[] numbers){
        for(int i = 0; i < numbers.length-1; i++){
            for(int j = 0; j < numbers.length-1; j++){
                if(numbers[j+1] < numbers[j]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] numbers){
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i]+" ");
        }
    }
}
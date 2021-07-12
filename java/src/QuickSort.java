public class QuickSort {


    public static void quickSort(int arr[], int left, int right){
        if (left < right){
            int partitionIndex= partition(arr, left,right);
            quickSort(arr,left, partitionIndex);
            quickSort(arr, partitionIndex+1, right);
        }

    }

    public static int findMedianIndex(int left, int right){
        return left + (right-left)/2;

    }

    public static int partition(int arr[], int left, int right){
        int pivotIndex = findMedianIndex(left,right);
        int i = left;
        int j = right;

        while (i < j){

            while(arr[i] < arr[pivotIndex]){
                i++;
            }

            while (arr[j] > arr[pivotIndex]){
                j--;
            }

            swap(arr,i,j);
        }
        swap(arr,pivotIndex,j);
        return j;
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }

    public static void main(String [] args){
        int[] arr = {10, 16,8,12,15,6,3,9,5};
        DNF.printArray(arr);
        quickSort(arr,0,arr.length-1);
        DNF.printArray(arr);
    }
}

public class SelectionSort {

    public static Integer findMinIndex (int arr [], int start ,int end){
        if (end <=0 || start <0){
            return 0;

        }
        int minIndex =start;

        for(int i=start; i <=end; i++){
            if(arr[i] < arr[minIndex]){
                minIndex =i;
            }
        }

        return minIndex;
    }

    public static int findMaxIndex(int[] arr, int start , int end){
        if (start<0 || end <=0){
            return end;
        }
        int maxIndex = start;

        for(int i =start ; i <=end ; i++){
            if(arr[i] > arr[maxIndex]){
                maxIndex =i;
            }
        }
        return maxIndex;
    }

    public static void selectionSortAsc(int arr[]){
        int temp =0;
        int minIndex=0;
        for(int i =0 ; i < arr.length ; i++){
            temp = arr[i];
            minIndex = findMinIndex(arr,i, arr.length-1);
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

        }
    }

    public static void selectionSortDsc(int arr[]){
        int temp =0;
        int maxIndex = 0;
        for(int i =0; i<arr.length; i++){
            temp = arr[i];
            maxIndex = findMaxIndex(arr,i,arr.length-1);
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

    public static void bubbleSort(int arr[]){
        int temp = 0;
        for (int i=0; i < arr.length-1; i++){
            for(int j = 0 ; j < arr.length -i-1; j++){
                if(arr[j+1] > arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int arr[]){
        int item =0;
        int j =0;

        for (int i = 0; i < arr.length; i++){
            item = arr[i];
            j = i -1;

            while(j>=0 && arr[j]>item){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = item;
        }
    }

    public static void main(String[] args){
        int arr[] = {10,35,6,2,4,5,3,8,9,22,34};
        DNF.printArray(arr);
        System.out.println("Selection sort asc");
        long start = System.nanoTime();
        selectionSortAsc(arr);
        long end = System.nanoTime();
        System.out.println("Duration milliseconds: "+ String.valueOf((end-start)));
        DNF.printArray(arr);
        int arr2[] = {10,35,6,2,4,5,3,8,9,22,34};
        DNF.printArray(arr2);
        System.out.println("Selection sort desc");
        start= System.nanoTime();
        selectionSortDsc(arr2);
        end = System.nanoTime();
        System.out.println("Duration milliseconds: "+ String.valueOf((end-start)));
        DNF.printArray(arr2);
        int arr3[] = {10,35,6,2,4,5,3,8,9,22,34};
        DNF.printArray(arr3);
        System.out.println("bubble sort");
        start = System.nanoTime();
        bubbleSort(arr3);
        end = System.nanoTime();
        System.out.println("Duration milliseconds: "+ String.valueOf((end-start)));
        DNF.printArray(arr3);
        int arr4[] = {10,35,6,2,4,5,3,8,9,22,34};
        DNF.printArray(arr4);
        System.out.println("Insertion sort");
        start = System.nanoTime();
        insertionSort(arr4);
        end = System.nanoTime();
        System.out.println("Duration milliseconds: "+ String.valueOf((end-start)));
        DNF.printArray(arr4);

    }
}

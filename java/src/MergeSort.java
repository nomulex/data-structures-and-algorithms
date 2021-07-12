public class MergeSort {


    public static void merge (int arr[], int left, int mid , int right){
        int sizeLeft = mid-left+1;
        int sizeRight = right-mid;
        int [] leftArr = new int[sizeLeft];
        int [] rightArr = new int [sizeRight];

        for(int i=0; i < sizeLeft; i++){
            leftArr[i] = arr[left+i];
        }

        for (int j=0; j <sizeRight; j++){
            rightArr[j] = arr[mid+j+1];
        }

        //merge arrays back into main array
        int i =0;
        int j=0;
        int k= left;
        while(i<sizeLeft&&j<sizeRight){
            if(leftArr[i] < rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }
            else{
                arr[k] =rightArr[j];
                j++;
            }
            k++;
        }

      //copy any remaining items
        while(i< sizeLeft){
            arr[k] =leftArr[i];
            k++;
            i++;
        }
        while(j<sizeRight){
            arr[k] = rightArr[j];
            k++;
            j++;
        }
    }

    public static void mergeSort(int arr[],int leftIndex, int rightIndex){
        if (leftIndex<0 || rightIndex< 0){
            return;
        }

        if (leftIndex <rightIndex){
            int mid = leftIndex + (rightIndex-leftIndex)/2;
            mergeSort(arr,leftIndex,mid);
            mergeSort(arr,mid+1,rightIndex);
            merge(arr,leftIndex,mid,rightIndex);
        }


    }

    public static void main (String [] args){
        int arr[] = {33,2,45,6,7,4,9,56,90,10,8,9,5,1,3,2,78};
        DNF.printArray(arr);
        System.out.println("Merge Sort");
        long start = System.nanoTime();
        mergeSort(arr, 0, arr.length-1);
        long end = System.nanoTime();
        System.out.println("Duration:" + String.valueOf((end-start)));
        DNF.printArray(arr);

        int arr2[] = {33,2,45,6,7,4,9,56,90,10,8,9,5,1,3,2,78};
        DNF.printArray(arr2);
        System.out.println("Selection sort desc");
        start= System.nanoTime();
        SelectionSort.selectionSortDsc(arr2);
        end = System.nanoTime();
        System.out.println("Duration milliseconds: "+ String.valueOf((end-start)));
        DNF.printArray(arr2);


    }


}

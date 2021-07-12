import java.io.*;
public class DNF {

    public static void DNF (int arr[]){
        int low = 0;
        int mid = 0;
        int high = arr.length-1;
        int temp = 0;


        while (mid <=high){

            switch (arr[mid]){
                case 0:
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid ++;
                    break;
                case 2:
                    temp= arr[high];
                    arr[high] = arr[mid];
                    arr[mid] = temp;
                    high--;
                    break;
            }
        }


    }

    public static void moveZeroes(int arr[]){
        int nonzeroIndex = 0;
        int temp =0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!= 0){
                temp = arr[nonzeroIndex];
                arr[nonzeroIndex] = arr[i];
                arr[i] =temp;
                nonzeroIndex++;

            }
        }

    }

    public static void printArray(int arr[]){
        System.out.print("[");
        for(int i=0; i<arr.length ; i++){
            System.out.print(arr[i]);
            if(i< arr.length-1){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static void main (String [] args){
        int [] arr = {2,0,0,1,1,2};
        printArray(arr);
        DNF(arr);
        printArray(arr);
        int [] arr2 = {2,2,2,1,1,1,0,0,0,2,2,2,1,1,1};
        printArray(arr2);
        DNF(arr2);
        printArray(arr2);
        int [] arr3 = {0,2,4,0,5,6,7,8};
        printArray(arr3);
        moveZeroes(arr3);
        printArray(arr3);


    }

}

import java.awt.*;

public class BinarySearch {
    public  static int binarySearch (int [] arr, int left , int right, int x){

        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            if (arr[mid] > x)
                return binarySearch(arr, left, mid-1, x);

            return binarySearch(arr, mid+1, right, x);


        }

        return -1;

    }

    public static void main (String [] args ){
        int arr[] = {0,1,2,5,7,8,9,11,22,34,56,78,89};
        System.out.println(binarySearch(arr,0,arr.length-1,22));
    }
}

import java.util.HashMap;

public class Arrays {

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        //initialize counters
        int l1 = arr1.length;
        int l2 = arr2.length;
        int k = 0;
        int i = 0;
        int j = 0;
        int[] result = new int[l1+ l2];

        while (i < l1 && j < l2) {

            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            }
            else {
                result[k++] = arr2[j++];
            }
        }

        while (i < l1){
            result[k++] = arr1[i++];
        }

        while (j <l2){
            result[k++] = arr2[j++];
        }

        return result;

    }

    public static int findFirstUnique(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr){
            map.put(i, map.getOrDefault(i,0)+1);

        }

        for (int i : arr){
            if (map.get(i) <2 ){
                return i;
            }
        }

        return 0;
    }


    public static void main (String [] args){

        int [] arr1 = {1, 3, 4, 5};
        int [] arr2 = {2, 6, 7, 8};

        int [] result = mergeArrays(arr1,arr2);

        System.out.print("{");

        for (int i:result){
            System.out.print( i);
        }

        System.out.print("}");


    }
}

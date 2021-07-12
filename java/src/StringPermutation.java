import java.util.*;
import java.util.Arrays;
import java.util.HashMap;

public class StringPermutation {

    public static boolean isPermutation (String string1, String string2){
        if (string1.length() != string2.length()){
            return false;
        }

        String [] str1 = string1.split("");
        String [] str2 = string2.split("");

        Arrays.sort(str1);
        Arrays.sort(str2);

        for (int i =0; i < str1.length; i++){
            if (!str1[i].equals(str2[i])){
                return false;
            }
        }

   return true;
    }

    public static String ReverseString(String string1){
        if(string1.length()==0)
            return string1;

        String result = "";

        for (int i = string1.length()-1 ; i >=0; i--){
            result += String.valueOf(string1.charAt(i));
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(isPermutation("nib", "bin")? "True":"False");
        System.out.println(ReverseString("Uganda"));

        System.out.println(-7%-5);
    }
}

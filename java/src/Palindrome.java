public class Palindrome {

    public static boolean isPalindrome(String s){
        //use pointers front and back (i,j)
        //initialise pointers
        //assume that all characters are in the same case
        int i = 0; //front
        int j = s.length() -1; //back

        while (i !=j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main (String [] args){

        String palindrome =  "nitin";
        String notPalindrome = "school";

        System.out.println(isPalindrome(palindrome)? "Yes": "No");
        System.out.println(isPalindrome(notPalindrome)? "Yes": "No");


    }
}

import java.util.HashMap;
import java.util.Stack;

public class BalancedParenthesis {

    public static String isExpressionBalanced(String expression)
    {
        Stack <String> store = new Stack<String>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("}", "{");
        map.put("]", "[");
        map.put(")", "(");
        String [] exp = expression.split("");

         for (int i =0; i < exp.length; i++){
             String curr = exp[i];
             if (curr.equals("{") || curr.equals("[") || curr.equals("(") ){
                 store.push(curr);
             }
             else {
                 //stack should not be empty if empty
                 if (store.empty()) return "Unbalanced";
                 if( store.peek().equals(map.get (curr))){
                     store.pop();
                 }else {
                     return "Unbalanced" ;
                 }

             }

         }

         return store.empty() && exp.length>1? "Balanced" : "Unbalanced";

    }

    public static void main (String [] args){
        String expression = "{[]}";
        System.out.println(BalancedParenthesis.isExpressionBalanced(expression));
        expression = "{[)]}";
        System.out.println(BalancedParenthesis.isExpressionBalanced(expression));
    }

}

package Stacks;

import java.util.Arrays;
import java.util.Stack;


public class Class_1 {
    public static void main(String[] args) {
        System.out.println("double troble :"+doubleCharTouble("aaaaa"));

    }

    /* Question : Balanced Parenthesis
    * Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
    * Refer to the examples for more clarity.
    * */
    //{([])}
    public static int balancedParenthesis(String A) {
        Stack<Character> paren = new Stack<>();
        int n = A.length();
        if(A.charAt(0) != '}' && A.charAt(0) !=')' && A.charAt(0) != ']'){
            paren.push(A.charAt(0));
        }else{
            return 0;
        }
        for(int i = 1; i< n; i++){
            char ch = 0;
            if(paren.size() > 0){
                ch = paren.peek();
            }
            if((A.charAt(i) == '}' && ch == '{') || (A.charAt(i) == ')' && ch == '(') || (A.charAt(i) == ']' && ch == '[') ){
                paren.pop();
            }else{
                paren.push(A.charAt(i));
            }
        }

        if(paren.size() > 0)  return 0;
        else   return 1;

    }

    /* Question: Double Character Trouble
    * You are given a string A.An operation on the string is defined as follows:
    * Remove the first occurrence of the same consecutive characters. eg for a string "abbcd",
    * the first occurrence of same consecutive characters is "bb".
    * Therefore the string after this operation will be "acd".
    * Keep performing this operation on the string until there are no
    *  more occurrences of the same consecutive characters and return the final string.
    * */
    public static String doubleCharTouble(String A) {
        Stack<Character> stack = new Stack<Character>();
        stack.push( A.charAt(A.length()-1) );

        for(int i=A.length()-2; i>=0; i--)
        {
            if(!stack.isEmpty() && A.charAt(i) == stack.peek())
            {
                stack.pop();
            }
            else
                stack.push(A.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        {
            sb.append(stack.peek());
            stack.pop();
        }
        return sb.toString();

    }

    /* Question : Evaluvate Expression
    * An arithmetic expression is given by a character array A of size N.
    * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    * Valid operators are +, -, *, /. Each character may be an integer or an operator.
    * */
    public static int evalRPN(String[] A) {
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        while(i < A.length){
            if(A[i].equals("*") || A[i].equals("/") || A[i].equals("+") || A[i].equals("-")){
                int a = stk.pop();
                int b = stk.pop();
                int result = cal(a,b,A[i].charAt(0));
                stk.push(result);
            }else{
                stk.push(Integer.parseInt(A[i]));
            }
            i++;
        }
        return stk.pop();
    }

    public static int cal(int a, int b, char op){
        switch (op){
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
        }
        return -1;
    }
}

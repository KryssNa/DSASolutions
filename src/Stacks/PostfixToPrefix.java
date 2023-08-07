package Stacks;

import java.util.Stack;
public class PostfixToPrefix {

    static boolean isOperator(char x){
        switch (x){
            case '-':
            case '+':
            case '/':
            case '*':
            case '^':
                return true;
        }
        return false;
    }

    public static String convert(String exp){

        Stack<String> st = new Stack<>();
        for (int i = 0; i < exp.length() ; i++) {

            char c = exp.charAt(i);

            if(isOperator(c)){
                String s1 = st.pop();
                String s2 = st.pop();
                String temp = c + s2 + s1;
                st.push(temp);
            }else{
                st.push(c+"");
            }
        }
        String result = st.pop();
        return result;
    }

    public static void main(String[] args) {
        String postfix = "AB+CD-*";
        System.out.println("Postfix exp: " + postfix);
        System.out.println("Prefix exp:"  + convert(postfix));
    }
}
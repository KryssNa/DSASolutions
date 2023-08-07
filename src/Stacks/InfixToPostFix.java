package Stacks;

public class InfixToPostFix {
    int precedence(char c){

        switch ( c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public String infixtopostfixConv(String exp){
        String postfix="";
        Stacks stk=new Stacks(exp.length());
        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                //operand
                postfix=postfix+c;
            }
            else{
                //bracket or operator
                if(c=='('){
                    stk.push(c);
                }
                else if(c==')'){
                    while(!stk.isEmpty() && stk.peek()!='('){
                        postfix=postfix+stk.pop();
                    }
                    stk.pop();
                }
                else{
                    //operator
                    while(!stk.isEmpty() && precedence(c)<= precedence((char) stk.peek()) && !isRightAssociation(c)){
                        postfix=postfix+stk.pop();
                    }
                    stk.push(c);
                }
            }
        }
        while(!stk.isEmpty()){
            postfix=postfix+stk.pop();
        }
        return postfix;
    }

    boolean isRightAssociation(char c){
        return c=='^';
    }
}

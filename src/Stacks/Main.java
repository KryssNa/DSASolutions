package Stacks;

public class Main {
    public boolean checkParenthesis(String exp){
        String openbracket="[{(";
        String closedbracket="]})";
        Stacks stk=new Stacks(exp.length());

        for(int i=0;i<exp.length();i++){
            char expchar=exp.charAt(i);
            if(openbracket.indexOf(expchar)>=0){
                stk.push(expchar);
            }
            else{
                int indx=closedbracket.indexOf(expchar);
                int crossopeningbracket=openbracket.charAt(indx);
                if(stk.isEmpty()){
                    return false;
                }
                if(crossopeningbracket!=stk.pop()){
                    return  false;
                }
            }
        }
        if(!stk.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
      Main m=new Main();
        System.out.println(m.checkParenthesis("[{()}]"));
    }
}
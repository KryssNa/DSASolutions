package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class nQueens {
    static boolean isSafe(char [][] board,int row,int col){

        //checking vertical condition
        for(int i=0;i<board.length;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //checking horizontal condition
        for(int i=0;i<board.length;i++){
            if(board[row][i]=='Q'){
                return false;
            }
        }
        //checking upper left diagonal condition

        int i=row;
        for(int j=col; i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //checking down right diagonal condition

         i=row;
        for(int j=col; i<board.length && j<board.length;i++,j++){
            if(board[i][j]=='Q'){
                return false;

            }
        }

        //checking upper right diagonal condition
        i=row;
        for(int j=col;i>=0&&j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //checking down left diagonal condition
        i=row;
        for(int j=col;j>=0&&i<board.length;i++,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    static void helper(char [][] board,int col,List<List<String>> soln){
        int count=0;
        if(col==board.length){
          //save soln
            }
            return;
    }

    public static void main(String [] args){

        List<List<String>> soln=new ArrayList<>();
        char board[][]=new char[4][4];
        helper(board,0,soln);
        System.out.println(soln);
    }

}

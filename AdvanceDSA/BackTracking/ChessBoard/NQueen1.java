package AdvanceDSA.BackTracking.ChessBoard;

public class NQueen1 {
    /*
            //----This code is only for placing n Queens in n rows 
            //    As we know in a row only one queen we can put in nQueen problem
            //    for making it easy we should know how we can put a queen in a row
            //    or how we can place n queens in n rows

            //Time complexity  : O(n^n) 
            //Because  q1 --- > having nchoices
                       q2 --- > having nchoices
                       q3 --- > having nchoices
                       q4 --- > having nchoices
                       .......
                       qn --- > having nchoices
    */
	public static void main(String[] args) {
	    int n = 3;
		char[][] board = new char[n][n];
		
		for(int i=0 ; i<n ; i++){
		    for(int j=0 ; j<n ; j++){
		        board[i][j] = 'X';
		    }
		}
		
		nQueen(board,0);
    }
    
    private static void nQueen(char[][] board,int row){
        if(row == board.length){
            printBoard(board);
            return;
        }
        
        //recursion
        for(int col = 0 ; col < board.length ; col++){
            board[row][col] = 'Q';
            nQueen(board,row+1);
            board[row][col] = 'X';
        }
    }
    
    private static void printBoard(char[][] b){
        System.out.println("==========Board==========");
        for(int i = 0 ; i < b.length ; i++){
            for(int j=0 ; j< b.length ; j++){
                System.out.print(b[i][j] +" ");
            }
            System.out.println();
        }
    }
}

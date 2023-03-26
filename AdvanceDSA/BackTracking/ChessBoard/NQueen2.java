package AdvanceDSA.BackTracking.ChessBoard;

public class NQueen2 {
    /*
            //----This code is only for placing n Queens in n rows 
            Time complexity : O(n!)
                            because : 1 queen is having n choices
                                      2nd q  is having n-1 
                                      3rd q is having n-2
                                      .................1

                                      --> n * (n-1) * (n-2) * (n-3) * (n-4) --------------1
    */
	public static void main(String[] args) {
	    int n = 4;
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
            if(isSafe(board,row,col)){
                board[row][col] = 'Q';
                nQueen(board,row+1);
                board[row][col] = 'X';   
            }
        }
    }
    private static boolean isSafe(char[][] b , int row , int col){
        // as we already had think about every row will have 1 queens
        // and we are filling board from up 
        // there are only 3 unsafe directions 
        
        //up side 
        for(int i = row-1 ; i >= 0 ; i--){
            if(b[i][col] == 'Q') return false;
        }
        // digonally up left
        for(int i = row-1 , j = col - 1; i >= 0 && j >= 0 ; i--,j--){
            if(b[i][j] == 'Q') return false;
        }
        // diagonally up right
        for(int i = row-1 , j = col + 1; i >= 0 && j < b.length ; i--,j++){
            if(b[i][j] == 'Q') return false;
        }
        
        return true;
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
